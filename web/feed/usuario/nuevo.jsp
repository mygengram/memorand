<%@page import="com.memorand.dao.service.UsuariosService"%>
<%@page import="com.memorand.dao.service.PendientesPService"%>
<%@page import="com.memorand.helper.Helpers"%>
<%@page import="com.memorand.helper.PendientesPHelper"%>
<%@page import="com.memorand.helper.UsuariosPendientesHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../recursos/import.jsp"/>
        <link rel="shortcut icon" href="../../images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="../../bootstrap/style.css">
        <title>Memorand - Nuevo Pendiente</title>
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
    
    <body>
        <%
            UsuariosService usuariosService = new UsuariosService();
            PendientesPService pendientespService = new PendientesPService();
            
            String accion = request.getParameter("a");;
            String usuario = request.getParameter("user");
            String idpp = request.getParameter("idpp");
            
            Helpers pendientePHelper = null;
            Helpers usuarioPendientePHelper = null;
            boolean flag1 = false;

            if(accion != null && "n".equals(accion))
            {
        %>
        <!-- Botón regresar -->
        <div class="text-start">
            <a href="index.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>"><button class="btn btn-light btn-custom border-success rounded-circle shadow mt-3 mx-3"><i class="bi bi-arrow-return-left"></i></button></a>
        </div>
        <!-- Nuevo pendiente personal -->
        <div class="container mt-5 my-5">
            <div class="row justify-content-center">
                <div class="col-sm-10 col-md-11 col-lg-8 col-xl-9 col-xxl-8"> 
                    <div class="card rounded-end p-3 shadow-lg" >
                        <div class="fw-bold text-center py-5 fs-4 text-secondary mt-0">Nuevo pendiente personal</div>
                        <div class="card-body">
                            
                            <!-- Form nuevo pp-->
                            <form id="form4" method="GET" action="nuevo.jsp" class="row g-3"  onsubmit="return validateForm()">
                                <input type="hidden" id="user" name="user" value="<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>"/>
                                <input type="hidden" id="idpp "name="idpp" value="<%=idpp%>"/>
                                <div class="col-md-6">
                                    <label for="nmpp" class="form-label">T&iacute;tulo</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="nmpp" name="nmpp">
                                    <span id="nmppError" style="color:#dc3545"></span>
                                </div>
                                <div class="col-md-6">
                                    <label for="sbpp" class="form-label">Subt&iacute;tulo</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="sbpp" name="sbpp">
                                    <span id="sbppError" style="color:#dc3545"></span>
                                </div>
                                <div class="col-12">
                                    <label for="dspp" class="form-label">Descripci&oacute;n</label>
                                    <textarea class="form-control rounded-4 border-success" id="dspp" name="dspp" rows="4" placeholder="Describe tu tarea"></textarea>
                                    <span id="dsppError" style="color:#dc3545"></span>
                                </div>
                                <div class="col-md-6">
                                    <label for="ffpp" class="form-label">Fecha limite</label>
                                    <input type="date" class="form-control rounded-5 border-success" id="ffpp" name="ffpp">
                                    <span id="ffppError" style="color:#dc3545"></span>
                                </div>
                                <input type="hidden" id="cmpp" name="cmpp" value="no"/>
                                <div class="col-12">
                                    <button type="submit" class="btn btn-light btn-custom rounded-5" id="a" name="a" value="npp">Guardar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
            pendientePHelper = new PendientesPHelper().addRequest(request);
            if(accion != null && "npp".equals(accion)) {
                flag1 = pendientePHelper.addT();
            }
            if(flag1) {
                usuarioPendientePHelper = new UsuariosPendientesHelper().addRequest(request);
                usuarioPendientePHelper.addT();
                String redireccionar = "personal/index.jsp?user="+usuariosService.getUsuarioByUsuario(usuario).getUsuario();
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", redireccionar); 
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
