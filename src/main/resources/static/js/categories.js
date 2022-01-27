"use strict";
(function () {

    const options = {
        method: "GET"
    };

    //Vegetarian
    const vegUrl = "https://api.spoonacular.com/recipes/random?number=20&tags=vegetarian&apiKey=" + spoonkey;
    const veggie = function(e) {
        e.preventDefault();
        fetch(vegUrl, options).then(response => response.json())
            .then(response => console.log(response))
    }

    document.getElementById("veggie").addEventListener('click', veggie);

    //Gluten Free
    const gFUrl = "https://api.spoonacular.com/recipes/random?number=100&apiKey=" + spoonkey;
    const gluten = function(e) {
        e.preventDefault();
        fetch(gFUrl, options).then(response => response.json())
            .then(response =>{
                var glutenFreeArr = [];
                var iterator = 0;
                do{
                    // console.log(response.recipes[0].glutenFree);
                    if(response.recipes[iterator].glutenFree === true){
                        glutenFreeArr.push(response.recipes[iterator])
                    }
                    iterator++;
                }while(glutenFreeArr.length < 20)
                return glutenFreeArr;
            })
            .then(response => console.log(response))
    }

    document.getElementById("glutenFree").addEventListener('click', gluten);


    // //Primal
    // const primalUrl = "https://api.spoonacular.com/recipes/random?number=100&apiKey=" + spoonkey;
    // const primal = function(e) {
    //     e.preventDefault();
    //     fetch(primalUrl, options).then(response => response.json())
    //         .then(response => {
    //             var primalArr = [];
    //             var iterator = 0;
    //             for (var i = 0; i < response.recipes.length; i++) {
    //                 if (response.recipes[i].diets !== undefined) {
    //                     for (var j = 0; j < response.recipes[i].diets.length; j++) {
    //                         //set the hard coded string as a variable based on the category for filter
    //                         if (response.recipes[i].diets.includes("primal")) {
    //                             console.log(response.recipes[i]);
    //                             primalArr.push(response.recipes[i])
    //                         }
    //                     }
    //                 }
    //
    //             }
    //         })
    // }

})();