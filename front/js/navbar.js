const navbar = `
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<!-- Si deseas utilizar íconos de Bootstrap, también puedes incluir Font Awesome -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">LinguoLearn</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <img src="perfil.jpg" alt="Perfil" class="perfil rounded-circle" width="30" height="30"> <!-- Agrega la foto de perfil del usuario -->
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                <button class="dropdown-item" onclick="cerrarSesion()">Cerrar Sesión</button>
              </div>
            </li>
          </ul>
        </div>
      </nav>

      <script>
      function cerrarSesion() {
          localStorage.removeItem('usuario');
          window.location.href = 'login.html';
      }
      </script>
` 

export { navbar }