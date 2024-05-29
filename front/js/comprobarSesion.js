import { claveSecreta, desencriptarTexto } from "./encriptar.js";

document.addEventListener("DOMContentLoaded", function() {
  comprobarSesion();
});

async function cargarSesion() {
  const dataUsuarioString = localStorage.getItem('usuario');
  
  if (dataUsuarioString !== null) {
    const dataUsuario = JSON.parse(desencriptarTexto(JSON.parse(localStorage.getItem('usuario')), claveSecreta));
    return dataUsuario;
  } else {
    return null;
  }
}
async function comprobarSesion() {
 let dataUsuario = await cargarSesion();
 console.log(dataUsuario)
 if(dataUsuario) {
   if(dataUsuario.tipo !== 'ADMIN' && window.location.pathname.includes('admin')) {
     window.location.href = "index.html"
   }
  if(!dataUsuario.idioma) {
    if(window.location.pathname.substring(1) != "idioma.html") {
      window.location.href = "idioma.html"
    }
    return;
  }
  else if(!dataUsuario.nivel) {
    if(window.location.pathname.substring(1) != "select-prueba.html") {
      window.location.href = "select-prueba.html"
    }
    return;
  }
 } else {
   window.location.href = 'login.html';
 }
}
