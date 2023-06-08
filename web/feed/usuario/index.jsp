<%@page import="com.memorand.helper.PendientesPHelper"%>
<%@page import="com.memorand.helper.Helpers"%>
<%@page import="com.memorand.dao.PendientesP"%>
<%@page import="com.memorand.dao.UsuariosPendientes"%>
<%@page import="java.util.List"%>
<%@page import="com.memorand.dao.service.UsuariosPendientesService"%>
<%@page import="com.memorand.dao.service.UsuariosService"%>
<%@page import="com.memorand.helper.LoginHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../recursos/import.jsp"/>
        <link rel="shortcut icon" href="../../images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="../../bootstrap/style.css">
        <title>Memorand - Inicio</title>
    </head>
    <body>
        <%  
            String usuario = request.getParameter("user");
            UsuariosService usuariosService = new UsuariosService();

            Helpers pendienteHelper = new PendientesPHelper().addRequest(request);
            Helpers agendaHelper = new AgendaHelper().addRequest(request);
            
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
                <a class="navbar-brand" href="index.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>">
                    <img src="../../images/logotypes/me-logoEX.png" alt="Logo de la empresa" width="200" style="margin-left:40%">
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
                                <a class="dropdown-item" href="cuenta.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>&a=v">Mi cuenta</a>
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
                <a href="index.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>" class="nav-link" aria-current="page">
                  <i class="bi bi-house-door-fill" style="font-size:14pt">    Inicio</i>
                </a>
              </li>
              <hr style="opacity: 100; height: 2px;">
              <li>
                <a href="personal/index.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>" class="nav-link">
                  <i class="bi bi-person-fill" style="font-size:14pt">    Mi agenda</i>
                </a>
              </li>
              <li>
                <a href="comunitarias/index.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>" class="nav-link">
                  <i class="bi bi-people-fill" style="font-size:14pt">    Agendas comunitarias</i>
                </a>
              </li>
            </ul>
          </div>
        </div>
        <br><br>
        
        <div class="container-fluid">
          <div class="row">
            <div class="col-1"></div>
            
            <%-- MAIN --%>
            <div class="col-9">
                <h1 class="text-secondary">Bienvenido <%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%></h1>
                <h2 class="text-secondary">¿Qué deseas hacer hoy?</h2>
                <br> <hr> <br> 
                <div class="container">
                    <div class="row">
                        <div class="col-4">
                            <div class="card text-center mb-3 bg-body-secondary">
                              <div class="card-body">
                                <h1 class="card-title text-secondary"><i class="bi bi-plus-circle-fill"></i></h1>
                                <a href="nuevo.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>&idpp=<%=pendienteHelper.codigoAleatorio12()%>&cmpp=no&a=n" class="btn btn-primary text-white">Nuevo pendiente personal</a>
                              </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="card text-center mb-3 bg-body-secondary">
                              <div class="card-body">
                                <h1 class="card-title text-secondary"><i class="bi bi-calendar-plus-fill"></i></h1>
                                <a href="crear.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>&ida=<%=agendaHelper.codigoAleatorio12()%>" class="btn btn-primary text-white">Crear una agenda</a>
                              </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="card text-center mb-3 bg-body-secondary">
                              <div class="card-body">
                                  <h1 class="card-title text-secondary"><i class="bi bi-person-fill-add"></i></h1>
                                <a href="unirse.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>" class="btn btn-primary text-white">Unirse a una agenda</a>
                              </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr> <br>
                
                <%-- TABLA DE PENDIENTES --%>
                <h2 class="text-secondary">Mis pendientes personales</h2>
                
                <%  
                UsuariosPendientesService usuariosPendientesService = new UsuariosPendientesService();
                List<PendientesP> lista = usuariosPendientesService.getPendientesListByUsuario(usuario);
                
                if(!(lista.size() <= 0))
                {
                %>
                <br>
                <table class="table table-borderless" style="width:100%">
                  <thead>
                    <tr>
                      <th scope="col" class="col-3"><b>Nombre</b></th>
                      <th scope="col" class="col-2"><b>Completado</b></th>
                      <th scope="col" class="col-4"></th>
                      <th scope="col" class="col-2"><b>Vencimiento</b></th>
                      <th scope="col" class="col-2"></th>
                    </tr>
                  </thead>
                  <tbody>
                <%  
                    for (int i = 0; i < lista.size(); i++) {
                %>
                    <tr>
                      <td class="text-secondary"><%= lista.get(i).getNomPendP()%></td>
                      <td class="text-tertiary"><%= lista.get(i).getCompletadoP()%></td>
                      <td class="text-tertiary"><%= lista.get(i).getSubPendP()%></td>
                      <td class="text-secondary"><%= lista.get(i).getFechaFinalP()%></td>
                      <td>
                          <a href="personal/p.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>&idpp=<%=lista.get(i).getIdPendP()%>&a=v">
                              <button type="button" class="btn btn-primary text-white">Ver</button>
                          </a>
                      </td>
                    </tr>
                <%  
                    }
                %>
                  </tbody>
                </table>
                <%  
                }
                else
                {
                %>
                <br>
                <h4 class="text-tertiary text-center">Sin pendientes</h4>
                <%  
                }
                %>
                <br> <hr> <br><br><br>
                
                <%-- TABLA DE AGENDAS --%>
                <h2 class="text-secondary">Mis agendas</h2>
                <%  
                if(false)
                {
                %>
                <br>
                <table class="table table-borderless" style="width:100%">
                  <thead>
                    <tr>
                      <th scope="col" class="col-3"><b>Nombre</b></th>
                      <th scope="col" class="col-2"><b>Completado</b></th>
                      <th scope="col" class="col-4"></th>
                      <th scope="col" class="col-2"><b>Vencimiento</b></th>
                      <th scope="col" class="col-2"></th>
                    </tr>
                  </thead>
                  <tbody>
                <%  
                    for (int i = 0; i < lista.size(); i++) {
                %>
                    <tr>
                      <td class="text-secondary"><%= lista.get(i).getNomPendP()%></td>
                      <td class="text-tertiary"><%= lista.get(i).getCompletadoP()%></td>
                      <td class="text-tertiary"><%= lista.get(i).getSubPendP()%></td>
                      <td class="text-secondary"><%= lista.get(i).getFechaFinalP()%></td>
                      <td>
                          <a href="personal/p.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>&idpp=<%=lista.get(i).getIdPendP()%>&a=v">
                              <button type="button" class="btn btn-primary text-white">Ver</button>
                          </a>
                      </td>
                    </tr>
                <%  
                    }
                %>
                  </tbody>
                </table>
                <%  
                }
                else
                {
                %>
                <br>
                <h4 class="text-tertiary text-center">Sin agendas</h4>
                <%  
                }
                %>
                <br> <hr> <br><br><br>
            </div>
            
            <div class="col-1"></div>
          </div>
        </div>
        
    </body>
</html>
