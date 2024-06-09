import { claveSecreta, encriptarTexto, desencriptarTexto } from "./encriptar.js";
import { baseUrl } from "./constants.js";

window.onload = function() {

  var usuario = JSON.parse(desencriptarTexto(JSON.parse(localStorage.getItem('usuario')), claveSecreta));

/* --------BUSCAR EJERCICIO --------- */  

async function obtenerEjercicio() {
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

/* Funcion principal donde ya tenemos el ejercicio */
let pregunta_actual = 0;
if(localStorage.getItem('pregunta_actual')) {
  pregunta_actual = parseInt(desencriptarTexto(JSON.parse(localStorage.getItem('pregunta_actual')), claveSecreta))
} else {
  localStorage.setItem('pregunta_actual', JSON.stringify(encriptarTexto(pregunta_actual, claveSecreta)))
}
let aciertos = 0;
if(localStorage.getItem('aciertos')) {
  aciertos = parseInt(desencriptarTexto(JSON.parse(localStorage.getItem('aciertos')), claveSecreta))
} else {
  localStorage.setItem('aciertos', JSON.stringify(encriptarTexto(aciertos, claveSecreta)))
}
let fallos = 0;
if(localStorage.getItem('fallos')) {
  fallos = parseInt(desencriptarTexto(JSON.parse(localStorage.getItem('fallos')), claveSecreta))
} else {
  localStorage.setItem('fallos', JSON.stringify(encriptarTexto(fallos, claveSecreta)))
}
async function main() {
  var ejercicio = await obtenerEjercicio();

  /* Pintar nombre de ejercicio */
  document.getElementById("ejercicio_nombre").textContent = ejercicio.nombre

  /* Pintar informacion */
  pintarInformacion()
  function pintarInformacion() {
    let divPregunta = document.querySelector(".pregunta");
    divPregunta.querySelector("p").textContent = `Pregunta ${pregunta_actual+1}/${ejercicio.preguntas.length}`
    divPregunta.querySelector("h3").textContent = `${ejercicio.preguntas[pregunta_actual].enunciado}`
    if(ejercicio.nombre == "Prueba inicial") {
      divPregunta.querySelector(".vidas").style.display = "none";
    } else {
      divPregunta.querySelector(".vidas").innerHTML = "";
      for(let i = 2; i >= 0; i--) {
        let corazon = document.createElement("i")
        corazon.style.color = "#85d7fa";
        corazon.classList.add("fa-heart")
        if(i>=fallos) {
          corazon.classList.add("fa-solid")
        } else {
          corazon.classList.add("fa-regular")
        }
        divPregunta.querySelector(".vidas").append(corazon);
      }
    }


    let divOpciones = document.querySelector(".opciones")
    divOpciones.innerHTML = "";
    ejercicio.preguntas[pregunta_actual].opciones.forEach(opcion => {
      let div = document.createElement("div")
      div.classList.add("opcion");
      let p = document.createElement("p");
      p.textContent = opcion.descripcion;
      div.append(p);
      divOpciones.append(div);
    })
    let boton = document.getElementById("comprobar")
    if(boton) {
      boton.remove();
    }
    document.body.insertAdjacentHTML('beforeend', `<button class="button-19" id="comprobar">Comprobar</button>`);
  }

  /* Corroborar que la altura de las celdas siempre sera el mismo 
  para todas basandonos en la altura del parrafo mas alto */ 
  const divOpciones = document.querySelector('.opciones');
  const opciones = divOpciones.querySelectorAll('.opcion');

    let alturaMaxima = 0;

    opciones.forEach(celda => {
      const alturaCelda = celda.children[0].clientHeight;
      if (alturaCelda > alturaMaxima) {
        alturaMaxima = alturaCelda;
      }
    });

    opciones.forEach(celda => {
      celda.style.height = `${alturaMaxima}px`;
    });

  /* -----------------SELECCIONAR UNA OPCION------------------------ */

  opciones.forEach(opcion => {
    opcion.addEventListener("click", seleccionarOpcion)
  })

  function seleccionarOpcion(even) {
    opciones.forEach(opcion => {
      opcion.classList.remove("selected");
    });
    even.currentTarget.classList.add("selected");
    boton.style.opacity = 1
    boton.style.pointerEvents = "all"
  }

  /* -------------------COMPROBAR SI ES CORRECTA--------------------- */

  let boton = document.getElementById("comprobar")
  boton.addEventListener("click", comprobarRespuesta)

  function comprobarRespuesta() {
    let opciones = document.querySelectorAll(".opciones .opcion");
    let divSeleccionado;
    let opcionSeleccionada = -1
    opciones.forEach((opcion, index) => {
      if(opcion.classList.contains("selected")) {
        divSeleccionado = opcion;
        opcionSeleccionada = index
      }
    });
    /* ACIERTO */
    if(ejercicio.preguntas[pregunta_actual].opciones[opcionSeleccionada].correcta === true) {
      aciertos++;
      divSeleccionado.classList.remove("selected");
      divSeleccionado.classList.add("correcto")
      boton.classList.toggle("correcto");
    } 
    /* FALLO */
    else {
      fallos++;
      divSeleccionado.classList.remove("selected");
      divSeleccionado.classList.add("error")
      ejercicio.preguntas[pregunta_actual].opciones.forEach((opcion, index) => {
        if(opcion.correcta === true) {
          opciones[index].classList.add("correcto");
        }
      })
      boton.classList.toggle("error");
    }
    if(pregunta_actual+1 >= ejercicio.preguntas.length) {
      boton.textContent = "TERMINAR"
    } else {
      boton.textContent = "Continuar"
    }
    boton.removeEventListener("click", comprobarRespuesta)
    boton.addEventListener("click", continuar)
  }

  function continuar() {
    pregunta_actual++
    localStorage.setItem('pregunta_actual', JSON.stringify(encriptarTexto(pregunta_actual, claveSecreta)))
    localStorage.setItem('aciertos', JSON.stringify(encriptarTexto(aciertos, claveSecreta)))
    localStorage.setItem('fallos', JSON.stringify(encriptarTexto(fallos, claveSecreta)))
    boton.removeEventListener("click", continuar)
    
    if(fallos == 4 && ejercicio.nombre != "Prueba inicial") {
      perder()
    } else if(boton.textContent === "TERMINAR") {
      fin()
    } else {
      main();
    }
  }

  async function fin() {
    document.body.style.overflowY = "hidden";
    if (ejercicio.nombre == "Prueba inicial") {
      finPruebaInicial()
    } else if(ejercicio.nombre.split(" ")[0] == "Examen") {
      finExamen()
    } else {
      finEjercicio()
    }
    var usuarioEjercicio = {
      usuario: usuario,
      ejercicio: ejercicio,
      aciertos: aciertos
    }
    /* Insertar la realizacion del ejercicio */
    /* DESCOMENTAR EN PRODUCCION */

    const response = await fetch(`${baseUrl}/usuarioejercicio/insertar`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      mode: 'cors',
      body: JSON.stringify( usuarioEjercicio ),
    })
    localStorage.removeItem('aciertos');
    localStorage.removeItem('pregunta_actual');
    localStorage.removeItem('fallos');
  }

  let nivel;

  function finPruebaInicial() {
    document.body.innerHTML = ""
    /* Calcular nivel */
    console.log(aciertos)
    switch(aciertos) {
        case 1:
        case 2:
          nivel = 'A2';
          break;
        case 3:
        case 4:
          nivel = 'B1';
          break;
        case 5:
        case 6:
          nivel = 'B2';
          break;
        case 7:
        case 8:
          nivel = 'C1';
          break;
        case 9:
        case 10:
          nivel = 'C2';
          break;
        default:
          nivel = 'A1';
    }
    let divFin = document.createElement("div");
    divFin.classList.add("divFin");
    let h2 = document.createElement("h2");
    h2.textContent = "ENHORABUENA";
    let p = document.createElement("p");
    p.textContent = `Has acertado ${aciertos}/${ejercicio.preguntas.length} preguntas en la prueba de nivel`
    let h5 = document.createElement("h5");
    h5.innerHTML = `Tienes un nivel de <span>${nivel}</span>`
    let boton = document.createElement("button");
    boton.classList.add("button-19")
    boton.style.opacity = 1;
    boton.style.pointerEvents = 'all';
    boton.style.margin = 0;
    boton.style.width = 'fit-content'
    boton.style.padding = '13px 40px 13px 40px'
    boton.textContent = "ACEPTAR";
    boton.addEventListener("click", aceptar)
    divFin.append(h2, p, h5, boton)
    document.body.append(divFin)
    pintarConfeti();
  }

  function finEjercicio() {
    document.body.innerHTML = ""
    let divFin = document.createElement("div");
    divFin.classList.add("divFin");
    let h2 = document.createElement("h2");
    h2.textContent = "ENHORABUENA";
    let h5 = document.createElement("h5");
    h5.innerHTML = `Has completado el ${ejercicio.nombre.split(" ")[0]} ${ejercicio.nombre.split(" ")[1]} - <span>${ejercicio.nombre.split(" ")[3]}</span>`
    let boton = document.createElement("button");
    boton.classList.add("button-19")
    boton.style.opacity = 1;
    boton.style.pointerEvents = 'all';
    boton.style.margin = 0;
    boton.style.width = 'fit-content'
    boton.style.padding = '13px 40px 13px 40px'
    boton.textContent = "ACEPTAR";
    boton.addEventListener("click", aceptar)
    divFin.append(h2, h5, boton)
    document.body.append(divFin)
    pintarConfeti();
  }

  function finExamen() {
    calcularNivel()
    document.body.innerHTML = ""
    let divFin = document.createElement("div");
    divFin.classList.add("divFin");
    let h2 = document.createElement("h2");
    h2.textContent = "ENHORABUENA";
    let p = document.createElement("p");
    p.innerHTML = `Has completado el examen de nivel <span>${usuario.nivel}</span>`
    let h5 = document.createElement("h5");
    h5.innerHTML = `Has avanzado al siguiente nivel <span>${nivel}</span>`
    let boton = document.createElement("button");
    boton.classList.add("button-19")
    boton.style.opacity = 1;
    boton.style.pointerEvents = 'all';
    boton.style.margin = 0;
    boton.style.width = 'fit-content'
    boton.style.padding = '13px 40px 13px 40px'
    boton.textContent = "ACEPTAR";
    boton.addEventListener("click", aceptar)
    divFin.append(h2, p, h5, boton)
    document.body.append(divFin)
    pintarConfeti();
  }

  async function aceptar() {
    if(nivel) {
      await editarNivel()
    }
    window.location.href = "index.html";
  }

  /* Funcion para editar nivel cuando sea necesario */
  async function editarNivel() {
    usuario.nivel = nivel;
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
      return response
  } catch (error) {
      console.error('Error al cargar usuarios:', error);
  }
  }

  function perder() {
    localStorage.removeItem('aciertos');
    localStorage.removeItem('pregunta_actual');
    localStorage.removeItem('fallos');
    document.body.innerHTML = "";
    document.body.style.overflowY = "hidden";
    let divFin = document.createElement("div");
    divFin.classList.add("divFin");
    let h2 = document.createElement("h2");
    h2.style.color = "#ff3333"
    h2.textContent = "HAS PERDIDO";
    let p = document.createElement("p");
    p.textContent = `Puedes volver a intentarlo o ir al menú principal`
    let divBotones = document.createElement("div");
    divBotones.classList.add("divBotones")
    let botonMenu = document.createElement("button");
    let botonReintentar = document.createElement("button");
    divBotones.append(botonMenu, botonReintentar)

    botonMenu.classList.add("button-19", "boton-menu")
    botonMenu.style.opacity = 1;
    botonMenu.style.pointerEvents = 'all';
    botonMenu.style.margin = 0;
    botonMenu.textContent = "MENU PRINCIPAL";
    botonMenu.addEventListener("click", function() {
      window.location.href = "index.html"
    })

    botonReintentar.classList.add("button-19")
    botonReintentar.style.opacity = 1;
    botonReintentar.style.pointerEvents = 'all';
    botonReintentar.style.margin = 0;
    botonReintentar.innerHTML = `<i class="fa-solid fa-rotate-left" style="color: #ffffff;"></i> REINTENTAR`;
    botonReintentar.addEventListener("click", function() {
      window.location.reload();
    })

    divFin.append(h2, p, divBotones)
    document.body.append(divFin)
  }

  function calcularNivel() {
    switch(usuario.nivel) {
      case 'A1':
        nivel = 'A2';
        break;
      case 'A2':
        nivel = 'B1';
        break;
      case 'B1':
        nivel = 'B2';
        break;
      case 'B2':
        nivel = 'C1';
        break;
      case 'C1':
        nivel = 'C2';
        break;
      default:
        nivel = 'MAX';
        break;
    }
  }
}



function pintarConfeti() {
  confetti({
    particleCount: 1000,
    startVelocity: 80,
    angle: 60,
    spread: 70,
    origin: { 
        x: 0,
        y: 1.2 
    }
  });
  // and launch a few from the right edge
  confetti({
      particleCount: 1000,
      startVelocity: 80,
      angle: 120,
      spread: 70,
      origin: { x: 1, y:1.2 }
  });
}



main();
}

