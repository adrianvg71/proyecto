import { claveSecreta, desencriptarTexto } from "./encriptar.js";

document.addEventListener("DOMContentLoaded", function() {
  comprobarSesion();
});

async function cargarSesion() {
  const dataUsuarioString = localStorage.getItem('usuario');
  
  if (dataUsuarioString !== null) {
    const dataUsuario = await JSON.parse(dataUsuarioString);
    return dataUsuario;
  } else {
    return null;
  }
}
async function comprobarSesion() {
 let dataUsuario = await cargarSesion();
 if(dataUsuario) {

 } else {
   window.location.href = 'login.html';
 }
}
