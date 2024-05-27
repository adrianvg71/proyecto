import { claveSecreta, encriptarTexto, desencriptarTexto } from "./encriptar.js";
import { baseUrl } from "./constants.js";
import { navbar } from './navbar.js';
import { footer } from './footer.js';

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

  async function buscarUsuarioEjercicio() {
    try {
      const response = await fetch(`${baseUrl}/usuarioejercicio/buscar/${usuario.idusuario}`, {
        method: 'GET',
        headers: new Headers({'Content-type': 'application/json'}),
        mode: 'cors'
      });
      let usuarioejercicio = await response.json();
      return usuarioejercicio
    } catch (error) {
      console.error('Error al obtener el ejercicio:', error);
    }
  }

  async function buscarUsuarioEjercicioNivel() {
    try {
      const response = await fetch(`${baseUrl}/usuarioejercicio/buscarpornivel/${usuario.idusuario}/${usuario.nivel}`, {
        method: 'GET',
        headers: new Headers({'Content-type': 'application/json'}),
        mode: 'cors'
      });
      let usuarioejercicionivel = await response.json();
      return usuarioejercicionivel
    } catch (error) {
      console.error('Error al obtener el ejercicio:', error);
    }
  }

  async function buscarEjerciciosNivel() {
    try {
      const response = await fetch(`${baseUrl}/ejercicio/buscar/${usuario.nivel}`, {
        method: 'GET',
        headers: new Headers({'Content-type': 'application/json'}),
        mode: 'cors'
      });
      let ejercicisonivel = await response.json();
      return ejercicisonivel
    } catch (error) {
      console.error('Error al obtener el ejercicio:', error);
    }
  }

  async function pintarInformacion () {
    document.getElementById('usu').textContent = usuario.nombre;
    document.getElementById('email').textContent = usuario.correo;
    document.getElementById('idioma').textContent = usuario.idioma;
    document.getElementById('nivel').textContent = usuario.nivel;
    let usuarioejercicionivel = await buscarUsuarioEjercicioNivel();
    let ejerciciosnivel = await buscarEjerciciosNivel();
    let progreso = Math.trunc((usuarioejercicionivel.length / ejerciciosnivel.length) * 100);
    document.querySelector(".progress").style.width = `${progreso}%`;
    document.querySelector(".progress-text").textContent = `${progreso}%`
    let usuarioejercicio = await buscarUsuarioEjercicio();
    let select = document.querySelector("select");
    select.addEventListener("change", () => pintarChart(event, usuarioejercicio))
    if(usuarioejercicio.length >= 1) {
      usuarioejercicio.forEach(usej => {
        let option = document.createElement("option");
        option.value = usej.idusuarioejercicio
        option.textContent = usej.ejercicio.nombre;
        select.append(option)
      })
    }
  }

  pintarInformacion()
  let chart; // Variable para mantener la referencia al gráfico

  /* CHARTJS */
  function pintarChart(event, usej) {
    // Si ya hay un gráfico creado, destrúyelo
      if (chart) {
          chart.destroy();
      }
      let selectedOption = event.target.value;
      let selectedUsej = usej.find((usej) => usej.idusuarioejercicio == selectedOption);
      const ctx = document.getElementById('myChart');
      ctx.style.display = "block";
  
      const data = {
          labels: [
              'Aciertos',
              'Fallos'
          ],
          datasets: [{
              label: ` ${selectedUsej.ejercicio.nombre}`,
              data: [selectedUsej.aciertos, selectedUsej.ejercicio.preguntas.length - selectedUsej.aciertos],
              backgroundColor: [
                  '#32CD32e5',
                  '#ff3333e5',
              ],
              hoverOffset: 1
          }]
      };
  
  
      // Crear un nuevo gráfico y actualizar la referencia
      chart = new Chart(ctx, {
          type: 'pie',
          data: data,
      });
  }

  /* Editar perfil */
  let editBtn = document.getElementById('editBtn');
  editBtn.addEventListener("click", abrirModal)
  let modal = document.querySelector(".modal-container")
  document.querySelector(".modal-titulo i").addEventListener("click", cerrarModal)
  let inputUsuario = document.getElementById('usuario')
  inputUsuario.placeholder = usuario.nombre
  let inputCorreo = document.getElementById('correo')
  inputCorreo.placeholder = usuario.correo
  let inputContraseña = document.getElementById('contra')
  document.getElementById('edit').addEventListener("click", editUser)

  function abrirModal() {
    document.body.style.overflowY = "hidden"
    modal.classList.toggle('shown')
  }

  function cerrarModal() {
    document.body.style.overflowY = "auto"
    modal.classList.toggle('shown');
  }

  document.addEventListener("mousedown", function(event) {
    if (modal.contains(event.target) && !modal.querySelector(".modal-info").contains(event.target)) {
      modal.classList.remove('shown');
      document.body.style.overflowY = "auto"
    }
  });
  
  async function editUser() {
    event.preventDefault();
    if(inputUsuario.value.trim() != ''){
      usuario.nombre = inputUsuario.value
    }
    if(inputCorreo.value.trim() != '') {
      usuario.correo = inputCorreo.value
    }
    if(inputContraseña.value.trim() != '') {
      usuario.contraseña = JSON.stringify(encriptarTexto(inputContraseña.value, claveSecreta));
    }
    if(inputUsuario.value.trim() != '' || inputCorreo.value.trim() != '' || inputContraseña.value.trim() != '') {
      console.log(usuario)
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
        window.location.reload();
        return response
      } catch (error) {
          console.error('Error al cargar usuarios:', error);
      }
    }
  }

  document.body.insertAdjacentHTML("beforeend", footer)
}