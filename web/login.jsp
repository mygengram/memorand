<%@page import="com.memorand.helper.LoginHelper"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    
    <head>
        <jsp:include page="recursos/import.jsp"/>
        <link rel="shortcut icon" href="images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="bootstrap/style.css">
        <title>Memorand - Iniciar sesi&oacute;n</title>
    </head>
    
    <body>
        <h1>Login</h1>
        
        <%
            String accion = null;
            LoginHelper loginHelper = null;
            
            accion = request.getParameter("accion");
            if(accion != null && "login".equals(accion))
            {
                loginHelper = new LoginHelper();
                if(!loginHelper.login(request,response))
                {
        %>
                    <script>
                        <!--
                            alert( 'Error' );
                        -->
                    </script>
        <%
                }
            }
            
        %>
        
        <form id="form1" method="GET">
            <table>
                <tr>
                    <td>Usuario</td>
                    <td><input type="text" id="user" name="user"/></td>
                </tr>
                <tr>
                    <td>Contrase&ntilde;a</td>
                    <td><input type="password" id="pass" name="pass"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" id="accion" name="accion" value="login">
                    </td>
                </tr>
            </table>
        </form>
    </body>
    
</html>
