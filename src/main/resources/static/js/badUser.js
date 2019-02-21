(function (){

    var serverContext = [[@{/}]];
    }

    function resendToken(){
        $.get(serverContext + "user/resendRegistrationToken?token=" + token,
          function(data){
                window.location.href =
                  serverContext +"login.html?message=" + data.message;
        })
        .fail(function(data) {
            if(data.responseJSON.error.indexOf("MailError") > -1) {
                window.location.href = serverContext + "emailError.html";
            }
            else {
                window.location.href =
                  serverContext + "login.html?message=" + data.responseJSON.message;
            }
        });
    }

})();