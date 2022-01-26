"use strict";
(function () {

    //Vegetarian
    console.log(spoonkey);
    const url = "https://api.spoonacular.com/recipes/random?number=20&tags=vegetarian&apiKey=" + spoonkey;
    // "https://api.spoonacular.com/recipes/random?apiKey=" + spoonkey + "number=20&tags=vegetarian";
    const options = {
        method: "GET",
    };
    const spoon = function(e) {
        e.preventDefault();
        fetch(url, options).then(response => response.json())
            .then(response => console.log(response))
    }

    document.getElementById("veggie").addEventListener('click', spoon);







})();