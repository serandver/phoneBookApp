(function (){
     $("#locales").change(function () {
            var selectedOption = $('#locales').val();
            if (selectedOption != ''){
                window.location.replace('index?lang=' + selectedOption);
            }
        });
})();