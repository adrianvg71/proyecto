const navbar = `
<style>
nav {
  /* position: absolute;
  top: 0; */
  width: 100%;
  display: flex;
  flex-flow: row wrap;
  justify-content: space-between;
  align-items: center;
  /* background-color: #d9eff7; */
}

nav h1 {
  cursor: pointer;
  transition: opacity .3s ease-in-out;
}

nav h1:hover {
  opacity: .6;
}

.vacio {
  width: 46px;
}

.titulo {
  font-size: 3.5rem;
  letter-spacing: 2px;
  font-weight: bold;
  color: #1CB0F6;
  width: fit-content;
  /* padding-top: 25px; */
}

nav > div {
  margin: 20px 2.5rem;
  font-size: 2.25rem;
}

.perfil {
  position: relative;
  color: #1CB0F6;
  display: flex;
  flex-direction: row;
  align-items: flex-end;
  cursor: pointer;
  transition: opacity .2s ease;
  /* margin-top: -5px; */
}

.perfil .fa-caret-down{
  font-size: 1.30rem;
}

.perfil:hover {
  opacity: .7;
}

/* profile */
.dropdown {
  visibility: hidden;
  opacity: 0;
  background-color: #ffffff;
  position: absolute;
  top: 50px;
  right: -10px;
  width: fit-content;
  height: fit-content;
  max-height: 400px;
  overflow: auto;
  transition: opacity .2s ease-in-out, visibility .2s ease-in-out;
  z-index: 10;
  border-radius: 10px;
  box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.1), 0 8px 10px -6px rgba(0, 0, 0, 0.1);
}

.dropdown-content {
  display: flex;
  flex-direction: column;
  /* gap: 15px; */
}

.dropdown-content > :not(:last-child) {
  border-bottom: 2px solid #1CB0F6; /* Define el estilo de la línea divisoria */
}

.dropdown-content a {
  text-align: center;
  text-decoration: none;
  padding: .5rem 1rem .5rem 1rem;
  color: #888;
  font-weight: 500;
  font-size: 1.10rem;
  cursor: pointer;
  transition: background-color .2s ease, color .2s ease;
}

.dropdown-content a:hover {
  background-color: #1CB0F6;
  color: #ffffff;
}

.fa-caret-down {
  transition: transform .2s ease-in-out;
  transform: rotate(0deg);
}

.rotate { 
  transform: rotate(-180deg);
}

.shown {
  visibility: visible;
  opacity: 1;
}

@media(max-width: 800px) {
  .vacio {
    display: none;
  }

  nav h1 {
    font-size: 3rem;
  }

  nav > div {
    margin: 10px 20px;
  }
}

</style>

<nav>
<div class="vacio"></div>
<div class="titulo">
    <h1 onclick="window.location.href='index.html'">LinguoLearn</h1>
</div>
<div class="perfil">
    <i class="fa-solid fa-circle-user"></i>
    <i class="fa-solid fa-caret-down"></i>
</div>
<div class="dropdown z-10 absolute top-10 right-4 invisible opacity-0 transition-all ease-linear duration-400">
    <div class="w-80 h-80  bg-[#ffdec2] rounded-lg  ">
        <div class="dropdown-content" id="overflow-y-auto h-[17.2rem] flex flex-col p-4 gap-2 ">
            <a href="perfil.html">PERFIL</a>
            <a href="login.html" onclick="localStorage.clear()">CERRAR SESION</a>
            
        </div>
    </div>
</div>
<script type="module">
  import { claveSecreta, desencriptarTexto } from "./js/encriptar.js";
  var usuario = JSON.parse(desencriptarTexto(JSON.parse(localStorage.getItem('usuario')), claveSecreta));
  if(usuario.tipo === 'ADMIN') {
    document.querySelector(".dropdown-content").innerHTML += '<a class="admin" href="admin.html">ADMIN</a>'
  }
  let perfil = document.querySelector(".perfil")
  let dropdown = document.querySelector(".dropdown")
  /* Mostrar dropdown */
  perfil.addEventListener("click", function(event) {
    dropdown.classList.toggle('shown');
    document.querySelector(".fa-caret-down").classList.toggle('rotate')
    event.stopPropagation();
  })

  document.addEventListener("click", function(event) {
    if (!dropdown.contains(event.target) && !perfil.contains(event.target)) {
      dropdown.classList.remove('shown');
      document.querySelector(".fa-caret-down").classList.remove('rotate');
    }
  });
</script>
</nav>
` 

export { navbar }