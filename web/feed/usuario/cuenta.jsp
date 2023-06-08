<%@page import="com.memorand.helper.UsuariosHelper"%>
<%@page import="com.memorand.helper.Helpers"%>
<%@page import="com.memorand.dao.service.UsuariosService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../recursos/import.jsp"/>
        <link rel="shortcut icon" href="../../images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="../../bootstrap/style.css">
        <title>Mi Cuenta</title>
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
        
    </style>

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
    <body>
        <%  
            String usuario = request.getParameter("user");
            String accion = request.getParameter("a");
            UsuariosService usuariosService = new UsuariosService();
            Helpers usuarioHelper = null;
            boolean flag1;
            
            accion = request.getParameter("a");
            if(accion != null && "v".equals(accion)) {
        %>
        <!-- Botón regresar -->
        <div class="text-start">
            <a href="index.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>"><button class="btn btn-light btn-custom border-success rounded-circle shadow mt-3 mx-3"><i class="bi bi-arrow-return-left"></i></button></a>
        </div>
        <section class="container w-75 mt-5 rounded shadow-lg">
            <div class="row align-items-lg-stretch">
                <div class="col-3 rounded-3 p-4" style="background-color: #18988B;">
                    <div class="container">
                        <div class="row">
                            <i class="bi bi-person-circle text-center" style="color: white; font-size:45pt;"></i></h1>
                            <h5 class="text-center text-white"><%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%></h5>
                            <h6 class="text-center text-white"></h6>
                        </div>
                    </div>
                    <br><br><br><br><br><br><br><br><br><br>
                </div>
                <!-- Col Login -->
                <div class="col-9 rounded-end-3" >
                    <div class="fw-bold text-center py-5 fs-4" style="color: #d3d4d5">Mi informaci&oacute;n personal</div>
                    <!-- Form -->
                    <form id="formC" method="GET" onsubmit="return validateForm()" action="cuenta.jsp">
                        <input type="hidden" id="user" name="user" value="<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>"/>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="mb-3">
                                    <label for="user" class="form-label">Nombre de usuario</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="user" name="user" disabled="true" value="<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>"/>
                                    <span id="userError" style="color:#dc3545"></span>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="mb-3">
                                    <label for="pass" class="form-label">Contrase&ntilde;a</label>
                                    <input type="password" class="form-control rounded-5 border-success" id="pass" name="pass" placeholder="Contrase&ntilde;a" disabled="true" value="<%=usuariosService.getUsuarioByUsuario(usuario).getContrasena()%>"/>
                                    <span id="passError" style="color:#dc3545"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="mb-3">
                                    <label for="name" class="form-label">Nombre</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="name" name="name" disabled="true" value="<%=usuariosService.getUsuarioByUsuario(usuario).getNomUsuario()%>"/>
                                    <span id="nameError" style="color:#dc3545"></span>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="mb-3">
                                    <label for="ap" class="form-label">Apellido paterno</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="ap" name="ap" disabled="true" value="<%=usuariosService.getUsuarioByUsuario(usuario).getApellidoPat()%>"/>
                                    <span id="apError" style="color:#dc3545"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <div class="mb-3">
                                    <label for="am" class="form-label">Apellido materno</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="am" name="am" disabled="true" value="<%=usuariosService.getUsuarioByUsuario(usuario).getApellidoMat()%>"/>
                                    <span id="amError" style="color:#dc3545"></span>
                                </div>
                            </div>
                            <div class="col">
                                <div class="mb-3">
                                    <label for="fn" class="form-label">Fecha de nacimiento</label>
                                    <input type="date" class="form-control rounded-5  border-success" id="fn" name="fn" disabled="true" value="<%=usuariosService.getUsuarioByUsuario(usuario).getFechaNac()%>"/>
                                    <span id="fnError" style="color:#dc3545"></span>
                                </div>
                            </div>
                        </div>
                        <div class="btn-group" role="group">
                            <button type="submit" class="btn btn-light btn-custom rounded-5" id="a" name="a" value="eu">Editar</button>
                        </div>
                    </form>
                    <br>
                </div>
            </div>
        </section>
        <%  
            }
            if(accion != null && "eu".equals(accion)) {
        %>
        <section class="container w-75 mt-5 rounded shadow-lg">
            <div class="row align-items-lg-stretch">
                <div class="col-3 rounded-3 p-4" style="background-color: #18988B;">
                    <div class="container">
                        <div class="row">
                            <i class="bi bi-person-circle text-center" style="color: white; font-size:45pt;"></i></h1>
                            <h5 class="text-center text-white"><%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%></h5>
                            <h6 class="text-center text-white"></h6>
                        </div>
                    </div>
                    <br><br><br><br><br><br><br><br><br><br>
                </div>
                <!-- Col Login -->
                <div class="col-9 rounded-end-3" >
                    <div class="fw-bold text-center py-5 fs-4" style="color: #d3d4d5">Mi informaci&oacute;n personal</div>
                    <!-- Form -->
                    <form id="formC" method="GET" onsubmit="return validateForm()" action="cuenta.jsp">
                        <input type="hidden" id="user" name="user" value="<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>"/>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="mb-3">
                                    <label for="user" class="form-label">Usuario (no editable)</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="user" name="user" value="<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>" disabled="true"/>
                                    <span id="userError" style="color:#dc3545"></span>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="mb-3">
                                    <label for="pass" class="form-label">Contrase&ntilde;a</label>
                                    <input type="password" class="form-control rounded-5 border-success" id="pass" name="pass" placeholder="Contrase&ntilde;a" value="<%=usuariosService.getUsuarioByUsuario(usuario).getContrasena()%>"/>
                                    <span id="passError" style="color:#dc3545"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="mb-3">
                                    <label for="name" class="form-label">Nombre</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="name" name="name" value="<%=usuariosService.getUsuarioByUsuario(usuario).getNomUsuario()%>"/>
                                    <span id="nameError" style="color:#dc3545"></span>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="mb-3">
                                    <label for="ap" class="form-label">Apellido paterno</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="ap" name="ap" value="<%=usuariosService.getUsuarioByUsuario(usuario).getApellidoPat()%>"/>
                                    <span id="apError" style="color:#dc3545"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <div class="mb-3">
                                    <label for="am" class="form-label">Apellido materno</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="am" name="am" value="<%=usuariosService.getUsuarioByUsuario(usuario).getApellidoMat()%>"/>
                                    <span id="amError" style="color:#dc3545"></span>
                                </div>
                            </div>
                            <div class="col">
                                <div class="mb-3">
                                    <label for="fn" class="form-label">Fecha de nacimiento</label>
                                    <input type="date" class="form-control rounded-5  border-success" id="fn" name="fn" value="<%=usuariosService.getUsuarioByUsuario(usuario).getFechaNac()%>"/>
                                    <span id="fnError" style="color:#dc3545"></span>
                                </div>
                            </div>
                        </div>
                        <div class="btn-group" role="group">
                            <button type="submit" class="btn btn-light btn-custom rounded-5" id="a" name="a" value="gu">Guardar</button>
                        </div>
                    </form>
                    <br>
                </div>
            </div>
        </section>
        <%  
            }
            if(accion != null && "gu".equals(accion)) {
                usuarioHelper = new UsuariosHelper().addRequest(request);
                flag1 = usuarioHelper.updateT();
                if(flag1) {
                    String redireccionar1 = "cuenta.jsp?user="+usuario+"&a=v";
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", redireccionar1); 
                }
            }
        %>
    </body>
</html>

