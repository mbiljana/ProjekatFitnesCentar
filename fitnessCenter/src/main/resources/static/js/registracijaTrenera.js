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