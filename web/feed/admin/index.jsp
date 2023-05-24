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
        <form>
            <input type="submit" id="accion" name="accion" value="Salir"/>
        </form>
    </body>
</html>
