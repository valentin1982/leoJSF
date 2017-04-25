$(document).ready(function () {
    $('.forgot-pass').click(function(event) {
        $(".pr-wrap").toggleClass("show-pass-reset");
    });

    $('.pass-reset-submit').click(function(event) {
        $(".pr-wrap").removeClass("show-pass-reset");
    });
});

function checkValue(form, message) {

    var userInput = form[form.id + ":username"];

    if (userInput.value ==''){
        alert(message)
        userInput.focus();
        return false;
    }

    return true;
}

function showProgress(data) {

    if (data.status == "begin") {
        document.getElementById('loading_wrapper').style.display = "block";
    } else if (data.status == "success") {
        document.getElementById('loading_wrapper').style.display = "none";
    }
}