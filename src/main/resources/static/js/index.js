"use strict";

(function () {
    // Search Functionality
    $("#submitSearch").click(function (){
        let search = document.getElementById("search").value;
        let searchUrl = "https://api.spoonacular.com/recipes/findByIngredients?ingredients="+search+"&apiKey="+spoonkey;


        fetch(searchUrl, options).then(response => response.json())
            .then(response =>{
                console.log(response);
                var searchArr = [];
                for(var i = 0; i < response.length; i++){

                        searchArr.push(response[i])
                }
                console.log("searchArr= " + searchArr);
                console.log(searchArr[0].image);
                for(var j=0; j <searchArr.length; j++){
                    $(".apiSearch"+[j]).html("<div class='col mb-3 mt-3 d-flex justify-content-center'>" +
                        "<div class='card width d-flex justify-content-center text-center p-3'>" +
                        "<div><h3 class='text-center'>" + searchArr[j].title + "</h3></div><br>" +
                        "<div><p class='text-center'>" + searchArr[j].description+ "</p></div><br>" +
                        "<div><p class='text-center'>" + searchArr[j].recipePrepTime+ "</p></div><br>" +
                        "<div><p class='text-center'>" + searchArr[j].ingredient+ "</p></div><br>" +
                        "</div>" +
                        "</div>");
                }
            })
            .then(response => console.log(response))
    })




    //Randomize Recipe
    const url = "https://api.spoonacular.com/recipes/random?apiKey=" + spoonkey;
    const options = {
        method: "GET"
    };
    const spoon = function(e) {
        // e.preventDefault();
        fetch(url, options).then(response => response.json())
            .then(response => console.log(response.recipes[0]))
    }
    document.getElementById("rando").addEventListener('click', spoon);

})();


