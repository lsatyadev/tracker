package com.projectstatus.tracker.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ticket {
    private String ticketNumber;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date date;
    private String summary;
    private String primaryOwner;
    private String backupOwner;
    private String status = "New";

    public boolean getIsNew() {
        boolean result = false;
        if(status.equalsIgnoreCase("New")) {
            result = true;
        }

        return result;
    }

    public boolean getIsInProgress() {
        boolean result = false;
        if(status.equalsIgnoreCase("InProgress")) {
            result = true;
        }

        return result;
    }

    public boolean getIsClosed() {
        boolean result = false;
        if(status.equalsIgnoreCase("Closed")) {
            result = true;
        }

        return result;
    }

    public String getDataAsString() {
        if(date == null)
            return "";
        SimpleDateFormat newFormat = new SimpleDateFormat("MM/dd/yyyy");
        return newFormat.format(date);
    }
}
