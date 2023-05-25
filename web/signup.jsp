<%-- 
    Document   : signup
    Created on : 12 may 2023, 06:55:52
    Author     : alumno
--%>

<%@page import="java.util.Calendar"%>
<%@page import="com.memorand.helper.UsuariosHelper"%>
<%@page import="com.memorand.dao.Usuarios"%>
<%@page import="com.memorand.helper.Helpers"%>
<%@page import="com.memorand.helper.LoginHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="recursos/import.jsp"/>
        <link rel="shortcut icon" href="images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="bootstrap/style.css">
        <title>Memorand - Registrarse</title>
        
    </head>
    <body>
        <%
            String accion = null;
            UsuariosHelper helper = null;
            boolean flag = false;
            
            accion = request.getParameter("accion");
            if(accion != null && "registra".equals(accion))
            {
                helper = new UsuariosHelper();
                flag = helper.addT();
                
                if(flag)
                {
        %>
        <a href="login.jsp">
            <button class="btn btn-primary fs-6 text-white" type="button" style="padding:2%;">Iniciar sesion</button>
        </a>    
        <%
                }
            }
        %>
        
        <h1>Registrarse</h1>
        
        <form id="form2" method="GET" action="signup.jsp" onsubmit="return validateForm()">
            <table>
                <tr>
                    <td>Nombre de usuario</td>
                    <td>
                        <input type="text" id="user" name="user"/>
                        <span id="userError" style="color:red"></span>
                    </td>
                </tr>
                <tr>
                    <td>Contrase&ntilde;a</td>
                    <td>
                        <input type="password" id="pass" name="pass"/>
                        <span id="passError" style="color:red"></span>
                    </td>
                </tr>
                <tr>
                    <td>Nombre real</td>
                    <td>
                        <input type="text" id="name" name="name"/>
                        <span id="nameError" style="color:red"></span>
                    </td>
                </tr>
                <tr>
                    <td>Apellido paterno</td>
                    <td>
                        <input type="text" id="ap" name="ap"/>
                        <span id="apError" style="color:red"></span>
                    </td>
                </tr>
                <tr>
                    <td>Apellido materno</td>
                    <td>
                        <input type="text" id="am" name="am"/>
                        <span id="amError" style="color:red"></span>
                    </td>
                </tr>
                <tr>
                    <td>Fecha de nacimiento</td>
                    <td>
                        <input type="text" id="fn" name="fn"/>
                        <span id="fnError" style="color:red"></span>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" id="accion" name="accion" value="registra">
                    </td>
                </tr>
            </table>
        </form>

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
