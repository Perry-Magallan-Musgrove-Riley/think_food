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
    // $.get("https://api.spoonacular.com/recipes/random?apiKey=" + spoonacularApiKey).done(function (data){
        $.get("https://api.spoonacular.com/recipes/random?apiKey=9a977cea6b7849609902f4f01ac80b0c").done(function (data){
            console.log(data);
    })
})
