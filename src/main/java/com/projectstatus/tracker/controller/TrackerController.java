package com.projectstatus.tracker.controller;

import com.projectstatus.tracker.TrackerService;
import com.projectstatus.tracker.pojo.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class TrackerController {
    @Autowired
    TrackerService service;

    @RequestMapping("/")
    public String welcomePage(Model model, @ModelAttribute("ticketSaved") String saveStatus, @ModelAttribute("ticketDeleted") String deleteStatus) {
        model.addAttribute("ticketList", service.getTickets());
        if(!StringUtils.isEmpty(saveStatus)) {
            model.addAttribute("ticketSaved", Boolean.TRUE);
        } else {
            model.addAttribute("ticketSaved", Boolean.FALSE);
        }

        if(!StringUtils.isEmpty(deleteStatus)) {
            model.addAttribute("ticketDeleted", Boolean.TRUE);
        } else {
            model.addAttribute("ticketDeleted", Boolean.FALSE);
        }

        return "index";
    }

    @RequestMapping("/renderaddnew")
    public String renderAddNewTicket(Model model) {
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("addNewTicket", Boolean.TRUE);

        return "add-new-item";
    }

    @PostMapping("/saveticket")
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket, RedirectAttributes redirectAttributes) {
        log.info(ticket.toString());
        service.saveTicket(ticket);
        redirectAttributes.addFlashAttribute("ticketSaved", Boolean.TRUE);

        return "redirect:/";
    }

    @GetMapping("/editticket/{ticketNumber}")
    public ModelAndView editTicket(@PathVariable("ticketNumber") String ticketNumber) {
        ModelAndView mv = new ModelAndView("add-new-item");
        mv.addObject("ticket", service.getTicket(ticketNumber).get());
        mv.addObject("updateTicket", Boolean.TRUE);

        return mv;
    }

    @PostMapping("/deleteticket")
    public String deleteTicket(@RequestParam String ticketNumber, RedirectAttributes redirectAttributes) {
        service.deleteTicket(ticketNumber);
        redirectAttributes.addFlashAttribute("ticketDeleted", Boolean.TRUE);

        return "redirect:/";
    }



}
