<%-- 
    Document   : c
    Created on : 19 may 2023, 08:29:08
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../recursos/import.jsp"/>
        <link rel="shortcut icon" href="../../images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="../../bootstrap/style.css">
        <title>Memorand - Crear agenda</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-icons/font/bootstrap-icons.css">
        <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/323dc2b1ab.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <br><br><br>
        <div class="container-fluid">
            <div class="row ">
                <div class="col-sm-2"></div>
                
                <div class="col-sm-8">
                    <form id="form1" method="POST" action="login.jsp">
                        <div class="card">
                            <div class="card-body overflow-auto">
                                <div class="wrap d-md-flex">
                                    <div class="login-wrap p-4 p-lg-5">
                                        <div class="text-wrap p-2 p-lg-5 text-center d-flex align-items-center order-md-last">
                                            <div class="text w-100">
                                                <h2 style="color: #18988B;">Bienvenido </h2>
                                                <p>¿No tienes una cuenta?</p>
                                                <a href="signup.jsp" class="btn btn-light btn-custom rounded rounded-top-0">&Uacute;nete</a>
                                                <a href="index.jsp" class="btn btn-outline-secondary rounded rounded-top-0">Regresar</a>
                                            </div>
                                        </div>
                                        <div class="d-flex">
                                            <div class="w-100">
                                                <h3 class="mb-4" style="color: #75777B;">Crear agenda</h3>
                                            </div>
                                        </div>
                                        <div class="mb-3">
                                            <label for="user" class="form-label">Nombre de la agenda</label>
                                            <input type="text" class="form-control rounded-5 rounded-top-0 border-success" id="user" name="user" placeholder="Nombre">
                                        </div>
                                        <div class="mb-3">
                                            <label for="desc" class="form-label">Descripci&oacute;n</label>
                                            <textarea class="form-control rounded-3 rounded-top-0 border-success" id="desc" name="desc"  placeholder="Descripci&oacute;n"></textarea>
                                        </div>
                                        <button type="submit" class="btn btn-light btn-custom rounded-5 rounded-top-0" style="width: 250px;" id="accion" name="accion" value="login">Iniciar sesión</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                
                <div class="col-sm-2"></div>
            </div>
        </div>
    </body>
</html>
