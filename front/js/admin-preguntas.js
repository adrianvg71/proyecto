import { navbar } from "./navbar.js";
import { baseUrl } from "./constants.js"

window.onload = function() {
  let urlPath = window.location.pathname.split('/');
  let value = urlPath[urlPath.length - 1];

      /* NAVBAR */
      document.body.insertAdjacentHTML('afterbegin', navbar);
      const scriptContent = document.querySelector('nav script').textContent;
      const scriptElement = document.createElement('script');
      scriptElement.type = "module";
      scriptElement.textContent = scriptContent;
      document.body.appendChild(scriptElement);
  
      async function searchQuestions() {
          try {
              const response = await fetch(`${baseUrl}/ejercicio/buscarPorId/${value}`, {
                method: 'GET',
                headers: new Headers({'Content-type': 'application/json'}),
                mode: 'cors'
              });
              let preguntas = await response.json();
              return preguntas
            } catch (error) {
              console.error('Error al obtener los preguntas:', error);
            }
      }
  
      pintarTabla();
      async function pintarTabla() {
          let pregunta = await searchQuestions();
          document.querySelector("h2").textContent += `: ${pregunta.nombre}`
          let preguntas = pregunta.preguntas
          console.log(preguntas)
          let tablaBody = document.querySelector("#preguntasTabla tbody");
      tablaBody.innerHTML = ""; // Limpiar cualquier dato previo
  
      preguntas.forEach(pregunta => {
          let fila = document.createElement("tr");
          let celda = document.createElement("td");
          let enunciado = document.createElement("a");
          enunciado.href = `/admin-opciones/${pregunta.idpregunta}`
          enunciado.textContent = pregunta.enunciado
          celda.append(enunciado)
          fila.append(celda);

  
          // Columna de Editar
          let celdaEditar = document.createElement("td");
          let botonEditar = document.createElement("button");
          botonEditar.innerHTML = `<i class="fa-solid fa-pencil"></i>`;
          botonEditar.classList.add("editar", "button-19")
          celdaEditar.appendChild(botonEditar);
          botonEditar.addEventListener("click", () => abrirModalEditar(pregunta))
          fila.appendChild(celdaEditar);
  
          // Columna de Borrar
          let celdaBorrar = document.createElement("td");
          let botonBorrar = document.createElement("button");
          botonBorrar.innerHTML = `<i class="fa-solid fa-trash"></i>`;
          botonBorrar.classList.add("borrar", "button-19")
          botonBorrar.addEventListener("click", () => abrirModalBorrar(pregunta))
          celdaBorrar.appendChild(botonBorrar);
          fila.appendChild(celdaBorrar);
  
          tablaBody.appendChild(fila);
      });
      }
  
  
      /* -------------------------------------------------------- */
  
  
      function abrirModalEditar(pregunta) {
          document.querySelector(".modal-editar").classList.add("shown")
          document.querySelector(".modal-editar").id = pregunta.idpregunta
          let inputs = document.querySelectorAll(".modal-editar input")
          inputs.forEach(input => {
              input.value = pregunta[input.id]
          })
      }
  
      document.querySelector(".modal-editar #edit").addEventListener("click", editarPregunta)
  
      async function editarPregunta() {
          event.preventDefault();
          let form = document.querySelector(".modal-editar form")
          console.log(form)
          const formData = new FormData(form)
          const formObject = {};
          formData.forEach((value, key) => {
              if(value.trim() != '' || key === 'rol') {
                  formObject[key] = value;
              }
          });
          formObject.idpregunta = document.querySelector(".modal-editar").id;
          try {
              const response = await fetch(`${baseUrl}/pregunta/modificar`, {
                  method: 'PUT',
                  headers: new Headers({'Content-type': 'application/json'}),
                  body: JSON.stringify(formObject),
                  mode: 'cors'  
              });
              const preguntaNueva = await response.json()
              window.location.reload();
          } catch (error) {
              console.error('Error al cargar preguntas:', error);
          }
      }
  
      document.querySelector(".add").addEventListener("click", abrirModalAdd)
  
      function abrirModalAdd() {
          document.querySelector(".modal-add").classList.add("shown")
      }
  
      document.querySelector(".modal-add form").addEventListener("submit", addQuestion)
  
      async function addQuestion() {
          event.preventDefault();
          let form = document.querySelector(".modal-add form")
          console.log(form)
          const formData = new FormData(form)
          const formObject = {};
          formData.forEach((value, key) => {
              formObject[key] = value;
          });
          console.log(formObject)
          try {
              const response = await fetch(`${baseUrl}/pregunta/add/${parseInt(value)}`, {
                  method: 'POST',
                  headers: new Headers({'Content-type': 'application/json'}),
                  body: JSON.stringify(formObject),
                  mode: 'cors'  
              });
              const preguntaNueva = await response.json()
              console.log(preguntaNueva)
              window.location.reload();
          } catch (error) {
              console.error('Error al cargar preguntas:', error);
          }
      }
  
      function abrirModalBorrar(pregunta) {
          document.querySelector(".modal-delete").classList.add("shown");
          document.querySelector(".modal-delete").id = pregunta.idpregunta
      }
  
      document.querySelector("#delete").addEventListener("click", deleteQuestion)
  
      async function deleteQuestion() {
          let idpregunta = document.querySelector(".modal-delete").id;
          try {
              const response = await fetch(`${baseUrl}/pregunta/borrar/${idpregunta}`, {
                  method: 'DELETE',
                  headers: new Headers({'Content-type': 'application/json'}),
                  mode: 'cors'  
              });
              const preguntaNuevo = await response.json()
              window.location.reload();
          } catch (error) {
              console.error('Error al cargar preguntas:', error);
          }
      }
  
      document.addEventListener("mousedown", function(event) {
          let modalEditar = document.querySelector(".modal-editar");
          let modalAdd = document.querySelector(".modal-add");
          let modalDelete = document.querySelector(".modal-delete");
          if ((modalEditar.contains(event.target) && !modalEditar.querySelector(".modal-info").contains(event.target)) || (modalAdd.contains(event.target) && !modalAdd.querySelector(".modal-info").contains(event.target)) || (modalDelete.contains(event.target) && !modalDelete.querySelector(".modal-info").contains(event.target))) {
            modalEditar.classList.remove('shown');
            modalAdd.classList.remove('shown');
            modalDelete.classList.remove('shown');
          }
        });

        // let liSize = document.querySelector("main li").clientWidth;
        // document.querySelector("main h2").style.transform = `translateX(-${liSize/2}px)`
}