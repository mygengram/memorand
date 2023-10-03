<%@page import="com.memorand.helper.UsuariosPendientesHelper"%>
<%@page import="com.memorand.helper.Helpers"%>
<%@page import="com.memorand.helper.PendientesPHelper"%>
<%@page import="com.memorand.dao.service.PendientesPService"%>
<%@page import="com.memorand.dao.service.UsuariosService"%>
<%@page import="com.memorand.helper.LoginHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  
    String usuario = request.getParameter("user");
    String idpp = request.getParameter("idpp");
    UsuariosService usuariosService = new UsuariosService();
    PendientesPService pendientesPService = new PendientesPService();
    Helpers pendientePHelper = null;
    Helpers usuarioPendientePHelper = null;
    boolean flag1 = false;
%>
<html>
    <head>
        <jsp:include page="../../../recursos/import.jsp"/>
        <link rel="shortcut icon" href="../../../images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="../../../bootstrap/style.css">
        <title><%=pendientesPService.getPendientesPByPendientesP(idpp).getNomPendP()%></title>
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
        <div class="container-fluid">
          <div class="row">
            <div class="col-1"></div>

        <%
            String accion = request.getParameter("a");
            
            if(accion != null && "v".equals(accion)) {
        %>
            <!-- Botón regresar -->
            <div class="text-start" style="margin-left:12%">
                <a href="index.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>"><button class="btn btn-light btn-custom border-success rounded-circle shadow mt-3 mx-3"><i class="bi bi-arrow-return-left"></i></button></a>
            </div>
            <!-- Ver pendiente personal -->
            <div class="container mt-5 my-5">
                <div class="row justify-content-center">
                    <div class="col-sm-10 col-md-11 col-lg-8 col-xl-9 col-xxl-8"> 
                        <div class="card rounded-end p-3 shadow-lg" >
                            <div class="fw-bold text-center py-5 fs-4 text-secondary mt-0"><%=pendientesPService.getPendientesPByPendientesP(idpp).getNomPendP()%></div>
                            <div class="card-body">
                                <!-- Form -->
                                <form id="form4" method="POST" action="p.jsp" class="row g-3"  onsubmit="return validateForm()">
                                    <input type="hidden" id="user" name="user" value="<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>"/>
                                    <input type="hidden" id="idpp "name="idpp" value="<%=idpp%>"/>
                                    <div class="col-md-6">
                                        <label for="nmpp" class="form-label">T&iacute;tulo</label>
                                        <input type="text" class="form-control rounded-5 border-success" id="nmpp" name="nmpp" value="<%=pendientesPService.getPendientesPByPendientesP(idpp).getNomPendP()%>" disabled="true">
                                        <span id="nmppError" style="color:#dc3545"></span>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="sbpp" class="form-label">Subt&iacute;tulo</label>
                                        <input type="text" class="form-control rounded-5 border-success" id="sbpp" name="sbpp" value="<%=pendientesPService.getPendientesPByPendientesP(idpp).getSubPendP()%>" disabled="true">
                                        <span id="sbppError" style="color:#dc3545"></span>
                                    </div>
                                    <div class="col-12">
                                        <label for="dspp" class="form-label">Descripci&oacute;n</label>
                                        <textarea class="form-control rounded-4 border-success" id="dspp" name="dspp" rows="4" disabled="true"><%=pendientesPService.getPendientesPByPendientesP(idpp).getDescPendP()%></textarea>
                                        <span id="dsppError" style="color:#dc3545"></span>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="ffpp" class="form-label">Fecha limite</label>
                                        <input type="date" class="form-control rounded-5 border-success" id="ffpp" name="ffpp" value="<%=pendientesPService.getPendientesPByPendientesP(idpp).getFechaFinalP()%>" disabled="true">
                                        <span id="ffppError" style="color:#dc3545"></span>
                                    </div>
                                    <div class="col-1"></div>

                                    <div class="col-10">
                                        <button type="submit" class="btn btn-light btn-custom rounded-5" id="a" name="a" value="epp">Editar</button>
                                    </div>
                                    <div class="col-2">
                                        <button type="submit" class="btn btn-danger rounded-5" id="a" name="a" value="bpp">Borrar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <%
            }
            if(accion != null && "epp".equals(accion)) {
        %>
            <!-- Editar pendiente personal -->
            <div class="container mt-5 my-5">
                <div class="row justify-content-center">
                    <div class="col-sm-10 col-md-11 col-lg-8 col-xl-9 col-xxl-8"> 
                        <div class="card rounded-end p-3 shadow-lg" >
                            <div class="fw-bold text-center py-5 fs-4 text-secondary mt-0"><%=pendientesPService.getPendientesPByPendientesP(idpp).getNomPendP()%></div>
                            <div class="card-body">
                                <!-- Form -->
                                <form id="form4" method="POST" action="p.jsp" class="row g-3"  onsubmit="return validateForm()">
                                    <input type="hidden" id="user" name="user" value="<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>"/>
                                    <input type="hidden" id="idpp "name="idpp" value="<%=idpp%>"/>
                                    <div class="col-md-6">
                                        <label for="nmpp" class="form-label">T&iacute;tulo</label>
                                        <input type="text" class="form-control rounded-5 border-success" id="nmpp" name="nmpp" value="<%=pendientesPService.getPendientesPByPendientesP(idpp).getNomPendP()%>">
                                        <span id="nmppError" style="color:#dc3545"></span>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="sbpp" class="form-label">Subt&iacute;tulo</label>
                                        <input type="text" class="form-control rounded-5 border-success" id="sbpp" name="sbpp" value="<%=pendientesPService.getPendientesPByPendientesP(idpp).getSubPendP()%>">
                                        <span id="sbppError" style="color:#dc3545"></span>
                                    </div>
                                    <div class="col-12">
                                        <label for="dspp" class="form-label">Descripci&oacute;n</label>
                                        <textarea class="form-control rounded-4 border-success" id="dspp" name="dspp" rows="4"><%=pendientesPService.getPendientesPByPendientesP(idpp).getDescPendP()%></textarea>
                                        <span id="dsppError" style="color:#dc3545"></span>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="ffpp" class="form-label">Fecha limite</label>
                                        <input type="date" class="form-control rounded-5 border-success" id="ffpp" name="ffpp" value="<%=pendientesPService.getPendientesPByPendientesP(idpp).getFechaFinalP()%>">
                                        <span id="ffppError" style="color:#dc3545"></span>
                                    </div>
                                    <div class="col-1"></div>
                                    <div class="col-md-3">
                                        <label for="ffpp" class="form-label">Completado</label>
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" value="si" name="cmpp" id="cmpp1">
                                          <label class="form-check-label" for="cmpp1">
                                            Completado
                                          </label>
                                        </div>
                                        <div class="form-check">
                                          <input class="form-check-input" type="radio" value="no" name="cmpp" id="cmpp2" checked>
                                          <label class="form-check-label" for="cmpp2">
                                            Sin completar
                                          </label>
                                        </div>
                                        <span id="cmppError" style="color:#dc3545"></span>
                                    </div>
                                    <div class="col-10">
                                        <button type="submit" class="btn btn-light btn-custom rounded-5" id="a" name="a" value="gpp">Guardar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <%
            }
            if(accion != null && "gpp".equals(accion)) {
                pendientePHelper = new PendientesPHelper().addRequest(request);
                flag1 = pendientePHelper.updateT();
                if(flag1){
                    String redireccionar1 = "p.jsp?user="+usuario+"&idpp="+idpp+"&a=v";
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", redireccionar1); 
                }
            }
            if(accion != null && "bpp".equals(accion)) {
                usuarioPendientePHelper = new UsuariosPendientesHelper().addRequest(request);
                flag1 = usuarioPendientePHelper.deleteT();
                if(flag1){
                    pendientePHelper = new PendientesPHelper().addRequest(request);
                    pendientePHelper.deleteT();
                    String redireccionar2 = "index.jsp?user="+usuario;
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", redireccionar2); 
                }
            }
        %>
            
            <div class="col-1"></div>
          </div>
        </div>
    </body>
</html>
