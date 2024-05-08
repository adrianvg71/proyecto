import { navbar } from "./navbar.js"

window.onload = function(){
    let nav = document.querySelector(".xd");

    console.log(nav);

    nav.innerHTML = navbar;
}