
$("#rando").click(function(e) {
    e.preventDefault();
    $.get("https://api.spoonacular.com/recipes/random?apiKey=" + spoonKey).done(function (data, status) {
        console.log(data)
    })
})
