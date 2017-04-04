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
                    $(".table-striped > tbody").append("<tr><td>"+rp[i].contactId+"</td><td>"+rp[i].firstName+"</td><td>"+rp[i].lastName+"</td><td>"+rp[i].patronymic+"</td><td>"+rp[i].mobilePhoneNumber+"</td><td>"+rp[i].homePhoneNumber+"</td><td>"+rp[i].address+"</td><td>"+rp[i].email+"</td></tr>");
                }
            }
        });
    }
   
    getAllContactsForSelectedUser(currentUserId);
    

   

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
                $(".table-striped > tbody tr:last").after("<tr><td>"+rp.contactId+"</td><td>"+rp.firstName+"</td><td>"+rp.lastName+"</td><td>"+rp.patronymic+"</td><td>"+rp.mobilePhoneNumber+"</td><td>"+rp.homePhoneNumber+"</td><td>"+rp.address+"</td><td>"+rp.email+"</td></tr>");
            },
        });
    })

})();