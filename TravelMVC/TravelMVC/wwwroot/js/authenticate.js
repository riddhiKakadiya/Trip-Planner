$(document).ready(function() {
    $('#submit').click(function() {

        event.preventDefault(); // prevent PageReLoad

        // console.log(1)
        console.log($('#username').val());
        console.log($('#password').val());


        var username = $("#username").val().trim();
        var password = $("#password").val().trim();



        var msg = "";
        var object = {username : username, password : password};
        var by_pass = 0


        if( username != "" && password != ""){
            console.log("In if");
            $.ajax({
                url:'http://localhost:8080/api/user/login',
                type:'post',
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify(object),
                success:function(response){

                    if(response == 1){
                        console.log(response);
                        $.cookie("name", username);
                        $.cookie("type", response);

                        window.location.href = "../public/Profile/admin-profile.html";
                    } else if(response == 2){
                        console.log(response);
                        $.cookie("name", username);
                        $.cookie("type", response);

                        window.location.href = "../public/Profile/user-profile.html";
                    }else if(response == 3){
                        $.cookie("name", username);
                        $.cookie("type", response);

                        window.location.href = "../public/Profile/owner-profile.html";
                    }else if(response == 4){
                        $.cookie("name", username);
                        $.cookie("type", response);

                        window.location.href = "../public/Profile/eventmanager-profile.html";;
                    } else{
                        msg = "Invalid username and password!";
                        console.log(msg);

                    }
                }
            });
        }

    });
});

function logout() {
    $.cookie('name', '');
    $.cookie('type', '');
    window.location.href = "../login.html";
}