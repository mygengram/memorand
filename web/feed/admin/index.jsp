<%-- 
    Document   : index
    Created on : 19 may 2023, 08:07:11
    Author     : alumno
--%>

<%@page import="com.memorand.helper.LoginHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../recursos/import.jsp"/>
        <link rel="shortcut icon" href="../../images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="../../bootstrap/style.css">
        <title>Memorand - Admin</title>
    </head>
    <body>
        <%-- Navbar --%>
        <nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top" style="padding: 1%">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">
                    <img src="../../images/logotypes/me-logoEX.png" alt="Logo de la empresa" width="200" style="margin-left:40%">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation" style="margin-right:15%;">
                    <span class="navbar-toggler-icon"></span>
                </button>
            <div class="collapse navbar-collapse ms-auto"" id="navbarNav" style="margin-right:15%;">
                <ul class="navbar-nav  ms-auto">
                    <button type="button" class="btn" data-bs-toggle="offcanvas" data-bs-target="#offcanvas1" aria-expanded="false" aria-controls="contenido" onclick="toggleNav()">
                        <i class="bi bi-house-door-fill text-body-tertiary" style="font-size:20pt"></i>
                    </button>
                    <li class="nav-item dropstart  ms-auto">
                        <a class="nav-link dropstart-toggle" href="#" id="usuario" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-person-fill text-body-tertiary" style="font-size:20pt"></i>
                        </a>
                        <ul class="dropdown-menu mt-5 " aria-labelledby="usuario">
                            <li>
                                <a class="dropdown-item" href="cuenta/index.jsp">Mi cuenta</a>
                            </li>
                            <li><hr class="dropdown-divider"></li>
                            <li>
                                <form>
                                    <input class="btn btn-outline-secondary me-1 fs-12" data-bs-toggle="modal" type="button" type="submit" id="accion" name="accion" value="Salir" style="margin-left: 8%"/>
                                </form>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            </div>
        </nav>

        <script>
            function toggleNav() {
                var nav = document.getElementById("contenido");
                if (nav.classList.contains("show")) {
                    nav.classList.remove("show");
                } else {
                    nav.classList.add("show");
                }
            }
        </script>

        <h1>Hello admin!</h1>
        
        <a href="index.jsp"> MEMORAND </a> <br>
        <a href="../usuario/index.jsp"> Ir a Memorand </a> <br>
        <a href="cuenta/index.jsp"> Mi cuenta </a> <br>
        <a href="ver.jsp"> Ver estadisticas</a> <br>
        
        <%
            String action = null;
            LoginHelper loginHelper = null;
            
            action = request.getParameter("accion");
            if(action != null && "Salir".equals(action))
            {
                loginHelper = new LoginHelper();
                if( !loginHelper.logout( session ))
                {
        %>
                    <script>
                        <!--
                            alert( 'Error' );
                        -->
                    </script>
        <%
                }
                else
                {
                    System.out.println( request.getContextPath() ); 
                    response.sendRedirect( request.getContextPath() );
                }
            }
            
        %>
    </body>
</html>
