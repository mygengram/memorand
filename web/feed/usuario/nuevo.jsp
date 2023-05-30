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
        <!-- Botón regresar -->
        <div class="text-start">
            <a href="index.jsp"><button class="btn btn-light btn-custom border-success rounded-circle shadow mt-3 mx-3"><i class="bi bi-arrow-return-left"></i></button></a>
        </div>
        <div class="container mt-5 my-5">
            <div class="row justify-content-center">
                <div class="col-sm-10 col-md-11 col-lg-8 col-xl-9 col-xxl-8"> 
                    <div class="card rounded-end p-3 shadow-lg" >
                        <div class="fw-bold text-center py-5 fs-4 text-secondary mt-0">Nuevo pendiente personal</div>
                    
                        <div class="card-body">
                            <form class="row g-3" id="form4" method="POST" action="nuevo.jsp">
                                <div class="col-md-6">
                                    <label for="titulo" class="form-label">T&iacute;tulo</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="titulo">
                                </div>
                                <div class="col-md-6">
                                    <label for="subtitulo" class="form-label">Subt&iacute;tulo</label>
                                     <input type="text" class="form-control rounded-5 border-success" id="subtitulo">
                                </div>
                                <div class="col-12">
                                    <label for="descrip" class="form-label">Descripci&oacute;n</label>
                                    <textarea class="form-control rounded-5 border-success" id="descrip" rows="4"></textarea>
                                </div>
                                <div class="col-md-6">
                                    <label for="fecha" class="form-label">Fecha limite</label>
                                    <input type="date" class="form-control rounded-5 border-success" id="fecha" name="fecha" placeholder="dd/mm/aaaa" data-bs-toggle="tooltip" data-bs-placement="left" title="Selecciona una fecha">
                                </div>
                                <div class="col-md-6">
                                    <div class="mb-3">
                                        <label for="etiqueta_opc" class="form-label">Etiquetas</label>
                                        <select id="etiqueta-opc" class="form-select rounded-5 border-success">
                                        <option selected>...</option>
                                        <option>Ninguna</option>
                                        <option>EJEMPLO</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <button type="submit" class="btn btn-light btn-custom rounded-4">Guardar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
