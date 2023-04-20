<link rel="shortcut icon" href="images/me-logoP.png">
<!-- Barra de navegacion horizontal -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light shadow" style=" width: 100%">
    <button  type="button" class="btn" data-bs-toggle="offcanvas" data-bs-target="#offcanvas1" aria-expanded="false" aria-controls="contenido" onclick="toggleNav()"><i class="bi bi-list icono-grande"></i></button>
    <div class="container-fluid">
        <a class="navbar-brand" href="main.jsp">
            <img src="images/me-logoEX.png" alt="Logo de la empresa" width="200">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse ms-auto"" id="navbarNav">
        <form class="d-flex w-45 mt-3 align-items-center ms-auto">
            <input class="form-control form-control-xl ms-20 me-1" type="search" placeholder="Nombre de una agenda..." aria-label="Buscar">
            <button class="btn btn-primary fs-6 text-white" type="submit">Buscar</button>
        </form>
            
        <ul class="navbar-nav  ms-auto">
            <li class="nav-item dropstart ">
                <a class="nav-link dropstart-toggle" href="#" id="notificaciones" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="bi bi-bell icono-grande"></i>
                </a>
                <ul class="dropdown-menu mt-5" aria-labelledby="notificaciones">
                    <li><a class="dropdown-item" href="#">Notificación 1</a></li>
                    <li><a class="dropdown-item" href="#">Notificación 2</a></li>
                    <li><a class="dropdown-item" href="#">Notificación 3</a></li>
                </ul>
            </li>
            <li class="nav-item dropstart  ms-auto">
                <a class="nav-link dropstart-toggle" href="#" id="usuario" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="bi bi-person icono-grande"></i>
                </a>
                <ul class="dropdown-menu mt-5 " aria-labelledby="usuario">
                    <li><a class="dropdown-item" href="#">Configuración</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#">Cerrar sesión</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</nav>

<script>
    function toggleNav() {
        var nav = document.getElementById("contenido");
        if (nav.classList.contains("show")) {
            nav.classList.remove("show");
        } else {
            nav.classList.add("show");
        }
    }
</script>

 <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvas1" aria-labelledby="offcanvas1Label" style="width: 280px">
  <div class="offcanvas-header">
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close" style="margin-top:8%" ></button>
  </div>
  <div class="offcanvas-body" style="margin-top: 2%">
    <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <a href="main.jsp" class="nav-link" aria-current="page">
          <i class="bi bi-house-door-fill"></i>
          Inicio
        </a>
      </li>
      <hr style="opacity: 100; height: 2px;">
      <li>
        <a href="agenda_personal.jsp" class="nav-link">
          <i class="bi bi-person-fill"></i>
          Mi agenda
        </a>
      </li>
      <li>
        <a href="agendas_comunitarias.jsp" class="nav-link">
          <i class="bi bi-people-fill"></i>
          Agendas comunitarias
        </a>
      </li>
    </ul>
  </div>
</div>
