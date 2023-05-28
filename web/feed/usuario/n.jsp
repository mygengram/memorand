
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../recursos/import.jsp"/>
        <link rel="shortcut icon" href="../../images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="../../bootstrap/style.css">
        <title>Memorand - Nuevo Pendiente</title>
        <jsp:include page="../../recursos/navbar.jsp"/>
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
    <body onclick="closeNav()">
        <div class="container mt-5 my-5">
            <div class="row justify-content-center">
                <div class="col-sm-10 col-md-11 col-lg-8 col-xl-9 col-xxl-8"> 
                    <div class="card rounded-end p-3 shadow-lg" >
                        <div class="text-end">
                            <img src="images/logotypes/me-logoP.png" width="48" alt="">
                        </div>
                        <div class="fw-bold text-center py-5 fs-4 text-secondary mt-0">Nuevo Pendiente</div>
                    
                        <div class="card-body">
                            <form class="row g-3 ">
                                <div class="col-md-5">
                                    <label for="titulo" class="form-label">T&iacute;tulo</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="titulo">
                                </div>

                                <div class="col-md-5">
                                    <label for="subtitulo" class="form-label">Subt&iacute;tulo</label>
                                     <input type="text" class="form-control rounded-5 border-success" id="subtitulo">
                                </div>
                                <div class="col-md-1 mt-4 mx-2 ">
                                    <div class="d-grid "><button type="button" class="btn btn-light btn-sm mt-3"><input type="color" class="form-control form-control-color rounded-5 border-success" id="ColorInput2" value="#77dbc3" title="Elige tu color"/></button></div>
                                </div>
                                <div class="col-12">
                                    <label for="descrip" class="form-label">Descripci&oacute;n</label>
                                    <textarea class="form-control rounded-5 border-success" id="descrip" rows="1"></textarea>
                                </div>
                                <div class="col-md-6">
                                    <label for="fecha" class="form-label">Fecha Inicio</label>
                                    <input type="date" class="form-control rounded-5 border-success" id="fecha" name="fecha" placeholder="dd/mm/aaaa" data-bs-toggle="tooltip" data-bs-placement="left" title="Selecciona una fecha">
                                </div>
                                <div class="col-md-6">
                                    <label for="fecha" class="form-label">Fecha limite</label>
                                    <input type="date" class="form-control rounded-5 border-success" id="fecha" name="fecha" placeholder="dd/mm/aaaa" data-bs-toggle="tooltip" data-bs-placement="left" title="Selecciona una fecha">
                                </div>
                                <div class="col-md-6">
                                    <label for="hora" class="form-label">Hora Inicio</label>
                                    <input type="time" class="form-control rounded-5 border-success" id="hora" placeholder="HH:MM" data-bs-toggle="tooltip" data-bs-placement="left" title="Selecciona una hora">
                                </div>
                                <div class="col-md-6">
                                    <label for="hora" class="form-label">Hora limite</label>
                                    <input type="time" class="form-control rounded-5 border-success" id="hora" placeholder="HH:MM" data-bs-toggle="tooltip" data-bs-placement="left" title="Selecciona una hora">
                                </div>
                                <p>Etiquetas</p>
                                <div class="col-md-6">
                                    <div class="mb-3">
                                        <label for="etiqueta_opc" class="form-label">Elegir</label>
                                        <select id="etiqueta-opc" class="form-select rounded-5 border-success">
                                        <option selected>...</option>
                                        <option>Escuela</option>
                                        <option>Ejercicio</option>
                                        <option>Urgente</option>
                                        <option>Trabajo</option>
                                        <option>Casa</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <label for="new_etiqueta" class="form-label">Otro</label>
                                    <input type="text" class="form-control rounded-5 border-success" id="new_etiqueta">
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
        <jsp:include page="recursos/footer.jsp"/>
    </body>
</html>
