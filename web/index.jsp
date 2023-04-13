<%-- 
    Document   : index
    Created on : 7 abr 2023, 15:27:18
    Author     : zunig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <link rel="shortcut icon" href="imagenes/memorand2.png">
    <head>
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anónimo">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        
        <nav class="navbar navbar-expand-lg navbar-light bg-light shadow ">
            <div class="container-fluid">
                <!-- Logo -->
                <a class="navbar-brand" href="">
                    <img src="imagenes/memorand2.png" alt="Logo de la empresa">
                </a>
                <!-- Nombre del proyecto -->
                <span class="navbar-text fs-5">
                    Memorand
                </span>
                <!-- Link a Gengram -->
                <a class="nav-link fs-5" href="http://gengram.gerdoc.com/">Gengram</a>
                <!-- Botón de Iniciar sesión -->
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <button class="btn btn-outline-secondary me-2 fs-6" data-bs-toggle="modal" data-bs-target="#loginModal" type="button">Iniciar sesión</button>
                <!-- Botón de Registrarse -->
                <button class="btn btn-primary fs-5" data-bs-toggle="modal" data-bs-target="#registerModal" type="button">Registrarse</button>
                    </li>
                </ul>
            </div>
        </nav>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
        
        <title>Memorand</title>
    </head>
    <body>
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
                    <div class="col-12 mb-3">
                        <label for="email" class="form-label">Nombre de usuario</label>
                        <input type="text" class="form-control" id="user">
                    </div>
                    <div class="col-12 mb-3">
                        <label for="password" class="form-label">Contraseña</label>
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
        
        <button onclick="location.href='menu_principal.jsp'">Menu principal</button>

    </body>
</html>
