function update(index) {
    var buttonId = "#updateButton" + index;
    var url = 'http://localhost:8080/api/destination/' + (index + 1);

    /*if ($.cookie("name") === undefined) {
        window.location.href = "../login.html";
    } else {*/
        $.ajax({
            url: url,
            type: 'get',
            success: function (response) {
                var service = new google.maps.places.PlacesService(document.createElement('div'));

                var request = {
                    placeId: response.placeId
                };

                var img_url;
                service.getDetails(request, function (place, status) {
                    if (status == google.maps.places.PlacesServiceStatus.OK) {
                        if (place.reviews != undefined)
                            $("#card-num-reviews").text(place.reviews.length + " Reviews");

                        if (place.photos != undefined || place.photos[0] != undefined)
                            $("#destinationImage").attr("src", place.photos[0].getUrl({ 'maxWidth': 500, 'maxHeight': 300 }));

                    }
                });

                var toSend = {
                    "managerName": $.cookie("name"),
                    "destinationId": (index + 1)
                }
                var reviewFunction = "addToTrips(" + JSON.stringify(toSend) + ");";
          
                $("#addToTrips").attr("onclick", reviewFunction);

                $(".modal-title").text(response.name);
                $("#card-name").text(response.name);
                $("#card-rating").text("Ratings: " + response.rating);
                if (response.timings != null) {
                    $("#card-timings").text(response.timings);
                }
                if (response.priceRange != 0) {
                    $("#card-price-range").text(response.priceRange);
                }
                $("#card-address").text("Address: " + response.name + ", " + response.city + ", " + response.country);
                $("#destinationText").text("Rome is the capital of Italy and a special comune Rome also serves as the capital of the Lazio region. " +
                    "With 2,873,874 residents in 1,285 km2 (496.1 sq mi), it is also the country's most populated comune. " +
                    "It is the fourth-most populous city in the European Union by population within city limits. ");

       
            }
        });

}