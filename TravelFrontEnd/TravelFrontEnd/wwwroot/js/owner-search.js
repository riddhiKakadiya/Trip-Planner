$(document).ready(function () {
    $('#button-id').click(function () {
        foo($('#formValueId').val());
    });
});

function getMyDestinations() {
    var url = 'http://localhost:8080/api/owner';
    $.ajax({
        url: url,
        type: 'get',
        data: { username: $.cookie("name") },
        success: function (response) {
            var owner = response[0];

            url = 'http://localhost:8080/api/owner/' + owner.id + '/destination';
            $.ajax({
                url: url,
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


function displayDataCard1() {

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

function getAllTripRequests() {

    $.ajax({
        url: 'http://localhost:8080/api/trip',
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

                table_body += "<div class='container'><button class='btn .btnView' id=" + buttonId + " onclick='updateOwner(\"" + response[i].username + "\");' data-toggle='modal' data-target='#id01'><b>Edit</b></button></div>";
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