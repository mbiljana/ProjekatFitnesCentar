$(document).on("submit","form",function(event){
    event.preventDefault();

    var naziv=$("#nazivCentra").val();
    var adresa=$("#adresaCentra").val();
    var email=$("#emailCentra").val();
    var brojCentrale=$("#brojTelefonaCentrale").val();
    var newBioskopJSON=formToJSON(naziv,adresa,email,brojCentrale);
    $.ajax({
        type:"POST",
        url:"http://localhost:8090/api/sviFitnesCentri",
        dataType:"json",
        contentType:"application/json",
        data: newBioskopJSON,
        success:function(){
            alert("Uspesno ste dodali fitnes centar "+naziv);
            window.location.href="sviFitnesCentri.html";
        }
    });
});