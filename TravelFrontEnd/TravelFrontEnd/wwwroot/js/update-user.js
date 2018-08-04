$(document).ready(function () {
    $("#btn_signup").click(function () {

        event.preventDefault();

        var fname = $('#txt_fname').val().trim();
        var lname = $('#txt_lname').val().trim();
        var username = $('#txt_uname').val().trim();
        var address = $('#txt_address').val().trim();
        var email = $('#txt_email').val().trim();
        var phone = $('#txt_phone').val().trim();
        var password = $('#txt_psw').val().trim();
        var rpt_password = $('#txt_psw-repeat').val().trim();

        if (username != "" && password != "" && password === rpt_password) {
            var jsonObj = {
                firstName: fname, lastName: lname, phoneNumber: phone,
                address: address, email: email, username: username, password: password
            };
            $.ajax({
                url: 'http://localhost:8080/api/user/register',
                type: 'post',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(jsonObj),
                success: function (response) {

                }
            });
        }
    });

    $("#btn_update").click(function () {

        event.preventDefault();

        var fname = $('#txt_fname').val().trim();
        var lname = $('#txt_lname').val().trim();
        var username = $('#txt_uname').val().trim();
        var address = $('#txt_address').val().trim();
        var email = $('#txt_email').val().trim();
        var phone = $('#txt_phone').val().trim();

        var jsonObj = {
            firstName: fname, lastName: lname, phoneNumber: phone,
            address: address, email: email, username: username
        };
        $.ajax({
            url: 'http://localhost:8080/api/user/5',
            type: 'put',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(jsonObj),
            success: function (response) {
            }
        });
    });
});




function updateUser(user) {

    var url = 'http://localhost:8080/api/user/';
    var userObj;
    $.ajax({
        url: url,
        type: 'get',
        data: { username: user },
        success: function (response) {
            userObj = response[0];
            $("#txt_fname").attr("value", userObj.firstName);
            $("#txt_lname").attr("value", userObj.lastName);
            $("#txt_phone").attr("value", userObj.phoneNumber);
            $("#txt_address").attr("value", userObj.address);
            $("#txt_email").attr("value", userObj.email);
            $("#txt_uname").attr("value", userObj.username);
        }
    });
}


function updateOwner(user) {

    var url = 'http://localhost:8080/api/owner/';
    var userObj;
    $.ajax({
        url: url,
        type: 'get',
        data: { username: user },
        success: function (response) {
            userObj = response[0];
            $("#txt_fname").attr("value", userObj.firstName);
            $("#txt_lname").attr("value", userObj.lastName);
            $("#txt_phone").attr("value", userObj.phoneNumber);
            $("#txt_address").attr("value", userObj.address);
            $("#txt_email").attr("value", userObj.email);
            $("#txt_uname").attr("value", userObj.username);
        }
    });
}


