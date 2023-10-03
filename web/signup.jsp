<%@page import="com.memorand.helper.RolUsuarioHelper"%>
<%@page import="com.memorand.helper.Helpers"%>
<%@page import="com.memorand.helper.UsuariosHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="recursos/import.jsp"/>
        <link rel="shortcut icon" href="images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="bootstrap/style.css">
        <title>Memorand - Registrarse</title>
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
        
        .border-success{
            border-color: #18988B;
        }
        
        .bg{
            background-image: url(images/extras/logc.jpg);
            background-position: center center;
        }
    </style>
    
    <body>
        <%
            String accion = request.getParameter("a");;
            Helpers usuarioHelper = null;
            Helpers rolUsuarioHelper = null;
            boolean flag1 = false;
            
            if(accion != null && "n".equals(accion))
            {
        %>
        <!-- Botón regresar -->
        <div class="text-start">
            <a href="index.jsp"><button class="btn btn-light btn-custom border-success rounded-circle shadow mt-3 mx-3"><i class="bi bi-arrow-return-left"></i></button></a>
        </div>
        <!-- Signup -->
        <div class="container w-75 mt-3 rounded shadow-lg my-5" style="width: 70%; height: 20%;">
            <div class="row align-items-lg-stretch">
                <!-- Img -->
                <div class="col bg rounded d-none d-lg-block col-md-5 col-lg-5 col-xl-6 p-5"></div>
                <!-- Col Login -->
                <div class="col rounded-end p-5">
                    <div class="text-end">
                        <img src="images/logotypes/me-logoP.png" width="48" alt="">
                    </div>
                    <div class="fw-bold text-center py-5 fs-4" style="color: #18988B">Registrarse</div>
                    <!-- Form -->
                    <form id="form2" method="POST" action="signup.jsp" onsubmit="return validateForm()">
                        <div class="mb-3">
                            <label for="user" class="form-label">Nombre de usuario</label>
                            <input type="text" class="form-control rounded-5 border-success" id="user" name="user"/>
                            <span id="userError" style="color:#dc3545"></span>
                        </div>
                        <div class="mb-3">
                            <label for="pass" class="form-label">Contrase&ntilde;a</label>
                            <input type="password" class="form-control rounded-5 border-success" id="pass" name="pass"/>
                            <span id="passError" style="color:#dc3545"></span>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="mb-3">
                                    <label for="name" class="form-label">Nombre</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="name" name="name"/>
                                    <span id="nameError" style="color:#dc3545"></span>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="mb-3">
                                    <label for="ap" class="form-label">Apellido paterno</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="ap" name="ap"/>
                                    <span id="apError" style="color:#dc3545"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <div class="mb-3">
                                    <label for="am" class="form-label">Apellido materno</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="am" name="am"/>
                                    <span id="amError" style="color:#dc3545"></span>
                                </div>
                            </div>
                            <div class="col">
                                <div class="mb-3">
                                    <label for="fn" class="form-label">Fecha de nacimiento</label>
                                    <input type="date" class="form-control rounded-5  border-success" id="fn" name="fn"/>
                                    <span id="fnError" style="color:#dc3545"></span>
                                </div>
                            </div>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-light btn-custom rounded-5 " id="a" name="a" value="r">Registrarse</button>
                        </div>
                        <div class="my3 mt-2 text-center">
                            <span>¿Ya tienes una cuenta? <a href="login.jsp" style="text-decoration: none;">Inicia Sesi&oacute;n</a></span><br>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%
            }   
            usuarioHelper = new UsuariosHelper().addRequest(request);
            if(accion != null && "r".equals(accion)) {
                flag1 = usuarioHelper.addT();
            }
            if(flag1) {
                rolUsuarioHelper = new RolUsuarioHelper().addRequest(request);
                rolUsuarioHelper.addT();
        %>
            <jsp:forward page="login.jsp"/>
        <%
            }
        %>

        
        
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
