<%@page import="com.memorand.dao.service.UsuariosService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../recursos/import.jsp"/>
        <link rel="shortcut icon" href="../../images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="../../bootstrap/style.css">
        <title>Memorand - Nuevo Pendiente</title>
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
                String usuario = request.getParameter("user");
                UsuariosService usuariosService = new UsuariosService();
        %>
        <!-- Botón regresar -->
        <div class="text-start">
            <a href="index.jsp?user=<%=usuariosService.getUsuarioByUsuario(usuario).getUsuario()%>"><button class="btn btn-light btn-custom border-success rounded-circle shadow mt-3 mx-3"><i class="bi bi-arrow-return-left"></i></button></a>
        </div>
        <div class="container mt-5 my-5">
            <div class="row justify-content-center">
                <div class="col-sm-10 col-md-11 col-lg-8 col-xl-9 col-xxl-8"> 
                    <div class="card rounded-end p-3 shadow-lg" >
                        <div class="fw-bold text-center py-5 fs-4 text-secondary mt-0">Crear agenda comunitaria</div>
                    
                        <div class="card-body">
                            <form class="row g-3" id="form6" method="POST" action="crear.jsp">
                                <div class="col-md-6">
                                    <label for="titulo" class="form-label">Nombre de la agenda</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="nomagenda">
                                </div>
                                <div class="col-md-6">
                                    <div class="mb-3">
                                        <label for="etiqueta_opc" class="form-label">A&ntilde;adir a favoritos</label>
                                        <select id="etiqueta-opc" class="form-select rounded-5 border-success">
                                        <option selected>...</option>
                                        <option>Si</option>
                                        <option>No</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <label for="descrip" class="form-label">Descripci&oacute;n</label>
                                    <textarea class="form-control rounded-5 border-success" id="descagenda" rows="4"></textarea>
                                </div>
                                
                                <div class="col-12">
                                    <button type="submit" class="btn btn-light btn-custom rounded-4">Crear</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
