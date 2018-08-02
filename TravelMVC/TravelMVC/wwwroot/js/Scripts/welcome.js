window.onload = function() {
    getAllDestinationsIndex();
};


function getAllDestinationsIndex() {
    $.ajax({
        url:'http://localhost:8080/api/destination                                                 ',
        type:'get',
        success:function(response){
            var table_body = '<table border="1" id="example" class = "table table-hover"><thead><tr><th>Sr No</th><th>Name</th><th>City</th><th>Country</th><th>Website</th></tr></thead><tbody>';

            for(var i = 0; i < response.length; i++){
                table_body+='<tr>';

                table_body +='<td>';
                table_body +=i+1;
                table_body +='</td>';
                table_body +='<td>';
                table_body +=response[i].name;

                table_body +='</td>';

                table_body +='<td>';
                table_body +=response[i].city;
                table_body +='</td>';

                table_body +='<td>';
                table_body +=response[i].country;
                table_body +='</td>';

                table_body +='<td>';
                table_body +=response[i].websiteLink;
                table_body +='</td>';


            table_body+='</tr>';
            }
            table_body+='</tbody></table>';
            $("#tableDiv").html(table_body);
        }
    });

    // for search function.................................. only............................
    $("#search").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("table tr").filter(function(index) {
            if(index>0){
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            }
        });
    });
}

