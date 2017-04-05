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
                console.log(rp);
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
        console.log("Yahoo!");

        var columnHeadings = $("thead th").map(function() {
            return $(this).text();
        }).get();
        console.log(columnHeadings);

        columnHeadings.pop();

        var columnValues = $(this).parent().siblings().map(function() {
            return $(this).text();
        }).get();
        console.log(columnValues);

        var modalBody = $('<div id="modalContent"></div>');

        var modalForm = $('<form role="form" id="editContactForm"></form>');

        for (var i=0; i<columnHeadings.length-2; i++) {
            var formGroup = $('<div class="form-group"></div>');
            formGroup.append('<label for="'+columnHeadings[i]+'">'+columnHeadings[i]+'</label>');
            formGroup.append('<input class="form-control" name="'+columnHeadings[i]+i+'" id="'+columnHeadings[i]+i+'" value="'+columnValues[i]+'" />');
            console.log(formGroup);
            modalForm.append(formGroup);
        }

        modalBody.append(modalForm);
        $('.modal-body').html(modalBody);
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

        console.log(contact);

        $.ajax({
            url: '/users/'+currentUserId+'/contacts',
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify(contact),
            contentType: 'application/json',
            success: function (rp) {
                console.log(rp);
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
                    "</tr>");
            }
        });
    });
})();