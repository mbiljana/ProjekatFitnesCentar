$(document).ready(function(){

    $("#registracijaKorisnika").submit(function(event) {

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
            "datumRodjenja" : datumRodjenja,
            "uloga" : "CLAN"
        });

        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/clanovi",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function () {
                alert(obj);
                window.location.href = "pocetna.html";
            },
            error: function (data) {
                alert("Da li se poruka prenela?");
                alert(data);
                alert("Izgleda da jeste");
            }
        });


    });
});