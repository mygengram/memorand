
<%@page import="com.memorand.helper.LoginHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="recursos/import.jsp"/>
        <link rel="shortcut icon" href="images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="bootstrap/style.css">
        <title>Memorand - Iniciar sesi&oacute;n</title>
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
        
        .bg{
            background-image: url(images/extras/logc.jpg);
            background-position: center center;
           
        }
   
        .custom-alert {
          background-color: #f8d7da;
          color: #721c24;
          border: 1px solid #f5c6cb;
          padding: 5px;
          border-radius: 5px;
        }
        .custom-alert .close-btn {
          float: right;
          cursor: pointer;
        }
    </style>

    <script>
        function showCustomAlert() {
          var alertContainer = document.createElement('div');
          alertContainer.classList.add('custom-alert');

          var icon = document.createElement('span');
          icon.classList.add('bi', 'bi-exclamation-diamond', 'me-2');
          alertContainer.appendChild(icon);

          var message = document.createTextNode('¡La contraseña o el usuario son incorrectos!');
          alertContainer.appendChild(message);

          var closeBtn = document.createElement('span');
          closeBtn.innerHTML = '&times;';
          closeBtn.classList.add('close-btn');
          closeBtn.onclick = function() {
            alertContainer.style.display = 'none';
          };
          alertContainer.appendChild(closeBtn);

          document.body.appendChild(alertContainer);
        }
    </script>
    
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
            showCustomAlert();
        </script>
        <%
                }
            }
            
        %>
        <!-- Botón regresar -->
        <div class="text-start">
            <a href="index.jsp"><button class="btn btn-light btn-custom border-success rounded-circle shadow mt-3 mx-3"><i class="bi bi-arrow-return-left"></i></button></a>
        </div>
        <!-- Login -->
        <section class="container w-75 mt-5 rounded shadow-lg">
            <div class="row align-items-lg-stretch">
                <!-- Img -->
                <div class="col bg rounded d-none d-lg-block col-md-5 col-lg-5 col-xl-6 p-5"></div>
                <!-- Col Login -->
                <div class="col rounded-end p-5">
                    <div class="text-end">
                        <img src="images/logotypes/me-logoP.png" width="48" alt="">
                    </div>
                    <div class="fw-bold text-center py-5 fs-4" style="color: #18988B">Iniciar sesi&oacute;n</div>
                    <!-- Form -->
                    <form id="form1" method="POST" action="login.jsp">
                        <div class="mb-4">
                          <label for="user" class="form-label">Nombre de usuario</label>
                          <input type="text" class="form-control rounded-5  border-success" id="user" name="user" placeholder="Usuario">
                        </div>
                        <div class="mb-4">
                          <label for="password" class="form-label">Contraseña</label>
                          <input type="password" class="form-control rounded-5  border-success" id="pass" name="pass"  placeholder="Contraseña">
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-light btn-custom rounded-5 "  id="accion" name="accion" value="login">Iniciar sesión</button>
                        </div>
                        <div class="my3 mt-2 text-center">
                            <span>¿No tienes una cuenta? <a href="signup.jsp" style="text-decoration: none;">Reg&iacute;strate</a></span><br>
                        </div>
                    </form>
                    <br>
                </div>
            </div>
        </section>
        
    </body>
</html>
