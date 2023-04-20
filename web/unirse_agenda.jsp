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
        <br><br>
        <div class="container-sm">
            <div class="row">
                <div class="col-sm-1"></div>
                
                    <div id="pendiente-apersonal">
                    <!-- Contenido de la agenda personal -->
                        <div class="card shadow-lg">
                            <div class="card-body">
                                <form class="row g-3 ">
                                    <div class="col-md-5">
                                        <label for="titulo" class="form-label">Código</label>
                                        <input type="text" class="form-control" id="titulo">
                                    </div>
                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary">Unirme</button>
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
