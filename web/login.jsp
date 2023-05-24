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
                            alert('La contraseña o el usuario son incorrectos.');
                        -->
                    </script>
        <%
                }
            }
            
        %>
        
        <div class="container-fluid">
            <h1 class="bg-body-tertiary text-center text-secondary" style="padding: 2%">Login</h1>
            <div class="container text-center">
              <div class="row row-cols-3">
                <div class="col-4"></div>
                <div class="col-6" style="padding: 2%">
                    <form id="form1" method="POST">
                        <table>
                            <tr>
                                <td>Usuario</td>
                                <td><input type="text" id="user" name="user" style="padding: 2%"/></td>
                            </tr>
                            <tr>
                                <td>Contrase&ntilde;a</td>
                                <td><input type="password" id="pass" name="pass" style="padding: 2%"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" id="accion" name="accion" value="login" style="padding: 2%">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div class="col-4"></div>
              </div>
            </div>
        </div>
        
    </body>
    
</html>
