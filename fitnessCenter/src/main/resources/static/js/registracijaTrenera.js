$(document).ready(function(){

    $("#addTrenerForm").submit(function(event) {

        event.preventDefault();
        var korisnickoIme = $("#korisnickoIme").val();
        var lozinka = $("#lozinka").val();
        var ime = $("#ime").val();
        var prezime = $("#prezime").val();
        var telefon = $("#telefon").val();
        var email = $("#email").val();
        var datumRodjenja = $("#datumRodjenja").val();

        var obj = JSON.stringify({
            "korisnickoIme" : korisnickoIme,
            "lozinka" : lozinka,
            "ime" : ime,
            "prezime" : prezime,
            "telefon" : telefon,
            "email" : email,
            "telefon" : telefon,
            "datumRodjenja" : datumRodjenja,
            "uloga" : 1
        });

        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/korisnik/registrujTrenera",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function () {
                alert(obj);
                window.location.href = "zahtevZaRegistracijuTrenera.html";
            },
            error: function (data) {
                alert("Da li se poruka prenela?");
                alert(data);
                alert("Izgleda da jeste");
            }
        });


    });
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/korisnik/zahteviZaRegistracijuTrenera",
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

                $('#zahteviZaRegistracijuTrenera').append(row);
            }
        },
        error: function (response) {
        }
    });
});










/* $(document).ready(function() {

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

 */