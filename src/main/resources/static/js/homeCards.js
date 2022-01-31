const spoonkey = /*[[${spoonkey}]]*/ 'default';
console.log(spoonkey);
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
            for(var j=0; j <3; j++){
            $(".card-body"+[i]).innerHTML("<div><h3>" + popularArr[j].title + "</h3></div><br>" + "<div><p>"+ popularArr[j].instructions + "</p></div>");
            }
        })
        .then(response => console.log(response))
})