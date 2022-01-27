'use strict';
$(document).ready(function (e){

    // time stamp function
    e.preventDefault();
    document.getElementById('timeStamp').addEventListener('click', function (e){
        e.preventDefault();
        let timeStamp = new Date().toString().valueOf();
        console.log(timeStamp);
    });

})

