"use strict";
(function () {
    //Search Functionality
    $("#submitSearch").click(function (e){
        e.preventDefault();
        $.get("https://api.spoonacular.com/recipes/random?number=20&apiKey=" + spoonkey).done(function (data){
                console.log(data);
        })
    })

    //Randomize Recipe
    const url = "https://api.spoonacular.com/recipes/random?apiKey=" + spoonkey;
    const options = {
        method: "GET"
    };
    const spoon = function(e) {
        e.preventDefault();
        fetch(url, options).then(response => response.json())
            .then(response => console.log(response.recipes[0]))
    }
    document.getElementById("rando").addEventListener('click', spoon);
})();

