var miBloque = document.getElementById("userInfo");
var inf = document.getElementById("showInfo");
var story = document.getElementById("story");

/*
$(inf).on('click',function () {
   miBloque.classList.add('mostrar'),
   story.classList.add('esconder'),
       $.ajax({
           type: 'GET',
           url: '/userInfo'
       });
});*/

inf.addEventListener("click", function (ev) {
   var peticion = new XMLHttpRequest();
   peticion.open('GET','/userInfo');
   peticion.onload = function () {
      // miBloque.classList.add('mostrar');
      story.classList.add('esconder');
   };
   peticion.send();
});