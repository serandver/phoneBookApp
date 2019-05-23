(function (){


//    var currentUserId = 1;
    var currentUserId = $('#currentUserId').val();

    function getAllContactsForSelectedUser(currentUserId){
        $.ajax({
            url: '/users/' + currentUserId + '/contacts',
            type: 'GET',
            success: function (rp) {
                for (var i = 0; i < rp.length; i++) {
                    $(".table-striped > tbody").append(
                        "<tr>"+
                        "<td>"+rp[i].contactId+"</td>"+
                        "<td>"+rp[i].firstName+"</td>"+
                        "<td>"+rp[i].lastName+"</td>"+
                        "<td>"+rp[i].patronymic+"</td>"+
                        "<td>"+rp[i].mobilePhoneNumber+"</td>"+
                        "<td>"+rp[i].homePhoneNumber+"</td>"+
                        "<td>"+rp[i].address+"</td>"+
                        "<td>"+rp[i].email+"</td>"+
                        "<td><button class=\"btn btn-success btn-sm edit-modal\" data-toggle=\"modal\" data-target=\"#editModal\" contenteditable=\"false\">Edit</button></td>"+
                        "<td><button class=\"btn btn-success btn-sm delete\">Delete</button></td>"+
                        "/tr>");
                }
            }
        });
    }

    getAllContactsForSelectedUser(currentUserId);


    $('body').on('click', 'button.edit-modal', function() {

        var columnValues = $(this).parent().siblings().map(function() {
            return $(this).text();
        }).get();

        $("#contactId").text(columnValues[0]);
        $("#editFirstName").val(columnValues[1]);
        $("#editLastName").val(columnValues[2]);
        $("#editPatronymic").val(columnValues[3]);
        $("#editMobilePhoneNumber").val(columnValues[4]);
        $("#editHomePhoneNumber").val(columnValues[5]);
        $("#editAddress").val(columnValues[6]);
        $("#editInputEmail").val(columnValues[7]);

    });

    $('#editModal').on('click', '#editContact', function() {

        var contactToSave = {
            contactId: $("#contactId").text(),
            firstName: $("#editFirstName").val(),
            lastName:$("#editLastName").val(),
            patronymic:$("#editPatronymic").val(),
            mobilePhoneNumber: $("#editMobilePhoneNumber").val(),
            homePhoneNumber:$("#editHomePhoneNumber").val(),
            address:$("#editAddress").val(),
            email: $("#editInputEmail").val(),
            user: currentUser
        };

        $.ajax({
            url: '/users/'+currentUserId+'/contacts/'+contactToSave.contactId,
            type: 'PUT',
            dataType: 'json',
            data: JSON.stringify(contactToSave),
            contentType: 'application/json',
            success: function (rp) {
                $("td").filter(function() {
                    return $(this).text() == rp.contactId;
                }).closest("tr").replaceWith("<tr>"+
                    "<td>"+rp.contactId+"</td>"+
                    "<td>"+rp.firstName+"</td>"+
                    "<td>"+rp.lastName+"</td>"+
                    "<td>"+rp.patronymic+"</td>"+
                    "<td>"+rp.mobilePhoneNumber+"</td>"+
                    "<td>"+rp.homePhoneNumber+"</td>"+
                    "<td>"+rp.address+"</td>"+
                    "<td>"+rp.email+"</td>"+
                    "<td><button class=\"btn btn-success btn-sm edit-modal\" data-toggle=\"modal\" data-target=\"#editModal\" contenteditable=\"false\">Edit</button></td>"+
                    "<td><button class=\"btn btn-success btn-sm delete\">Delete</button></td>"+
                    "</tr>");
            }
        });
    });

    $("#addContact").click(function () {
        var contact = {
            firstName: $("#firstName").val(),
            lastName:$("#lastName").val(),
            patronymic:$("#patronymic").val(),
            mobilePhoneNumber: $("#mobilePhoneNumber").val(),
            homePhoneNumber:$("#homePhoneNumber").val(),
            address:$("#address").val(),
            email: $("#inputEmail").val(),
            user: currentUser
        };

        $.ajax({
            url: '/users/'+currentUserId+'/contacts',
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify(contact),
            contentType: 'application/json',
            success: function (rp) {
                $(".table-striped > tbody tr:last").after(
                    "<tr>"+
                    "<td>"+rp.contactId+"</td>"+
                    "<td>"+rp.firstName+"</td>"+
                    "<td>"+rp.lastName+"</td>"+
                    "<td>"+rp.patronymic+"</td>"+
                    "<td>"+rp.mobilePhoneNumber+"</td>"+
                    "<td>"+rp.homePhoneNumber+"</td>"+
                    "<td>"+rp.address+"</td>"+
                    "<td>"+rp.email+"</td>"+
                    "<td><button class=\"btn btn-success btn-sm edit-modal\" data-toggle=\"modal\" data-target=\"#editModal\" contenteditable=\"false\">Edit</button></td>"+
                    "<td><button class=\"btn btn-success btn-sm delete\">Delete</button></td>"+
                    "</tr>"
                );
            }
        });
    });

    $('body').on('click', 'button.delete', function() {

        if (confirm("Do you really want to delete this contact?")) {
            var contactId = $(this).parent().siblings().map(function () {
                return $(this).text();
            }).get()[0];

            var tr = $(this).closest('tr');

            $.ajax({
                url: '/users/' + currentUserId + '/contacts/' + contactId,
                type: 'DELETE',
                success: function () {
                    tr.remove();
                }
            });
        }
    })
})();