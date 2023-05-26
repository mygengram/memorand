<%-- 
    Document   : signup
    Created on : 12 may 2023, 06:55:52
    Author     : alumno
--%>

<%@page import="java.util.Calendar"%>
<%@page import="com.memorand.helper.UsuariosHelper"%>
<%@page import="com.memorand.dao.Usuarios"%>
<%@page import="com.memorand.helper.Helpers"%>
<%@page import="com.memorand.helper.LoginHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="recursos/import.jsp"/>
        <link rel="shortcut icon" href="images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="bootstrap/style.css">
        <title>Memorand - Registrarse</title>
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
            UsuariosHelper helper = null;
            boolean flag = false;
            
            accion = request.getParameter("accion");
            if(accion != null && "registrar".equals(accion))
            {
                helper = new UsuariosHelper();
                flag = helper.addT();
                
                if(flag)
                {
        %>
                    <a href="login.jsp">
                        <button class="btn btn-primary fs-6 text-white" type="button" style="padding:2%;">Iniciar sesion</button>
                    </a>    
        <%
                }
            }
        %>
        
         <div class="container-fluid">
            <div class="row ">
                <div class="col-sm-2"></div>
                <div class="col-sm-8">
                    <br><br><br>
                    <div class="card">
                        <div class="card-body overflow-auto">
                    <div class="wrap d-md-flex">
			<div class="text-wrap p-2 p-lg-5 text-center d-flex align-items-center order-md-last">
                            <div class="text w-100">
                                <h2 style="color: #18988B;">Bienvenido </h2>
				<p>¿Ya tienes una cuenta?</p>
                                <a href="login.jsp" class="btn btn-light btn-custom rounded rounded-top-0">Ingresa</a>
                                <a href="index.jsp" class="btn btn-outline-secondary rounded rounded-top-0">Regresar</a>
                            </div>
			</div>
                        <div class="login-wrap p-4 p-lg-5">
                            <div class="d-flex">
                                <div class="w-100">
                                    <h3 class="mb-4" style="color: #75777B;">Registrate</h3>
                                </div>
                            </div>
                            <form id="form2" method="GET" action="signup.jsp" onsubmit="return validateForm()">
                                <div class="mb-3">
                                    <label for="user" class="form-label">Nombre de usuario</label>
                                    <input type="text" class="form-control rounded-5 rounded-top-0 border-secondary" id="user" name="user"/>
                                    <span id="userError" style="color:#dc3545"></span>
                                </div>
                                <div class="mb-3">
                                    <label for="pass" class="form-label">Contrase&ntilde;a</label>
                                    <input type="password" class="form-control rounded-5 rounded-top-0 border-secondary" id="pass" name="pass"/>
                                    <span id="passError" style="color:#dc3545"></span>
                                </div>
                                <div class="mb-3">
                                    <label for="name" class="form-label">Nombre real</label>
                                    <input type="text" class="form-control rounded-5 rounded-top-0 border-secondary" id="name" name="name"/>
                                    <span id="nameError" style="color:#dc3545"></span>
                                </div>
                                <div class="mb-3">
                                    <label for="ap" class="form-label">Apellido paterno</label>
                                    <input type="text" class="form-control rounded-5 rounded-top-0 border-secondary" id="ap" name="ap"/>
                                    <span id="apError" style="color:#dc3545"></span>
                                </div>
                                <div class="mb-3">
                                    <label for="am" class="form-label">Apellido materno</label>
                                    <input type="text" class="form-control rounded-5 rounded-top-0 border-secondary" id="am" name="am"/>
                                    <span id="amError" style="color:#dc3545"></span>
                                </div>
                                <div class="mb-3">
                                    <label for="fn" class="form-label">Fecha de nacimiento</label>
                                    <input type="date" class="form-control rounded-5 rounded-top-0 border-secondary" id="fn" name="fn"/>
                                    <span id="fnError" style="color:#dc3545"></span>
                                </div>
                                <div class="mb-3">
                                    <input type="submit" id="accion" name="accion" value="registrar">
                                </div>
                            </form>
                                </div>
                            </div>
                        </div>
                        </div>
                    </div>
                <div class="col-sm-2"></div>
            </div>
        </div>

        <script>
            <!--
                function validateTexto(obj , textoError, campoError )
                {
                    if( obj.value === undefined || obj.value.length <= 0 )
                    {
                        campoError.innerHTML = "<b>" + textoError + "</b>";
                        return false;
                    }
                    campoError.innerHTML = "";
                    return true;
                }

                function validateForm( )
                {
                    const arr = ['user','pass','name','ap','am','fn'];
                    let obj1, obj2;

                    var flag = true;
                    for( const aux of arr )
                    {
                        obj1 = document.getElementById(aux);
                        obj2 = document.getElementById(aux+'Error');
                        if(!validateTexto(obj1,"El campo " + aux + " es requerido",obj2))
                        {
                            flag = false;
                        }
                    }
                    return flag;
                }
            -->
        </script>   
    </body>
</html>
