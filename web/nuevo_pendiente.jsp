<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navbar.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo pendiente</title>
        <link rel="shortcut icon" href="images/me-logoP.png">
        <link rel="stylesheet" href="styles.css">
        <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/323dc2b1ab.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-icons/font/bootstrap-icons.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <script>
        function closeNav() {
            var nav = document.getElementById("contenido");
            if (nav.classList.contains("show")) {
                nav.classList.remove("show");
            }
        }
    </script>
    <script>
        function cambia() {
            const agendaPersonal = document.getElementById("pendiente-apersonal");
            const agendaComunitaria = document.getElementById("pendiente-acomunitaria");
            const agendaComunit = document.getElementById("comuni");

            const formulario = document.getElementsByName("flexRadio");
            formulario.forEach((radio) => {
                radio.addEventListener("change", () => {
                if (radio.value === "flexRadio-1") {
                    agendaPersonal.style.display = "block";
                    agendaComunitaria.style.display = "none";
                    agendaComunit.style.display = "none";
                } else if (radio.value === "flexRadio-2") {
                    agendaPersonal.style.display = "none";
                    agendaComunitaria.style.display = "block";
                    agendaComunit.style.display = "block";
                    }
                });
            });
        }
    </script>
    <body onclick="closeNav()">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-1"></div>
                
                <div class="col-sm-10">
                    <br><br>
                    <h1 class="text-secondary">Nuevo Pendiente</h1> 
                    <br><br>
                    
                    <div class="card shadow"  style="width: 24rem;">
                        <div class="card-body">
                            <div class="form-check form-check-inline" >
                                <input class="form-check-input" type="radio" name="flexRadio" value="flexRadio-1" id="flexRadio1" onclick="cambia()" checked >
                                <label class="form-check-label" for="flexRadio1" >
                                Agenda Personal
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="flexRadio" value="flexRadio-2" id="flexRadio2" onclick="cambia()">
                                <label class="form-check-label" for="flexRadio2">
                                Agenda Comunitaria
                                </label>
                            </div>
                        </div>
                    </div>
                    
                    <br><br>
                    <div id="pendiente-apersonal">
                    <!-- Contenido de la agenda personal -->
                        <div class="card shadow-lg">
                            <div class="card-body">
                                <form class="row g-3 ">
                                    <div class="col-md-5">
                                        <label for="titulo" class="form-label">T&iacute;tulo</label>
                                        <input type="text" class="form-control" id="titulo">
                                    </div>
                                    <div class="col-md-1">
                                        <div class="d-grid"><button type="button" class="btn btn-light btn-sm mt-3"><input type="color" class="form-control form-control-color" id="ColorInput1" value="#77dbc3" title="Elige tu color"/></button></div>
                                    </div>
                                    <div class="col-md-5">
                                        <label for="subtitulo" class="form-label">Subt&iacute;tulo</label>
                                         <input type="text" class="form-control" id="subtitulo">
                                    </div>
                                    <div class="col-md-1">
                                        <div class="d-grid"><button type="button" class="btn btn-light btn-sm mt-3"><input type="color" class="form-control form-control-color" id="ColorInput2" value="#77dbc3" title="Elige tu color"/></button></div>
                                    </div>
                                    <div class="col-12">
                                        <label for="descrip" class="form-label">Descripci&oacute;n</label>
                                        <textarea class="form-control" id="descrip" rows="2"></textarea>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="fecha" class="form-label">Fecha limite</label>
                                        <input type="date" class="form-control" id="fecha" name="fecha" placeholder="dd/mm/aaaa" data-bs-toggle="tooltip" data-bs-placement="left" title="Selecciona una fecha">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="hora" class="form-label">Hora limite</label>
                                        <input type="time" class="form-control" id="hora" placeholder="HH:MM" data-bs-toggle="tooltip" data-bs-placement="left" title="Selecciona una hora">
                                    </div>
                                    <p>Etiquetas</p>
                                    <div class="col-md-6">
                                        <div class="mb-3 ms-3">
                                            <label for="etiqueta_opc" class="form-label">Elegir</label>
                                            <select id="etiqueta-opc" class="form-select">
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
                                        <input type="text" class="form-control" id="new_etiqueta">
                                    </div>
                                    <p>Adjuntar</p>
                                    <div class="col-md-6">
                                        <div class="mb-3 ms-3">
                                            <label for="img" class="form-label">Imagen</label>
                                            <input class="form-control" type="file" id="img">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="link" class="form-label">Enlaces</label>
                                        <input type="text" class="form-control" id="link">
                                    </div>
                                    

                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary">Guardar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    <br><br>
                    </div>
                    
                    <div id="pendiente-acomunitaria" style="display:none;">
                    <!-- Contenido de la agenda comunitaria -->
                        <div class="card shadow"  style="width: 22rem;">
                            <div class="card-body">
                                <h5 class="card-title" style="text-align: center;">Agendas Comunitarias</h5>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" checked>
                                    <label class="form-check-label" for="flexRadioDefault1">
                                    Default radio
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" >
                                    <label class="form-check-label" for="flexRadioDefault2">
                                    Default checked radio
                                     </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                                    <label class="form-check-label" for="flexRadioDefault1">
                                    Default radio
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" >
                                    <label class="form-check-label" for="flexRadioDefault2">
                                    Default checked radio
                                     </label>
                                </div>
                            </div>
                        </div>
                    <br>
                        <div class="card shadow-lg">
                            <div class="card-body">
                                <form class="row g-3 ">
                                    <div class="col-md-5">
                                        <label for="titulo" class="form-label">T&iacute;tulo</label>
                                        <input type="text" class="form-control" id="titulo">
                                    </div>
                                    <div class="col-md-1">
                                        <div class="d-grid"><button type="button" class="btn btn-light btn-sm mt-3"><input type="color" class="form-control form-control-color" id="ColorInput1" value="#77dbc3" title="Elige tu color"/></button></div>
                                    </div>
                                    <div class="col-md-5">
                                        <label for="subtitulo" class="form-label">Subt&iacute;tulo</label>
                                         <input type="text" class="form-control" id="subtitulo">
                                    </div>
                                    <div class="col-md-1">
                                        <div class="d-grid"><button type="button" class="btn btn-light btn-sm mt-3"><input type="color" class="form-control form-control-color" id="ColorInput2" value="#77dbc3" title="Elige tu color"/></button></div>
                                    </div>
                                    <div class="col-12">
                                        <label for="descrip" class="form-label">Descripci&oacute;n</label>
                                        <textarea class="form-control" id="descrip" rows="2"></textarea>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="fecha" class="form-label">Fecha</label>
                                        <input type="date" class="form-control" id="fecha" name="fecha" placeholder="dd/mm/aaaa" data-bs-toggle="tooltip" data-bs-placement="left" title="Selecciona una fecha">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="hora" class="form-label">Hora</label>
                                        <input type="time" class="form-control" id="hora" placeholder="HH:MM" data-bs-toggle="tooltip" data-bs-placement="left" title="Selecciona una hora">
                                    </div>
                                    <div class="col-12">
                                        <div class="mb-3 ">
                                            <label for="etiqueta_opc" class="form-label">Asignado a</label>
                                            <select id="etiqueta-opc" class="form-select">
                                            <option selected>...</option>
                                            <option>Usuario 1</option>
                                            <option>Usuario 2</option>
                                            <option>Usuario 3</option>
                                            <option>...</option>
                                            </select>
                                        </div>
                                    </div>
                                    <p>Etiquetas</p>
                                    <div class="col-md-6">
                                        <div class="mb-3 ms-3">
                                            <label for="etiqueta_opc" class="form-label">Elegir</label>
                                            <select id="etiqueta-opc" class="form-select">
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
                                        <input type="text" class="form-control" id="new_etiqueta">
                                    </div>
                                    <p>Adjuntar</p>
                                    <div class="col-md-6">
                                        <div class="mb-3 ms-3">
                                            <label for="img" class="form-label">Imagen</label>
                                            <input class="form-control" type="file" id="img">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="link" class="form-label">Enlaces</label>
                                        <input type="text" class="form-control" id="link">
                                    </div>
                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary">Guardar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    <br><br>
                    </div>
                </div>
                <br><br>
            </div>
        </div>
    </body>
</html>
