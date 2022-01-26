// const client = filestack.init(filestackKey);
// client.picker().open();


$("#submitSearch").click(function (e){
    e.preventDefault();
    $.get("https://api.spoonacular.com/recipes/random?apiKey=" + spoonacularApiKey).done(function (data){
            console.log(data);
    })
})
