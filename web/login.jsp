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
            
        %>
        
        <form id="login">
            <table>
                <tr>
                    <td>Usuario</td>
                    <td><input type="text" id="usuario" name="usuario"/></td>
                </tr>
                <tr>
                    <td>Contrase&ntilde;a</td>
                    <td><input type="password" id="contrasena" name="contrasena"/></td>
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
