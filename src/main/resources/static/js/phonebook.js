(function (){

    // hardcoded value of current user
    var currentUser = {
        userId: 1,
        userName: "userLogin 1",
        password: "userPassword 1",
        fio: "userNameAndSurname 1"
    };

    var currentUserId = currentUser.userId;

    function getAllContactsForSelectedUser(currentUserId){
        $.ajax({
            url: '/users/'+currentUserId+'/contacts',
            type: 'GET',
            success: function (rp) {
                for (var i=0; i<rp.length; i++) {
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
                        "<td><button class=\"btn btn-success btn-sm\">Delete</button></td>"+
                        "/tr>");
                }
            }
        });
    }

    getAllContactsForSelectedUser(currentUserId);


    $('body').on('click', 'button.edit-modal', function() {

        var columnHeadings = $("thead th").map(function() {
            return $(this).text();
        }).get();

        columnHeadings.pop();

        var columnValues = $(this).parent().siblings().map(function() {
            return $(this).text();
        }).get();

        var modalBody = $('<div id="modalContent"></div>');
        var modalForm = $('<form role="form" id="editContactForm"></form>');

        for (var i=0; i<columnHeadings.length-1; i++) {
            var formGroup = $('<div class="form-group"></div>');
            if (i != 0) {
                formGroup.append('<label for="column'+i+'">'+columnHeadings[i]+'</label>');
                formGroup.append('<input class="form-control" name=column'+i+' id=column'+i+' value="'+columnValues[i]+'" />');
            }
            else {
                formGroup.append('<label for="column'+i+'">'+columnHeadings[i]+'</label>');
                formGroup.append('<p class="form-control-static" id=column'+i+'>'+columnValues[i]+'</p>');
            }
            modalForm.append(formGroup);
        }

        modalBody.append(modalForm);
        $('.modal-body').html(modalBody);

        var contactForEditing = {
            contactId: $("#column0").text(),
            firstName: $("#column1").val(),
            lastName:$("#column2").val(),
            patronymic:$("#column3").val(),
            mobilePhoneNumber: $("#column4").val(),
            homePhoneNumber:$("#column5").val(),
            address:$("#column6").val(),
            email: $("#column7").val(),
            user: currentUser
        };

        console.log("contact for editing: ");
        console.log(contactForEditing);
    });

    $('#editModal').on('click', '#editContact', function() {

        // $("#editContact").click(function () {
        var editedContact = {
            contactId: $("#column0").text(),
            firstName: $("#column1").val(),
            lastName:$("#column2").val(),
            patronymic:$("#column3").val(),
            mobilePhoneNumber: $("#column4").val(),
            homePhoneNumber:$("#column5").val(),
            address:$("#column6").val(),
            email: $("#column7").val(),
            user: currentUser
        };

        console.log("edited contact before sending to database: ");
        console.log(editedContact);

        $.ajax({
            url: '/users/'+currentUserId+'/contacts/'+editedContact.contactId,
            type: 'PUT',
            dataType: 'json',
            data: JSON.stringify(editedContact),
            contentType: 'application/json',
            success: function (rp) {
                console.log("edited contact returned from database: ");
                console.log(rp);
                $(".table-striped > tbody:first-child").has(rp.contactId).html("<tr>"+
                    "<td>"+rp.contactId+"</td>"+
                    "<td>"+rp.firstName+"</td>"+
                    "<td>"+rp.lastName+"</td>"+
                    "<td>"+rp.patronymic+"</td>"+
                    "<td>"+rp.mobilePhoneNumber+"</td>"+
                    "<td>"+rp.homePhoneNumber+"</td>"+
                    "<td>"+rp.address+"</td>"+
                    "<td>"+rp.email+"</td>"+
                    "<td><button class=\"btn btn-success btn-sm edit-modal\" data-toggle=\"modal\" data-target=\"#editModal\" contenteditable=\"false\">Edit</button></td>"+
                    "<td><button class=\"btn btn-success btn-sm\">Delete</button></td>"+
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
                    "<td><button class=\"btn btn-success btn-sm\">Delete</button></td>"+
                    "</tr>"
                );
            }
        });
    });
})();