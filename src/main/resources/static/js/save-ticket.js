$(document).ready(function() {
    $('#datepicker').datepicker({
        uiLibrary: 'bootstrap4'
    });

    $('#saveTicket').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            ticketNumber: {
                notEmpty: {
                    message: 'TicketNumber is required and cannot be empty'
                }
            }
        }
    });

    /*bootstrapValidate('#ticketNumber', 'tickerNumber:Enter a valid Ticket Number!');*/
});
