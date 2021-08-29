$(document).on("submit","form",function(event){
    event.preventDefault();

    var nazivTreninga=$("#nazivTreninga").val();
    var cena=$("#cena").val();
    var datumPocetkaTreninga=$("#datumPocetkaTreninga").val();
  //  var sala=$("#sala").val();
    var newFitnesCentarJSON=formToJSON(nazivTreninga,cena,datumPocetkaTreninga);
    $.ajax({
        type:"POST",
        url:"http://localhost:8181/api/termini/kreiranje",
        dataType:"json",
        contentType:"application/json",
        data: newFitnesCentarJSON,
        success:function(){
            alert("Uspesno ste dodali novi termin ");
            window.location.href="izmenaTermina.html";
        }
    });
});
function formToJSON(nazivTreninga,cena,datumPocetkaTreninga){
    return JSON.stringify({
        "nazivTreninga":nazivTreninga,
        "cena":cena,
        "datumPocetkaTreninga":datumPocetkaTreninga //,
       // "sala":sala
    });
}