$(document).ready(function(){

    $.ajax({
        type:"GET",
        url: "http://localhost:8090/api/pregledTreninga",
        dataType:"json",
        success: function(data){
            console.log("SUCCESS: ", data);
            for(i=0;i<data.length;i++){
                var row="<tr>";
                row +="<td>" + data[i]['naziv'] + "</td>";
                row +="<td>" + data[i]['tipTreninga'] + "</td>";
                row +="<td>" + data[i]['trajanje'] +"</td>";
                $('#treninzi').append(row);
            }
        },
        error: function (data){
            console.log("ERROR: ", data);
        }
    });
});