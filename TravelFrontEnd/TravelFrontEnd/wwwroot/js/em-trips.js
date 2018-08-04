function addToTrips(manager) {
    $.ajax({
        url: 'http://localhost:8080/api/user',
        type: 'get',
        data: { username: manager.managerName },
        success: function (eventmanager) {
            // getAllTrips(user[0].id);
            createTrip(eventmanager, manager.destinationId);
        }
    });
}


function createTrip(emanager, destId) {
    var eventManager = emanager[0];
    var obj = { eventManager: { id: eventManager.id }, destination: { id: destId } };
    console.log(obj);
    $.ajax({
        url: 'http://localhost:8080/api/trip',
        type: 'post',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(obj),
        success: function (response) {
            console.log('Success' + response);
        }
    });
}

function populateTrips(response) {
    var table_body = '<table border="1" id="example" class = "table table-hover"><thead><tr><th>Sr No</th><th>Name</th><th>City</th><th>Country</th><th>Type</th><th></th></tr></thead><tbody>';
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
var MyTrips = {
    getMyTrips: function (arg) {
        $.ajax({
            url: 'http://localhost:8080/api/eventmanager/' + arg + '/trip',
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
}
