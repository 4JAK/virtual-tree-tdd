
const openButton = document.querySelector(".openbtn");

openButton.addEventListener("click", openNav);

function openNav() {
   document.getElementById("slide-out-lesson").style.width = "70%";
}

const closeButton = document.querySelector(".closebtn");

closeButton.addEventListener("click", closeNav);

function closeNav() {
   document.getElementById("slide-out-lesson").style.width = "0";
}