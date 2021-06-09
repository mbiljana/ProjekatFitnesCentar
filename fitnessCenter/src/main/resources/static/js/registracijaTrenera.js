$(document).ready(function() {

    $.ajax({
        type: "POST",
        url: "http://localhost:8090/api/korisnik/registrujTrenera",
        dataType: "json",
        contentType: "application/json",
        data: obj,
        success: function () {
            alert(obj);
            window.location.href = "pregledZahtevaZaRegTrenera.html";
        },
        error: function (data) {
            alert("Greska");
        }
    });


    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/korisnik/zahteviZaRegistraciju",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            for (let trener of response) {
                let row = "<tr>";
                row += "<td>" + trener.ime + "</td>";
                row += "<td>" + trener.prezime + "</td>";
                row += "<td>" + trener.email + "</td>";
                row += "<td>" + trener.telefon + "</td>";
                row += "</tr>";

                $('#zahtevi').append(row);
            }
        },
        error: function (response) {
        }
    });
});