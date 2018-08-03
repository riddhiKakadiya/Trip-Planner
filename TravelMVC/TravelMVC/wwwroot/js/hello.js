$(document).ready(function(){
    $("#btn_signup").click(function(){

        event.preventDefault();

        var fname = $('#txt_fname').val().trim();
        var lname = $('#txt_lname').val().trim();
        var username = $('#txt_uname').val().trim();
        var address = $('#txt_address').val().trim();
        var email = $('#txt_email').val().trim();
        var phone = $('#txt_phone').val().trim();
        var password = $('#txt_psw').val().trim();
        var rpt_password = $('#txt_psw-repeat').val().trim();

        if( username != "" && password != "" && password === rpt_password){
            var jsonObj = {firstName:fname,lastName:lname,phoneNumber: phone, isAdmin:0,
                address: address, email : email, username : username, password : password};
            $.ajax({
                url:'http://localhost:8080/api/user/register',
                type:'post',
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify(jsonObj),
                success:function(response){
                    var msg = "";
                    if(response != null){
                        window.location = "../public/login.html";
                    }else{
                        msg = "Invalid username and password!";
                    }
                    $("#message").html(msg);
                }
            });
        }
    });
});