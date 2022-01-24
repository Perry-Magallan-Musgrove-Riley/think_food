const client = filestack.init(filestackKey);
client.picker().open();

$("#rando").click(function(e) {
    e.preventDefault();
    $.get("https://api.spoonacular.com/recipes/random?apiKey=" + spoonKey).done(function (data, status) {
        console.log(data)
    })
})

$("#submitSearch").click(function (e){
    e.preventDefault();
    $.get("https://api.spoonacular.com/recipes/random?apiKey=" + spoonacularApiKey).done(function (data){
            console.log(data);
    })
})
