<<<<<<< HEAD
=======
import { claveSecreta, encriptarTexto, desencriptarTexto } from "./encriptar.js";
>>>>>>> master
import { navbar } from "./navbar.js";
import { baseUrl } from "./constants.js"

window.onload = function() {
<<<<<<< HEAD
=======
	var usuario = JSON.parse(desencriptarTexto(JSON.parse(localStorage.getItem('usuario')), claveSecreta));
>>>>>>> master
    /* NAVBAR */
    document.body.insertAdjacentHTML('afterbegin', navbar);
    const scriptContent = document.querySelector('nav script').textContent;
    const scriptElement = document.createElement('script');
    scriptElement.type = "module";
    scriptElement.textContent = scriptContent;
    document.body.appendChild(scriptElement);

    async function searchUsers() {
        try {
            const response = await fetch(`${baseUrl}/usuario/buscar`, {
              method: 'GET',
              headers: new Headers({'Content-type': 'application/json'}),
              mode: 'cors'
            });
            let usuarios = await response.json();
            return usuarios
          } catch (error) {
            console.error('Error al obtener los usuarios:', error);
          }
    }

    pintarTabla();
    async function pintarTabla() {
        let usuarios = await searchUsers();
        let tablaBody = document.querySelector("#usuariosTabla tbody");
    tablaBody.innerHTML = ""; // Limpiar cualquier dato previo

    usuarios.forEach(usuario => {
        let fila = document.createElement("tr");

        // Filtrar y agregar solo los campos necesarios
        let campos = ["correo", "nombre", "idioma", "nivel", "fechacreacion", "tipo"];
        campos.forEach(campo => {
            let celda = document.createElement("td");
            celda.textContent = usuario[campo];
            fila.appendChild(celda);
        });

        // Columna de Editar
        let celdaEditar = document.createElement("td");
        let botonEditar = document.createElement("button");
        botonEditar.innerHTML = `<i class="fa-solid fa-pencil"></i>`;
        botonEditar.classList.add("editar", "button-19")
        celdaEditar.appendChild(botonEditar);
        botonEditar.addEventListener("click", () => abrirModalEditar(usuario))
        fila.appendChild(celdaEditar);

        // Columna de Borrar
        let celdaBorrar = document.createElement("td");
        let botonBorrar = document.createElement("button");
        botonBorrar.innerHTML = `<i class="fa-solid fa-trash"></i>`;
        botonBorrar.classList.add("borrar", "button-19")
        botonBorrar.addEventListener("click", () => abrirModalBorrar(usuario))
        celdaBorrar.appendChild(botonBorrar);
        fila.appendChild(celdaBorrar);

        tablaBody.appendChild(fila);
    });
    }

    function abrirModalEditar(usuario) {
        document.querySelector(".modal-editar").classList.add("shown")
        document.querySelector(".modal-editar").id = usuario.idusuario
        let inputs = document.querySelectorAll(".modal-editar input")
        inputs.forEach(input => {
            if(input.id != "contra") {
<<<<<<< HEAD
                input.placeholder = usuario[input.id]
=======
                input.value = usuario[input.id]
>>>>>>> master
            } 
        })
        let selects = document.querySelectorAll(".modal-editar select");
        selects.forEach(select => {
            Array.from(select.options).forEach(option => {
                if(option.value == usuario[select.id]) {
                    option.selected = true;
                }
            });
        })
        console.log(usuario.tipo)
        if(usuario.tipo === "ADMIN") {
            document.querySelector(".modal-editar input[type=checkbox]").checked = true
        } else {
            document.querySelector(".modal-editar input[type=checkbox]").checked = false;
        }
    }

    document.querySelector(".modal-editar #edit").addEventListener("click", editarUsuario)

    async function editarUsuario() {
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
        formObject.idusuario = document.querySelector(".modal-editar").id;
<<<<<<< HEAD
        if(formObject.tipo === 'on') {
=======
        if(formObject.tipo) {
>>>>>>> master
            formObject.tipo = 'ADMIN';
        } else {
            formObject.tipo = "user"
        }
        console.log(formObject)
        try {
            const response = await fetch(`${baseUrl}/usuario/modificar`, {
                method: 'PUT',
                headers: new Headers({'Content-type': 'application/json'}),
                body: JSON.stringify(formObject),
                mode: 'cors'  
            });
            const usuarioNuevo = await response.json()
<<<<<<< HEAD
=======
            if(usuarioNuevo.idusuario == usuario.idusuario) {
				var guardar = JSON.stringify( usuarioNuevo );
        		localStorage.setItem('usuario', JSON.stringify(encriptarTexto(guardar, claveSecreta)));
			}
>>>>>>> master
            window.location.reload();
        } catch (error) {
            console.error('Error al cargar usuarios:', error);
        }
    }

    document.querySelector(".add").addEventListener("click", abrirModalAdd)

    function abrirModalAdd() {
        document.querySelector(".modal-add").classList.add("shown")
    }

<<<<<<< HEAD
    document.querySelector("#add").addEventListener("click", addUser)
=======
    document.querySelector(".modal-add form").addEventListener("submit", addUser)
>>>>>>> master

    async function addUser() {
        event.preventDefault();
        let form = document.querySelector(".modal-add form")
        console.log(form)
        const formData = new FormData(form)
        const formObject = {};
        formData.forEach((value, key) => {
            formObject[key] = value;
        });

        if(formObject.tipo === 'on') {
            formObject.tipo = 'ADMIN';
        } else {
            formObject.tipo = "user"
        }
        console.log(formObject)
        try {
            const response = await fetch(`${baseUrl}/usuario/registro`, {
                method: 'POST',
                headers: new Headers({'Content-type': 'application/json'}),
                body: JSON.stringify(formObject),
                mode: 'cors'  
            });
            const usuarioNuevo = await response.json()
            window.location.reload();
        } catch (error) {
            console.error('Error al cargar usuarios:', error);
        }
    }

    function abrirModalBorrar(usuario) {
        document.querySelector(".modal-delete").classList.add("shown");
        document.querySelector(".modal-delete").id = usuario.idusuario
    }

    document.querySelector("#delete").addEventListener("click", deleteUser)

    async function deleteUser() {
        let idusuario = document.querySelector(".modal-delete").id;
        try {
            const response = await fetch(`${baseUrl}/usuario/borrar/${idusuario}`, {
                method: 'DELETE',
                headers: new Headers({'Content-type': 'application/json'}),
                mode: 'cors'  
            });
            const usuarioNuevo = await response.json()
            window.location.reload();
        } catch (error) {
            console.error('Error al cargar usuarios:', error);
        }
    }
<<<<<<< HEAD
=======

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
    
>>>>>>> master
}