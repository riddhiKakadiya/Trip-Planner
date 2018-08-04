function deleteUser(username) {
    console.log("Deleting User");
    var url = 'http://localhost:8080/api/user';

    $.ajax({
        url: url,
        type: 'get',
        data: { username: username },
        success: function (response) {
            console.log(response);
            user = response[0];

            url = 'http://localhost:8080/api/user/' + user.id;

            $.ajax({
                url: url,
                type: 'delete',
                success: function (response) {
                    console.log(response);
                    window.location.reload();
                }
            });
        }

    });
}



function deleteOwner(username) {
    console.log("Deleting Owner");
    var url = 'http://localhost:8080/api/owner';

    $.ajax({
        url: url,
        type: 'get',
        data: { username: username },
        success: function (response) {
            console.log(response);
            user = response[0];

            url = 'http://localhost:8080/api/owner/' + user.id;

            $.ajax({
                url: url,
                type: 'delete',
                success: function (response) {
                    console.log(response);
                    window.location.reload();
                }
            });
        }

    });
}


function deleteManager(username) {
    console.log("Deleting Manager");
    var url = 'http://localhost:8080/api/eventmanager';

    $.ajax({
        url: url,
        type: 'get',
        data: { username: username },
        success: function (response) {
            console.log(response);
            user = response[0];

            url = 'http://localhost:8080/api/eventmanager/' + user.id;

            $.ajax({
                url: url,
                type: 'delete',
                success: function (response) {
                    console.log(response);
                    window.location.reload();


                }
            });
        }

    });
}
