/*<![CDATA[*/
const spoonkey = /*[[${spoonkey}]]*/ 'default';
// const spoonkey = spoonacular.init(spoonacular.api);
console.log(spoonkey);
const url = "https://api.spoonacular.com/recipes/random?number=100&apiKey=" + spoonkey;
const options = {
    method: "GET",
};
const spoon = function(e) {
    e.preventDefault();
    fetch(url, options).then(response => response.json())
        .then(response =>{
            var primalArr = [];
            var iterator = 0;
            var i = 0;
            do{
                console.log(response.recipes[0].diets[i].includes("primal"));
                if(response.recipes[iterator].diets[i].includes("primal")){
                    primalArr.push(response.recipes[iterator])
                }
                i++;
                iterator++;
            }while(primalArr.length < 20)
            return primalArr;
        })
        .then(response => console.log(response))
}

document.getElementById("primal").addEventListener('click', spoon);
/*]]>*/