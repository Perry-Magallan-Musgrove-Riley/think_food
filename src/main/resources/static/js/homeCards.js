const spoonkey = /*[[${spoonkey}]]*/ 'default';
const url = "https://api.spoonacular.com/recipes/random?number=100&apiKey=" + spoonkey;
const options = {
    method: "GET",
};
$(url).load(function(e){
    e.preventDefault();
    fetch(url, options).then(response => response.json())
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
            console.log(popularArr[0].image);
            for(var j=0; j <3; j++){
            $(".card-body"+[j]).innerHTML("<div class='d-flex justify-content-center card-title'><h3>" + popularArr[j].title + "</h3></div><br>" + "></div>"+"<div><p>"+ popularArr[j].instructions + "</p></div>");
            }
        })
        .then(response => console.log(response))
})