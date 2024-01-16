$(document).ready(function () {
    $("#languageSelector").change(function () {
        const selectedOption = $("#languageSelector").val();
        if (selectedOption !== '') {
            window.location.replace('?lang=' + selectedOption);
        }
    });
})
