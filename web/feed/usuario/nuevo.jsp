<%@page import="com.memorand.dao.service.PendientesPService"%>
<%@page import="com.memorand.helper.UsuariosPendientesHelper"%>
<%@page import="com.memorand.helper.PendientesPHelper"%>
<%@page import="com.memorand.helper.Helpers"%>
<%@page import="com.memorand.dao.service.UsuariosService"%>
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
                            <form class="row g-3" id="form4" method="POST" action="nuevo.jsp">
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
                                    <textarea class="form-control rounded-4 border-success" id="dspp" name="dspp" rows="4"></textarea>
                                    <span id="dsppError" style="color:#dc3545"></span>
                                </div>
                                <div class="col-md-6">
                                    <label for="ffpp" class="form-label">Fecha limite</label>
                                    <input type="date" class="form-control rounded-5 border-success" id="ffpp" name="ffpp" placeholder="dd/mm/aaaa" data-bs-toggle="tooltip" data-bs-placement="left">
                                    <span id="ffppError" style="color:#dc3545"></span>
                                </div>
                                <div class="col-12">
                                    <button type="submit" class="btn btn-light btn-custom rounded-4" id="a" name="a" value="npp">Guardar</button>
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
        %>
            <jsp:forward page="personal/p.jsp">
                <jsp:param name="user" value="<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>"/>
                <jsp:param name="idpp" value="<%= pendientespService.getPendientesPByPendientesP(idpp).getIdPendP()%>"/>
            </jsp:forward>
        <%
            }
        %>
    </body>
</html>
