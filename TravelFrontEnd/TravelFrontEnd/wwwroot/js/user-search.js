$(document).ready(function () {
    $('#button-id').click(function () {
        foo($('#formValueId').val());
    });
});

function followEventManager() {
    $.ajax({
        url: 'http://localhost:8080/api/eventmanager/4/user/5',
        type: 'post',
        success: function (response) {
            alert('Following event manager');
        }
    });
}
function getAllDestinations() {
    $.ajax({
        url: 'http://localhost:8080/api/destination                                                 ',
        type: 'get',
        success: function (response) {
            var table_body = '<table border="1" id="example" class = "table table-hover"><thead><tr><th>Sr No</th><th>Name</th><th>City</th><th>Country</th><th>Type</th><th></th></tr></thead><tbody>';

            for (var i = 0; i < response.length; i++) {
                table_body += '<tr>';


                table_body += '<td>';
                table_body += i + 1;
                table_body += '</td>';
                table_body += '<td>';
                table_body += response[i].name;

                table_body += '</td>';

                table_body += '<td>';
                table_body += response[i].city;
                table_body += '</td>';

                table_body += '<td>';
                table_body += response[i].country;
                table_body += '</td>';

                table_body += '<td>';
                table_body += response[i].destinationType;
                table_body += '</td>';



                table_body += '<td>';

                var buttonId = "updateButton" + i;

                table_body += "<div class='container'><button class='btn .btnView' id=" + buttonId + " onclick='update(" + i + ");' data-toggle='modal' data-target='#product_view'><b>View</b></button></div>";
                table_body += '</td>';
                table_body += '</tr>';
            }
            table_body += '</tbody></table>';
            $("#tableDiv").html(table_body);
        }
    });

    // for search function.................................. only............................
    $("#search").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("table tr").filter(function (index) {
            if (index > 0) {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            }
        });
    });
}
function getUserObject(username) {
    $.ajax({
        url: 'http://localhost:8080/api/user',
        type: 'get',
        data: { username: username },
        success: function (user) {
            getAllUserTrips(user[0].id);
        }
    });
}
function getAllTrips() {
    $.ajax({
        url: 'http://localhost:8080/api/trip',
        type: 'get',
        success: function (response) {
            populateTrips(response);
        }
    });

    // for search function.................................. only............................
    $("#search").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("table tr").filter(function (index) {
            if (index > 0) {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            }
        });
    });
}

function getAllUserTrips(userId) {
    console.log(userId);
    $.ajax({
        url: 'http://localhost:8080/api/user/' + userId + '/trip',
        type: 'get',
        success: function (response) {
            populateTrips(response);
            console.log(response);
        }
    });

    // for search function.................................. only............................
    $("#search").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("table tr").filter(function (index) {
            if (index > 0) {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            }
        });
    });
}

function populateTrips(response) {
    var table_body = '<table border="1" id="example" class = "table table-hover"><thead><tr><th>Sr No</th><th>Name</th><th>City</th><th>Country</th><th>Type</th><th></th></tr></thead><tbody>';
    console.log(response[0].id);
    for (var i = 0; i < response.length; i++) {
        (function (i) {
            $.ajax({
                url: 'http://localhost:8080/api/trip/' + response[i].id + '/destination',
                type: 'get',
                success: function (destinationResponse) {
                    table_body += '<tr>';

                    table_body += '<td>';
                    table_body += i + 1;
                    // index += 1;
                    table_body += '</td>';
                    table_body += '<td>';
                    table_body += destinationResponse.name;

                    table_body += '</td>';

                    table_body += '<td>';
                    table_body += destinationResponse.city;
                    table_body += '</td>';

                    table_body += '<td>';
                    table_body += destinationResponse.country;
                    table_body += '</td>';

                    table_body += '<td>';
                    table_body += destinationResponse.destinationType;
                    table_body += '</td>';

                    table_body += '<td>';

                    var buttonId = "updateButton" + i;

                    table_body += "<div class='container'><button class='btn .btnView' id=" + buttonId + " onclick='updateUser(" + i + ");' data-toggle='modal' data-target='#product_view'><b>View</b></button></div>";
                    table_body += '</td>';
                    table_body += '</tr>';
                    table_body += '</tbody></table>';
                    $("#tableDiv").html(table_body);
                }



            });


        })(i);
    }
}

function getDestination(tripId) {
    $.ajax({
        url: 'http://localhost:8080/api/trip/' + tripId + '/destination',
        type: 'get',
        success: function (response) {
            var table_body = '<table border="1" id="example" class = "table table-hover"><thead><tr><th>Sr No</th><th>Name</th><th>City</th><th>Country</th><th>Type</th><th></th></tr></thead><tbody>';

            for (var i = 0; i < 1; i++) {
                table_body += '<tr>';


                table_body += '<td>';
                table_body += i + 1;
                table_body += '</td>';
                table_body += '<td>';
                table_body += response.name;

                table_body += '</td>';

                table_body += '<td>';
                table_body += response.city;
                table_body += '</td>';

                table_body += '<td>';
                table_body += response.country;
                table_body += '</td>';

                table_body += '<td>';
                table_body += response.destinationType;
                table_body += '</td>';


                table_body += '<td>';

                var buttonId = "updateButton" + i;

                table_body += "<div class='container'><button class='btn .btnView' id=" + buttonId + " onclick='update(" + i + ");' data-toggle='modal' data-target='#product_view'><b>View</b></button></div>";
                table_body += '</td>';
                table_body += '</tr>';
            }
            table_body += '</tbody></table>';
            $("#tableDiv").html(table_body);
        }
    });

    // for search function.................................. only............................
    $("#search").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("table tr").filter(function (index) {
            if (index > 0) {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            }
        });
    });
}

function getAllUsers() {

    $.ajax({
        url: 'http://localhost:8080/api/user                                                 ',
        type: 'get',
        success: function (response) {
            var table_body = '<table border="1" id="example" class = "table table-hover"><thead><tr><th>Sr No</th><th>Name</th><th>Phone Number</th><th>Address</th><th>Date Of Birth</th><th>Username</th><th></th></tr></thead><tbody>';

            for (var i = 0; i < response.length; i++) {
                table_body += '<tr>';


                table_body += '<td>';
                table_body += i + 1;
                table_body += '</td>';

                table_body += '<td>';
                table_body += response[i].firstName + " " + response[i].lastName;
                table_body += '</td>';

                table_body += '<td>';
                table_body += response[i].phoneNumber;
                table_body += '</td>';

                table_body += '<td>';
                table_body += response[i].address;
                table_body += '</td>';

                table_body += '<td>';
                table_body += response[i].dob;
                table_body += '</td>';

                table_body += '<td>';
                table_body += response[i].username;
                table_body += '</td>';




                table_body += '<td>';
                var buttonId = response[i].username;

                table_body += "<div class='container'><button class='btn .btnView' id=" + buttonId + " onclick='updateUser(\"" + response[i].username + "\");' data-toggle='modal' data-target='#id01'><b>Edit</b></button></div>";
                table_body += '</td>';
                table_body += '</tr>';
            }
            table_body += '</tbody></table>';
            $("#tableDiv").html(table_body);
        }
    });

    // for search function.................................. only............................
    $("#search").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("table tr").filter(function (index) {
            if (index > 0) {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            }
        });
    });
}

