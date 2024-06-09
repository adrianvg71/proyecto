import { claveSecreta, desencriptarTexto, encriptarTexto } from "./encriptar.js";
import { baseUrl } from "./constants.js";
import { footer } from "./footer.js";


window.onload = function() {
    var usuario = JSON.parse(desencriptarTexto(JSON.parse(localStorage.getItem('usuario')), claveSecreta));
    var select = document.querySelector("select");
    var texto = select.options[select.selectedIndex].text

    document.querySelector(".select-languaje button").addEventListener("click", async function() {
        usuario.idioma = texto;
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
            window.location.href="select-prueba.html";
            return response
        } catch (error) {
            console.error('Error al cargar usuarios:', error);
        }
    })

    document.body.insertAdjacentHTML('beforeend', footer);

}