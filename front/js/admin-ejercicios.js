import { navbar } from "./navbar.js";
import { baseUrl } from "./constants.js"

window.onload = function() {
    /* NAVBAR */
    document.body.insertAdjacentHTML('afterbegin', navbar);
    const scriptContent = document.querySelector('nav script').textContent;
    const scriptElement = document.createElement('script');
    scriptElement.type = "module";
    scriptElement.textContent = scriptContent;
    document.body.appendChild(scriptElement);

    async function searchExcersises() {
        try {
            const response = await fetch(`${baseUrl}/ejercicio/buscar`, {
              method: 'GET',
              headers: new Headers({'Content-type': 'application/json'}),
              mode: 'cors'
            });
            let ejercicios = await response.json();
            return ejercicios
          } catch (error) {
            console.error('Error al obtener los ejercicios:', error);
          }
    }

    pintarTabla();
    async function pintarTabla() {
        let ejercicios = await searchExcersises();
        console.log(ejercicios)
        let tablaBody = document.querySelector("#ejerciciosTabla tbody");
    tablaBody.innerHTML = ""; // Limpiar cualquier dato previo

    ejercicios.forEach(ejercicio => {
        let fila = document.createElement("tr");

        // Filtrar y agregar solo los campos necesarios
        let campos = ["idioma", "nivel", "nombre"];
        campos.forEach(campo => {
            let celda = document.createElement("td");
            if(campo === "nombre") {
                let a = document.createElement("a");
                a.href = `admin-preguntas/${ejercicio.idejercicio}`
                a.textContent = ejercicio[campo];
                celda.append(a)
            }
            else {
                celda.textContent = ejercicio[campo];
            }
            fila.appendChild(celda);
        });

        // Columna de Editar
        let celdaEditar = document.createElement("td");
        let botonEditar = document.createElement("button");
        botonEditar.innerHTML = `<i class="fa-solid fa-pencil"></i>`;
        botonEditar.classList.add("editar", "button-19")
        celdaEditar.appendChild(botonEditar);
        botonEditar.addEventListener("click", () => abrirModalEditar(ejercicio))
        fila.appendChild(celdaEditar);

        // Columna de Borrar
        let celdaBorrar = document.createElement("td");
        let botonBorrar = document.createElement("button");
        botonBorrar.innerHTML = `<i class="fa-solid fa-trash"></i>`;
        botonBorrar.classList.add("borrar", "button-19")
        botonBorrar.addEventListener("click", () => abrirModalBorrar(ejercicio))
        celdaBorrar.appendChild(botonBorrar);
        fila.appendChild(celdaBorrar);

        tablaBody.appendChild(fila);
    });
    }


    /* -------------------------------------------------------- */


    function abrirModalEditar(ejercicio) {
        document.querySelector(".modal-editar").classList.add("shown")
        document.querySelector(".modal-editar").id = ejercicio.idejercicio
        let inputs = document.querySelectorAll(".modal-editar input")
        inputs.forEach(input => {
            input.value = ejercicio[input.id]
        })
        let selects = document.querySelectorAll(".modal-editar select");
        selects.forEach(select => {
            Array.from(select.options).forEach(option => {
                if(option.value == ejercicio[select.id]) {
                    option.selected = true;
                }
            });
        })
    }

    document.querySelector(".modal-editar #edit").addEventListener("click", editarEjercicio)

    async function editarEjercicio() {
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
        formObject.idejercicio = document.querySelector(".modal-editar").id;
        try {
            const response = await fetch(`${baseUrl}/ejercicio/modificar`, {
                method: 'PUT',
                headers: new Headers({'Content-type': 'application/json'}),
                body: JSON.stringify(formObject),
                mode: 'cors'  
            });
            const ejercicioNuevo = await response.json()
            window.location.reload();
        } catch (error) {
            console.error('Error al cargar ejercicios:', error);
        }
    }

    document.querySelector(".add").addEventListener("click", abrirModalAdd)

    function abrirModalAdd() {
        document.querySelector(".modal-add").classList.add("shown")
    }

    document.querySelector(".modal-add form").addEventListener("submit", addExcersise)

    async function addExcersise() {
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
            const response = await fetch(`${baseUrl}/ejercicio/add`, {
                method: 'POST',
                headers: new Headers({'Content-type': 'application/json'}),
                body: JSON.stringify(formObject),
                mode: 'cors'  
            });
            const ejercicioNuevo = await response.json()
            window.location.reload();
        } catch (error) {
            console.error('Error al cargar ejercicios:', error);
        }
    }

    function abrirModalBorrar(ejercicio) {
        document.querySelector(".modal-delete").classList.add("shown");
        document.querySelector(".modal-delete").id = ejercicio.idejercicio
    }

    document.querySelector("#delete").addEventListener("click", deleteExcersise)

    async function deleteExcersise() {
        let idejercicio = document.querySelector(".modal-delete").id;
        try {
            const response = await fetch(`${baseUrl}/ejercicio/borrar/${idejercicio}`, {
                method: 'DELETE',
                headers: new Headers({'Content-type': 'application/json'}),
                mode: 'cors'  
            });
            const ejercicioNuevo = await response.json()
            window.location.reload();
        } catch (error) {
            console.error('Error al cargar ejercicios:', error);
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
    
      let liSize = document.querySelector("main li").clientWidth;
      document.querySelector("main h2").style.transform = `translateX(-${liSize/2}px)`
}