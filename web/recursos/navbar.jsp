<%-- 
    Navbar Memorand by Gengram � 2023
--%>

<nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top" style="padding: 1%">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">
            <img src="../../images/logotypes/me-logoEX.png" alt="Logo de la empresa" width="200" style="margin-left:40%">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation" style="margin-right:15%;">
            <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse ms-auto"" id="navbarNav" style="margin-right:15%;">
        <ul class="navbar-nav  ms-auto">
            <button type="button" class="btn" data-bs-toggle="offcanvas" data-bs-target="#offcanvas1" aria-expanded="false" aria-controls="contenido" onclick="toggleNav()">
                <i class="bi bi-house-door-fill text-body-tertiary" style="font-size:20pt"></i>
            </button>
            <li class="nav-item dropstart  ms-auto">
                <a class="nav-link dropstart-toggle" href="#" id="usuario" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="bi bi-person-fill text-body-tertiary" style="font-size:20pt"></i>
                </a>
                <ul class="dropdown-menu mt-5 " aria-labelledby="usuario">
                    <li>
                        <a class="dropdown-item" href="cuenta/index.jsp">Configuracion</a>
                    </li>
                    <li><hr class="dropdown-divider"></li>
                    <li>
                        <form>
                            <input class="btn btn-outline-secondary me-1 fs-12" data-bs-toggle="modal" type="button" type="submit" id="accion" name="accion" value="Salir" style="margin-left: 9%"/>
                        </form>
                    </li>
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

 <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvas1" aria-labelledby="offcanvas1Label" style="width: 320px">
  <div class="offcanvas-header">
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close" style="margin-top:8%" ></button>
  </div>
  <div class="offcanvas-body" style="margin-top: 2%">
    <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <a href="index.jsp" class="nav-link" aria-current="page">
          <i class="bi bi-house-door-fill" style="font-size:18pt">    Inicio</i>
        </a>
      </li>
      <hr style="opacity: 100; height: 2px;">
      <li>
        <a href="personal/index.jsp" class="nav-link">
          <i class="bi bi-person-fill" style="font-size:18pt">    Mi agenda</i>
        </a>
      </li>
      <li>
        <a href="comunitarias/index.jsp" class="nav-link">
          <i class="bi bi-people-fill" style="font-size:18pt">    Agendas comunitarias</i>
        </a>
      </li>
    </ul>
  </div>
</div>