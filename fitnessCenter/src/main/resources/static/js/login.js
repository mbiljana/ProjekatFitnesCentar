$(document).ready(function(){

    $("#loginKorisnikForm").submit(function(event) {

        event.preventDefault();
        var korisnickoIme = $("#korisnickoIme").val();
        var lozinka = $("#lozinka").val();

        var obj = JSON.stringify({
            "korisnickoIme" : korisnickoIme,
            "lozinka" : lozinka
        });

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/korisnik/login",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function (data) {

                console.log("SUCCESS : ", data);

                localStorage.setItem('Id', data.id);
                localStorage.setItem('Ime', data.ime);
                localStorage.setItem('Prezime', data.prezime);
                localStorage.setItem('KorisnickoIme', data.korisnickoIme);
                localStorage.setItem('BrojTelefona', data.kontaktTelefon);
                //localStorage.setItem('Uloga', data.uloga);
                localStorage.setItem('Mail', data.eadresa);
                localStorage.setItem('DatumRodjenja', data.datumRodjenja);

                window.location.href = "index.html";
            },
            error: function (data) {
                console.log("ERROR " + JSON.stringify(data));
                alert("Nalog nije aktivan, proverite unos!");
            }
        });
    });
});