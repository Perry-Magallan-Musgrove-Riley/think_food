/*<![CDATA[*/

const spoonkey = /*[[${spoonkey}]]*/ 'default';
$("#submitSearch").click(function (e){
    e.preventDefault();
    $.get("https://api.spoonacular.com/recipes/random?apiKey=" + spoonkey).done(function (data){
            console.log(data);
    })
})


/*]]>*/