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
        <%
            String accion;
            LoginHelper loginHelper;
            
            accion = request.getParameter("accion");
            if(accion != null && "Salir".equals(accion)) {
                loginHelper = new LoginHelper();
                if(!loginHelper.logout(session)) {
        %>
                    <script>
                        <!--
                            alert('Error');
                        -->
                    </script>
        <%
                }
                else {
                    System.out.println(request.getContextPath()); 
                    response.sendRedirect(request.getContextPath());
                }
            }
        %>
        <%-- Navbar --%>
        <nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top" style="padding: 1%">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="../../../images/logotypes/me-logoEX.png" alt="Logo de la empresa" width="200" style="margin-left:40%">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation" style="margin-right:15%;">
                    <span class="navbar-toggler-icon"></span>
                </button>
            <div class="collapse navbar-collapse ms-auto" id="navbarNav" style="margin-right:15%;">
                <ul class="navbar-nav ms-auto">
                    <button type="button" class="btn" data-bs-toggle="offcanvas" data-bs-target="#offcanvas1" aria-expanded="false" aria-controls="contenido" onclick="toggleNav()">
                        <i class="bi bi-house-door-fill text-body-tertiary" style="font-size:20pt"></i>
                    </button>
                    <li class="nav-item dropstart ms-auto">
                        <a class="nav-link dropstart-toggle" href="#" id="usuario" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-person-fill text-body-tertiary" style="font-size:20pt"></i>
                        </a>
                        <ul class="dropdown-menu mt-5 " aria-labelledby="usuario">
                            <li>
                                <a class="dropdown-item" href="../cuenta.jsp">Mi cuenta</a>
                            </li>
                            <li><hr class="dropdown-divider"></li>
                            <li>
                                <form id="form3" method="GET" action="index.jsp">
                                    <input type="submit" id="accion" name="accion" value="Salir" class="btn btn-outline-secondary fs-8" style="margin-left: 8%; width: 80%"/>
                                </form>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            </div>
        </nav>

        <script>
            function toggleNav()
            {
                var nav = document.getElementById("contenido");
                if (nav.classList.contains("show")) {
                    nav.classList.remove("show");
                } else {
                    nav.classList.add("show");
                }
            }
        </script>

        <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvas1" aria-labelledby="offcanvas1Label" style="width: 320px">
          <div class="offcanvas-header">
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close" style="margin-top:8%" ></button>
          </div>
          <div class="offcanvas-body" style="margin-top: 2%">
            <ul class="nav nav-pills flex-column mb-auto">
              <li class="nav-item">
                <a href="../index.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>" class="nav-link" aria-current="page">
                  <i class="bi bi-house-door-fill" style="font-size:14pt">    Inicio</i>
                </a>
              </li>
              <hr style="opacity: 100; height: 2px;">
              <li>
                  <a href="index.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>" class="nav-link">
                  <i class="bi bi-person-fill" style="font-size:14pt">    Mi agenda</i>
                </a>
              </li>
              <li>
                  <a href="../comunitarias/index.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>" class="nav-link">
                  <i class="bi bi-people-fill" style="font-size:14pt">    Agendas comunitarias</i>
                </a>
              </li>
            </ul>
          </div>
        </div>
        <div class="container-fluid">
          <div class="row">
            <div class="col-1"></div>

            <!-- Nuevo pendiente personal -->
            <div class="container mt-5 my-5">
                <div class="row justify-content-center">
                    <div class="col-sm-10 col-md-11 col-lg-8 col-xl-9 col-xxl-8"> 
                        <div class="card rounded-end p-3 shadow-lg" >
                            <div class="fw-bold text-center py-5 fs-4 text-secondary mt-0"><%=pendientesPService.getPendientesPByPendientesP(idpp).getNomPendP()%></div>
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
                                        <button type="submit" class="btn btn-light btn-custom rounded-5" id="a" name="a" value="npp">Editar</button>
                                    </div>
                                    <div class="col-2">
                                        <button type="submit" class="btn btn-danger rounded-5" id="a" name="a" value="npp">Borrar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-1"></div>
          </div>
        </div>
    </body>
</html>
