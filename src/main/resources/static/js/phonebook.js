(function (){

    function getAllContactsForSelectedUser(userId){
        $.ajax({
            url: 'http://localhost:8080/users/'+userId+'/contacts',
            method: 'GET',
            success: function (response) {
                        console.log(response);
                        return drawContact(response);
                    }               
        });
    }
    
    function drawContact(rp){
        console.log(rp);
        for (var i=0; i<rp.length; i++) {
            $(".table-striped > tbody").append(
                "<tr><td>"+rp[i].contactId+"</td><td>"+rp[i].firstName+"</td><td>"+rp[i].lastName+"</td><td>"+rp[i].patronymic+"</td><td>"+rp[i].mobilePhoneNumber+"</td><td>"+rp[i].homePhoneNumber+"</td><td>"+rp[i].address+"</td><td>"+rp[i].email+"</td></tr>");
        }
    }

    getAllContactsForSelectedUser(1);
})();