import { claveSecreta, encriptarTexto } from "./encriptar.js";

window.onload = function() {
  // Cambiar entre inicio de sesion/registro
  let loginBtn = document.getElementById("login");
  let registerBtn = document.getElementById("register");

  loginBtn.addEventListener("click", toggleLogin);
  registerBtn.addEventListener("click", toggleLogin);

  let loginDiv = document.getElementById("login-form");
  let registerDiv = document.getElementById("register-form");

  function toggleLogin() {
    loginBtn.classList.toggle("not-selected");
    registerBtn.classList.toggle("not-selected");
    loginDiv.classList.toggle("hidden");
    registerDiv.classList.toggle("hidden");
  }

  //Funcionalidad de registro e inicio de sesion
  let span = document.createElement("span");
  const loginForm = document.querySelector(".login");
  const registerForm = document.querySelector(".registro");

  loginForm.addEventListener("submit", async function(event) {
    span.remove();
    event.preventDefault();
    
    const email = loginForm.querySelector('input[type="email"]').value;
    const password = loginForm.querySelector('input[type="password"]').value;
    
    let usuarios = await cargarUsuarios();
    
    for(let usuario of usuarios) {
      if(usuario.correo === email && usuario.contraseña === password) {
        var guardar = JSON.stringify( usuario )
        localStorage.setItem('usuario', JSON.stringify(encriptarTexto(guardar, claveSecreta)));
        window.location.href = 'index.html'
        return;
      }
    }
    //TODO: mostrar mensaje de error
    span.textContent = "Usuario y/o contraseña incorrectas";
    span.className = "error";
    console.log(loginForm.childNodes);
    loginForm.childNodes[5].before(span);
  })

  async function cargarUsuarios() {
    try {
        const response = await fetch("http://localhost:8080/usuario/buscar", {
            method: 'GET',
            headers: new Headers({'Content-type': 'application/json'}),
            mode: 'cors'  
        });

        const usuarios = await response.json();
        return usuarios;
    } catch (error) {
        console.error('Error al cargar usuarios:', error);
    }
  }

  registerForm.addEventListener("submit", async function(event) {
    event.preventDefault();

    const email = registerForm.querySelector('input[type="email"]').value;
    const nombre = registerForm.querySelector('input[type="text"]').value;
    const password = registerForm.querySelector('input[type="password"]').value;

    var usuario = {
      correo: email,
      nombre: nombre,
      contraseña: password,
    }

    fetch('http://localhost:8080/usuario/registro', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      mode: 'cors',
      body: JSON.stringify(usuario),
    })
    .then(response => {
      if (!response.ok) {
        // Si la respuesta no es exitosa, verificar el código de estado
        if (response.status === 409) {
          // Si el código de estado es 409, el correo está duplicado
          throw new Error('El correo electrónico ya está en uso.');
        } else {
          // Para otros códigos de estado, lanzar un error genérico
          throw new Error(`Error en la solicitud: ${response.status}`);
        }
      }
      return response.json();
    })
    .then(async data => {
      if (data.idusuario) {
        var usuarios = await cargarUsuarios();
        console.log(usuarios)
        for(let user of usuarios) {
          if(user.correo === usuario.correo) {
            var guardar = JSON.stringify( user );
            console.log(encriptarTexto(guardar, claveSecreta))
            localStorage.setItem('usuario', JSON.stringify(encriptarTexto(guardar, claveSecreta)));
            break;
          }
        }
        window.location.href = 'idioma.html';
      } else {
        // Mensaje de error o acción correspondiente
        // TODO: añadir mensaje de error
        span.textContent="El correo ya existe";
        span.className = "error";
        // Agregar el mensaje de error al DOM
        registerForm.childNodes[7].before(span);
      }
    })
    .catch(error => {
      // Manejar errores de red u otros errores HTTP
      // Aquí puedes mostrar un mensaje de error genérico o realizar otra acción
      console.error('Error en la solicitud:', error);
      // Agregar el mensaje de error al DOM
      span.textContent = error;
      span.className = "error";
      registerForm.childNodes[7].before(span);
    });
  

  })
}