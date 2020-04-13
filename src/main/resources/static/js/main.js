$(document).ready(function () {
	$('#mydatatable').DataTable();
});

$('#deleteModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget); // Button that triggered the modal
  var recipient = button.data('whatever'); // Extract info from data-* attributes
  var modal = $(this);
  console.log("ticketNumber: " + recipient);
  modal.find('input[type=hidden][name=ticketNumber]').val(recipient);
  console.log($("input[type=hidden][name=ticketNumber]").val());
});