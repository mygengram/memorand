<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Memorand | Inicio</title>
        <link rel="shortcut icon" href="images/me-logoP.png">
        <link rel="stylesheet" href="styles.css">
        <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/323dc2b1ab.js" crossorigin="anonymous"></script>
    </head>
    
    <body>
        <!-- NAVBAR -->
        <nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top" style="padding:1%;">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">
                    <img src="images/me-logoEX.png" alt="memorand" width="200" style="margin-left:40%">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" style="margin-right:15%;">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <!-- BUTTONS -->
                    <ul class="navbar-nav ms-auto" style="margin-right: 10%">
                        <li class="nav-item">
                            <button class="btn btn-outline-secondary me-2 fs-6" data-bs-toggle="modal" data-bs-target="#loginModal" type="button">Iniciar sesión</button>
                            <button class="btn btn-primary fs-6 text-white" data-bs-toggle="modal" data-bs-target="#registerModal" type="button">Registrarse</button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <!-- PRESENTATION -->
        <div class="container text-center">
            <div class="row">
                <div class="col">
                </div>
                <div class="col-8">
                    <img src="images/me-bee.png" alt="icon" width="100" style="margin-top:8%;">
                    <h1 style="padding:4%"><strong>Organiza tu día sin complicaciones</strong></h1>
                    <p style="margin-left: 6%; margin-right: 6%;">Memorand es tu espacio ideal para planear tu día a día en poco tiempo, permitíendote saber en todo momento lo que quieres hacer.</p>
                    <!-- PRESENTATION <button class="btn btn-primary fs-6 text-white" data-bs-toggle="modal" data-bs-target="#loginModal" type="button" style="padding:2%;">Ir a Memorand</button> -->
                    <button class="btn btn-primary fs-6 text-white" onclick="location.href='main.jsp'" type="button" style="padding:2%;">Ir a Memorand</button>
                    <br><br><br>
                </div>
                <div class="col">
                </div>
            </div>
        </div>

        <!-- FOOTER -->
        <div class="container-fluid bg-body-tertiary" style="padding:5%;" id="contacto">
            <div class="row">
                <div class="col-4 text-center">
                    <img src="images/logoextG.png" alt="gengram" style="width: 30%;">
                    <h2 class="text-body-tertiary"><strong>Contacto</strong></h2>
                    <h6 class="text-body-tertiary">&copy; gengram 2023</h6>
                </div>
                <div class="col-8 text-left">
                    <a href="mailto:mygengram@gmail.com?Subject=Hola">
                        <h6><i class="fa fa-envelope"></i>  Escr&iacute;benos</h6>
                    </a>
                    <a href="https://github.com/mygengram">
                        <h6><i class="fa-brands fa-github-alt"></i>  Repositorios</h6>
                    </a>
                    <a href="http://gengram.gerdoc.com">
                        <h6><i class="fa-solid fa-house"></i>  Gengram</h6>
                    </a>
                </div>
            </div>
        </div>

                <!-- Modal de inicio de sesión -->
                <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                          <div class="modal-header">
                            <h5 class="modal-title fs-4" id="loginModalLabel">Iniciar sesión</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                          </div>
                          <div class="modal-body">
                            <form row g-3>
                              <div class="mb-3">
                                <label for="email" class="form-label">Nombre de usuario</label>
                                <input type="text" class="form-control" id="user">
                              </div>
                              <div class="mb-3">
                                <label for="password" class="form-label">Contraseña</label>
                                <input type="password" class="form-control" id="password">
                              </div>
                              <button type="submit" class="btn btn-primary fs-6">Iniciar sesión</button>
                            </form>
                            <p class="my-3">¿No tienes una cuenta? <a href="#" data-bs-toggle="modal" data-bs-target="#registerModal" data-bs-dismiss="modal">Regístrate aquí</a>.</p>
                          </div>
                        </div>
                      </div>
                </div>
                <!-- Modal de registro -->
                <div class="modal fade" id="registerModal" tabindex="-1" aria-labelledby="registerModalLabel" aria-hidden="true">
                  <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title fs-4" id="registerModalLabel">Registrarse</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                      </div>
                      <div class="modal-body">
                        <form class="row g-3">
                            <div class="col-md-4 mb-3">
                                <label for="name" class="form-label">Nombre</label>
                                <input type="text" class="form-control" id="name">
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="apeP" class="form-label">Apellido Paterno </label>
                                <input type="text" class="form-control" id="apeP">
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="apeM" class="form-label">Apellido Materno </label>
                                <input type="text" class="form-control" id="apeM">
                            </div>
                             <div class="col-12">
                                <label for="fecha" class="form-label">Fecha de Nacimiento</label>
                                <input type="date" class="form-control" id="fecha" name="fecha" placeholder="dd/mm/aaaa" data-bs-toggle="tooltip" data-bs-placement="left" title="Selecciona una fecha">
                            </div>
                            <div class="col-12 mb-3">
                                <label for="email" class="form-label">Nombre de usuario</label>
                                <input type="text" class="form-control" id="user">
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="password" class="form-label">Contraseña</label>
                                <input type="password" class="form-control" id="password">
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="password" class="form-label">Confirmar contraseña</label>
                                <input type="password" class="form-control" id="password">
                            </div>
                            <div class="col-12">
                            <button type="submit" class="btn btn-primary fs-6">Registrarse</button>
                            </div>
                        </form>
                        <p class="my-3">¿Ya tienes una cuenta? <a href="" data-bs-toggle="modal" data-bs-target="#loginModal" data-bs-dismiss="modal">Inicia sesión aquí</a>.</p>
                      </div>
                    </div>
                  </div>
                </div>
            <body>
        
    </body>
</html>
