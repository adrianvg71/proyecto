import { claveSecreta, encriptarTexto, desencriptarTexto } from "./encriptar.js";
import { baseUrl } from "./constants.js";
import { footer } from "./footer.js"

window.onload = function() {
  var usuario = JSON.parse(desencriptarTexto(JSON.parse(localStorage.getItem('usuario')), claveSecreta));
  console.log(usuario.nivel)
  document.getElementById('A1').addEventListener("click", async function() {
    usuario.nivel = 'A1';
    try {
      const response = await fetch(`${baseUrl}/usuario/modificar`, {
          method: 'PUT',
          headers: new Headers({'Content-type': 'application/json'}),
          body: JSON.stringify(usuario),
          mode: 'cors'  
      });
      const usuarioNuevo = await response.json()
      var guardar = JSON.stringify( usuarioNuevo );
      localStorage.setItem('usuario', JSON.stringify(encriptarTexto(guardar, claveSecreta)));
      window.location.href="index.html";
      // return response
  } catch (error) {
      console.error('Error al cargar usuarios:', error);
  }
  });

  document.getElementById("prueba").addEventListener("click", async function() {
    usuario.nivel = '0';
    try {
      const response = await fetch(`${baseUrl}/usuario/modificar`, {
          method: 'PUT',
          headers: new Headers({'Content-type': 'application/json'}),
          body: JSON.stringify(usuario),
          mode: 'cors'  
      });
      const usuarioNuevo = await response.json()
      var guardar = JSON.stringify( usuarioNuevo );
      localStorage.setItem('usuario', JSON.stringify(encriptarTexto(guardar, claveSecreta)));
      window.location.href="test.html";
      // return response
  } catch (error) {
      console.error('Error al cargar usuarios:', error);
  }
  });

  document.body.insertAdjacentHTML('beforeend', footer);
}