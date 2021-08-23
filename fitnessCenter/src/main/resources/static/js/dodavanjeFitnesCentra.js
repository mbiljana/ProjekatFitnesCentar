$(document).ready(function(){

    $("#sviFitnesCentri").submit(function(event) {

        event.preventDefault();
        var nazivCentra = $("#nazivCentra").val();
        var adresaCentra = $("#adresaCentra").val();
        var brojTelefonaCentrale = $("#brojTelefonaCentrale").val();
        var emailCentra = $("#emailCentra").val();
        var obj = JSON.stringify({
            "nazivCentra" : nazivCentra,
            "adresaCentra" : adresaCentra,
            "brojTelefonaCentrale" : brojTelefonaCentrale,
            "emailCentra" : emailCentra,

        });

        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/sviFitnesCentri",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function () {
                alert(obj);
                window.location.href = "brisanjeFitnesCentra.html";
            },
            error: function (data) {
                alert("Da li se poruka prenela?");
                alert(data);
                alert("Izgleda da jeste");
            }
        });


    });

});