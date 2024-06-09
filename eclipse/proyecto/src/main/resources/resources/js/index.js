import { claveSecreta, encriptarTexto, desencriptarTexto } from "./encriptar.js";
import { baseUrl } from "./constants.js";
import { navbar } from "./navbar.js"
import { footer } from "./footer.js"

window.onload = function() {
  /* NAVBAR */
  document.body.insertAdjacentHTML('afterbegin', navbar);
  const scriptContent = document.querySelector('nav script').textContent;
  const scriptElement = document.createElement('script');
  scriptElement.type = "module";
  scriptElement.textContent = scriptContent;
  document.body.appendChild(scriptElement);
  /*---------------*/
  var usuario = JSON.parse(desencriptarTexto(JSON.parse(localStorage.getItem('usuario')), claveSecreta));

  async function obtenerEjercicio() {
    console.log(usuario.idusuario)
    try {
      const response = await fetch(`${baseUrl}/ejercicio/siguiente/${usuario.idusuario}`, {
        method: 'GET',
        headers: new Headers({'Content-type': 'application/json'}),
        mode: 'cors'
      });
      let ejercicio = await response.json();
      return ejercicio
    } catch (error) {
      console.error('Error al obtener el ejercicio:', error);
    }
  }

  async function pintarInformacion() {
    let ejercicio = await obtenerEjercicio()
    let h3 = document.querySelector(".info h3");
    h3.innerHTML = `${usuario.idioma} - Nivel <span>${usuario.nivel}</span>`
    let ejercicioInfo = document.querySelector(".info .next p");
    ejercicioInfo.innerHTML = `Siguiente ejercicio: <span>${ejercicio.nombre}</span>`

  }

  pintarInformacion()

  document.body.insertAdjacentHTML("beforeend", footer)
}