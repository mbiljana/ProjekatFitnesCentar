$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/pregledTreninga",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trening of response) {
                let row = "<tr>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tip + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "</tr>";

                $('#pregledTreninga').append(row);
            }
        },
        error: function (response) {
        }
    });
});

$(document).on('click','#sortNaziv',function(){
    $.ajax({
        type:"GET",
        url:"http://localhost:8090/api/pregledTreninga/sortNaziv",
        dataType:"json",
        success:function(data){

            console.log("SUCCESS: ",data);
            $('#pregledTreninga td').remove();
            for(i=0;i<data.length;i++){
                var row="<tr>";
                row +="<td>" + data[i]['naziv'] + "</td>";
                row +="<td>" + data[i]['opis'] + "</td>";
                row +="<td>" + data[i]['tip'] +"</td>";
                row +="<td>" + data[i]['trajanje'] +"</td>";
                $('#pregledTreninga').append(row);
            }
        },
        error:function(data){
            console.log("ERROR: ",data);
        }

    });
});

$(document).on('click','#sortTipTreninga',function(){
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/pregledTreninga/sortTipTreninga",
        dataType:"json",
        success:function(data){

            console.log("SUCCESS: ",data);
            $('#pregledTreninga td').remove();
            for(i=0;i<data.length;i++){
                var row="<tr>";
                row +="<td>" + data[i]['naziv'] + "</td>";
                row +="<td>" + data[i]['opis'] + "</td>";
                row +="<td>" + data[i]['tip'] +"</td>";
                row +="<td>" + data[i]['trajanje'] +"</td>";
                $('#pregledTreninga').append(row);
            }
        },
        error:function(data){
            console.log("ERROR: ",data);
        }

    });
});