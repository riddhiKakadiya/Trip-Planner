function getAllReviews(place) {

    var response = place.reviews;

    var table_body = '<table border="1" id="example" class = "table table-hover"><thead><tr><th>Sr No</th><th>Name</th><th>Text</th><th>Rating</th><th>Time</th><th></th></tr></thead><tbody>';
    for (var i = 0; i < place.reviews.length; i++) {
        table_body += '<tr>';

        table_body += '<td>';
        table_body += i + 1;

        table_body += '</td>';
        table_body += '<td>';
        table_body += response[i].author_name;

        table_body += '</td>';

        table_body += '<td>';
        table_body += response[i].text;
        table_body += '</td>';

        table_body += '<td>';
        table_body += response[i].rating;
        table_body += '</td>';

        table_body += '<td>';
        table_body += response[i].relative_time_description;
        table_body += '</td>';



        table_body += '<td>';

        var buttonId = "updateButton" + i;
        var arg = {
            review: place.reviews[i],
            user: $.cookie("name")
        };
        table_body += "<div class='container'><button class='btn .btnView' id=" + buttonId + " onclick='likeReview(" + JSON.stringify(arg) + ");'><b>Like</b></button></div>";
        table_body += '</td>';
        table_body += '</tr>';
        var review = place.reviews[i];

    }
    table_body += '</tbody></table>';
    $("#tableDiv").html(table_body);
}