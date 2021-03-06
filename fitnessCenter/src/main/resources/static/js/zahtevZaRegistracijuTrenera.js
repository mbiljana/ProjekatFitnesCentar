$(document).ready(function(){

    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/korisnik/zahteviZaRegistracijuTrenera",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
                row += "<td>" + data[i]['ime'] + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['prezime']  + "</td>";
                row += "<td>" + data[i]['email'] + "</td>";
                row += "<td>" + data[i]['telefon'] + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#zahteviZaRegistracijuTrenera').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });
    let selektovanRed = 0;
    let staraBoja = null;
    $("#zahteviZaRegistracijuTrenera").on('click', 'tr:not(:first-child)', function() {
        if (staraBoja != null) {
            $('#zahteviZaRegistracijuTrenera tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja); // vracamo staru boju
        }
        selektovanRed = this.dataset.id;                    // cuvamo id selektovanog termina
        staraBoja = $(this).css('background-color');        // cuvamo staru boju da bi vratili kad se odselektuje

        $(this).css('background-color', '#a6c9e2');         // postavljamo novu boju
        console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
    });

    $("#odobri").click(function() {
        var obj = JSON.stringify({
            "idKorisnika" : selektovanRed

        });
        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/korisnik/odobriRegistraciju",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function (data) {
                console.log("SUCCESS : ", data);
                window.location.href = "home.html";

            },
            error: function (data) {
                alert("Greška!");
                console.log("ERROR : ", data);
            }
        });
    });



});