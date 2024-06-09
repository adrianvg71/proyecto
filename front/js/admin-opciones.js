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
              const response = await fetch(`${baseUrl}/pregunta/buscarPorId/${value}`, {
                method: 'GET',
                headers: new Headers({'Content-type': 'application/json'}),
                mode: 'cors'
              });
              let pregunta = await response.json();
              return pregunta
            } catch (error) {
              console.error('Error al obtener los preguntas:', error);
            }
      }
  
      pintarTabla();
      async function pintarTabla() {
          let pregunta = await searchQuestions();
          console.log(pregunta)
          document.querySelector("#rellenarUrl").href = `/admin-preguntas/${pregunta.idejercicio}`
          document.querySelector("h2").textContent += `: ${pregunta.enunciado}`
          let opciones = pregunta.opciones
          console.log(opciones)
          let tablaBody = document.querySelector("#opcionesTabla tbody");
      tablaBody.innerHTML = ""; // Limpiar cualquier dato previo
  
      opciones.forEach(opcion => {
          let fila = document.createElement("tr");
          let celda = document.createElement("td");
          
          let campos = ["descripcion", "correcta"];
          campos.forEach(campo => {
            let celda = document.createElement("td");
            if(campo === "correcta") {
                let input = document.createElement("input");
                input.type = "checkbox"
                if(opcion[campo]) {
                  input.checked = true
                } else {
                  input.checked = false
                }
                celda.append(input)
            }
            else {
                celda.textContent = opcion[campo];
            }
            fila.appendChild(celda);
        });

  
          // Columna de Editar
          let celdaEditar = document.createElement("td");
          let botonEditar = document.createElement("button");
          botonEditar.innerHTML = `<i class="fa-solid fa-pencil"></i>`;
          botonEditar.classList.add("editar", "button-19")
          celdaEditar.appendChild(botonEditar);
          botonEditar.addEventListener("click", () => abrirModalEditar(opcion))
          fila.appendChild(celdaEditar);
  
          // Columna de Borrar
          let celdaBorrar = document.createElement("td");
          let botonBorrar = document.createElement("button");
          botonBorrar.innerHTML = `<i class="fa-solid fa-trash"></i>`;
          botonBorrar.classList.add("borrar", "button-19")
          botonBorrar.addEventListener("click", () => abrirModalBorrar(opcion))
          celdaBorrar.appendChild(botonBorrar);
          fila.appendChild(celdaBorrar);
  
          tablaBody.appendChild(fila);
      });
      }
  
  
      /* -------------------------------------------------------- */
  
  
      function abrirModalEditar(opcion) {
          document.querySelector(".modal-editar").classList.add("shown")
          document.querySelector(".modal-editar").id = opcion.idopcion
          let inputs = document.querySelectorAll(".modal-editar input")
          inputs.forEach(input => {
              if(input.id == "correcta") {
                if(opcion[input.id]) {
                  input.checked = true
                } else {
                  input.checked = false
                }
              }
              input.value = opcion[input.id]
          })
      }
  
      document.querySelector(".modal-editar #edit").addEventListener("click", editarOpcion)
  
      async function editarOpcion() {
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
          console.log(formObject)
          if(formObject.correcta) {
            formObject.correcta = true;
          } else {
              formObject.correcta = false
          }
          formObject.idopcion = document.querySelector(".modal-editar").id;
          try {
              const response = await fetch(`${baseUrl}/opcion/modificar`, {
                  method: 'PUT',
                  headers: new Headers({'Content-type': 'application/json'}),
                  body: JSON.stringify(formObject),
                  mode: 'cors'  
              });
              const opcionNueva = await response.json()
              console.log(opcionNueva)
              window.location.reload();
          } catch (error) {
              console.error('Error al cargar opciones:', error);
          }
      }
  
      document.querySelector(".add").addEventListener("click", abrirModalAdd)
  
      function abrirModalAdd() {
          document.querySelector(".modal-add").classList.add("shown")
      }
  
      document.querySelector(".modal-add form").addEventListener("submit", addOption)
  
      async function addOption() {
          event.preventDefault();
          let form = document.querySelector(".modal-add form")
          console.log(form)
          const formData = new FormData(form)
          const formObject = {};
          formData.forEach((value, key) => {
              formObject[key] = value;
          });
          if(formObject.correcta === 'on') {
            formObject.correcta = true;
          } else {
              formObject.correcta = false
          }
          console.log(formObject)
          try {
              const response = await fetch(`${baseUrl}/opcion/add/${parseInt(value)}`, {
                  method: 'POST',
                  headers: new Headers({'Content-type': 'application/json'}),
                  body: JSON.stringify(formObject),
                  mode: 'cors'  
              });
              const opcionNueva = await response.json()
              console.log(opcionNueva)
              window.location.reload();
          } catch (error) {
              console.error('Error al cargar preguntas:', error);
          }
      }
  
      function abrirModalBorrar(opcion) {
          document.querySelector(".modal-delete").classList.add("shown");
          document.querySelector(".modal-delete").id = opcion.idopcion
      }
  
      document.querySelector("#delete").addEventListener("click", deleteQuestion)
  
      async function deleteQuestion() {
          let idopcion = document.querySelector(".modal-delete").id;
          try {
              const response = await fetch(`${baseUrl}/opcion/borrar/${idopcion}`, {
                  method: 'DELETE',
                  headers: new Headers({'Content-type': 'application/json'}),
                  mode: 'cors'  
              });
              const opcionNueva = await response.json()
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

    
}