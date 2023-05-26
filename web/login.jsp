<%@page import="com.memorand.helper.LoginHelper"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    
        <head>
        <jsp:include page="recursos/import.jsp"/>
        <link rel="shortcut icon" href="images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="bootstrap/style.css">
        <title>Memorand - Iniciar sesi&oacute;n</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-icons/font/bootstrap-icons.css">
        <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/323dc2b1ab.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
        <style>
            .btn-custom {
                background-color: #18988B;
                border-color: #ffffff;
                color: #ffffff;
            }

            .btn-custom:hover {
              background-color: #ffffff; 
              border-color: #18988B; 
              color: #18988B;
            }
        </style>
    <body>
        <%
            String accion = null;
            LoginHelper loginHelper = null;
            
            accion = request.getParameter("accion");
            if(accion != null && "login".equals(accion))
            {
                loginHelper = new LoginHelper();
                if(!loginHelper.login(request,response))
                {
        %>
                    <script>
                        <!--
                            alert('La contraseña o el usuario son incorrectos.');
                        -->
                    </script>
        <%
                }
            }
            
        %>
         <div class="container-fluid">
            <div class="row ">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <br><br><br><br><br><br>
                    <div class="card">
                        <div class="card-body overflow-auto">
                    <div class="wrap d-md-flex">
			<div class="text-wrap p-2 p-lg-5 text-center d-flex align-items-center order-md-last">
                            
                            <div class="text w-100">
                                <h2 style="color: #18988B;">Bienvenido </h2><h4 style="color: #18988B;">Inicia Sesi&oacute;n</h4>
				<p>¿No tienes una cuenta?</p>
                                <a href="signup.jsp" class="btn btn-light btn-custom rounded rounded-top-0">&Uacute;nete</a>
                            </div>
			</div>
                        <div class="login-wrap p-4 p-lg-5">
                            <div class="d-flex">
                                <div class="w-100">
                                    <h3 class="mb-4" style="color: #75777B;">Inicia Sesi&oacute;n</h3>
                                </div>
                            </div>
                            <form id="form1" method="POST" action="login.jsp">
                                <div class="mb-3">
                                  <label for="user" class="form-label">Nombre de usuario</label>
                                  <input type="text" class="form-control rounded-5 rounded-top-0 border-success" id="user" name="user" placeholder="Usuario">
                                </div>
                                <div class="mb-3">
                                  <label for="password" class="form-label">Contraseña</label>
                                  <input type="password" class="form-control rounded-5 rounded-top-0 border-success" id="pass" name="pass"  placeholder="Contraseña">
                                </div>
                                <button type="submit" class="btn btn-light btn-custom rounded-5 rounded-top-0" style="width: 250px;" id="accion" name="accion" value="login">Iniciar sesión</button>
                            </form>
                        </div>
		    </div>
		    </div>
		    </div>
                </div>
                <div class="col-sm-3"></div>
            </div>
        </div>
    </body>
</html>
