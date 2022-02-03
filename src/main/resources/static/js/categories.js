"use strict";
(function () {

    const options = {
        method: "GET"
    };

    //Popular Dishes Home Page
    const popularUrl = "https://api.spoonacular.com/recipes/random?number=100&apiKey=" + spoonkey;
    fetch(popularUrl, options).then(response => response.json())
        .then(response =>{
            var popularArr = [];
            var iterator = 0;
            for(var i = 0; i < response.recipes.length; i++){
                if(response.recipes[iterator].veryPopular){
                    popularArr.push(response.recipes[iterator])
                }
                iterator++;
            }
            console.log(popularArr);
            for(var j=0; j <3; j++){
                $(".card-body"+[j]).html("<div><h3>" + popularArr[j].title + "</h3></div><br>" + "<div><p>"+ popularArr[j].instructions + "</p></div>");
            }
        })
        .then(response => console.log(response))

    //Vegetarian
    const vegUrl = "https://api.spoonacular.com/recipes/random?number=100&apiKey=" + spoonkey;
    const veggie = function(e) {
        e.preventDefault();
        fetch(vegUrl, options).then(response => response.json())
            .then(response =>{
                var vegArr = [];
                var iterator = 0;
                do{
                    // console.log(response.recipes[0].glutenFree);
                    if(response.recipes[iterator].vegetarian === true){
                        if (vegArr.includes(response.recipes[iterator]) === false) vegArr.push(response.recipes[iterator]);
                    }
                    iterator++;
                }while(vegArr.length < 20)
                console.log(vegArr);
                var emptyString="";
                for(var k=0; k <vegArr.length; k++){
                    emptyString+="<div class='card col-4'>"
                    emptyString+="<div class='card-title'><h3>" + vegArr[k].title + "</h3></div><br>"
                    emptyString+="<div><img style='width: 325px' alt='recipeImg' src="+ vegArr[k].image +"></div>"
                    emptyString+="<div class='card-body'><p>" + vegArr[k].instructions + "</p></div>"
                    emptyString+="<form th:action='@{/order}' method='get'>"
                    emptyString+="<button type='submit'>Add to cart</button>"
                    emptyString+="</form>"
                    emptyString+="<form th:action='@{/profile}' method='get'>"
                    emptyString+="<button type='submit'>Save Recipe</button>"
                    emptyString+="</form>"
                    emptyString+="</div>"

                }
                $("#recipe-cards").html(emptyString);
            })
            .then(response => console.log(response))
    }

    document.getElementById("veggie").addEventListener('click', veggie);

    //Gluten Free
    //Function is in the html for this category
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
                        if (glutenFreeArr.includes(response.recipes[iterator]) === false) glutenFreeArr.push(response.recipes[iterator]);
                    }
                    iterator++;
                }while(glutenFreeArr.length < 20)
                for(var k=0; k <glutenFreeArr.length; k++){
                    $(".card-body"+[k]).html("<div><h3>" + glutenFreeArr[k].title + "</h3></div><br>" + "<div><p>"+ glutenFreeArr[k].instructions + "</p></div>");
                }
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