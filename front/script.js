window.onload = function() {
    let divUsuarios = document.querySelector(".usuarios");
    var fotoPerfil = ``;

    async function cargarUsuarios() {
        try {
            const response = await fetch("http://localhost:8080/usuario/buscar", {
                method: 'GET',
                headers: new Headers({'Content-type': 'application/json'}),
                mode: 'cors'  
            });
    
            const usuarios = await response.json();
            console.log(usuarios);
            return usuarios;
        } catch (error) {
            console.error('Error al cargar usuarios:', error);
        }
    }

    async function cargarGato() {
        try {
            const response = await fetch("https://cataas.com/cat?json=true");
            const gato = await response.json();
            return gato;
        } catch(error) {
            console.error("Error al cargar un gato: " + error)
        }
    }

    async function pintarUsuarios() {
        let usuarios = await cargarUsuarios();
        for(let usuario of usuarios) {
            let divUsu = document.createElement("div");
            divUsu.classList.add("usuario")
            let avatar = document.createElement("img");
            let gato = await cargarGato();
            fotoPerfil = `https://cataas.com/cat/${gato._id}`
            avatar.src = fotoPerfil
            let correo = document.createElement("h1");
            correo.textContent = `Correo: ${usuario.correo}`;
            let nombre = document.createElement("span");
            nombre.textContent = `Nombre: ${usuario.nombre}`;
            divUsu.append(avatar, correo, nombre);
            divUsuarios.append(divUsu);
        }
        return fotoPerfil;
    }

    async function cargarFpf() {
        let pfp = await pintarUsuarios();
        let img = document.querySelector(".perfil");
        img.src = pfp;
    }

    cargarFpf();

}
