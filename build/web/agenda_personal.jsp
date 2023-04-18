<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navbar.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi agenda</title>
        <link rel="shortcut icon" href="images/me-logoP.png">
        <link rel="stylesheet" href="styles.css">
        <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/323dc2b1ab.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-icons/font/bootstrap-icons.css">
    </head>
    <script>
        function closeNav() {
            var nav = document.getElementById("contenido");
            if (nav.classList.contains("show")) {
                nav.classList.remove("show");
            }
        }
    </script>
    <body onclick="closeNav()">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-10">
                    <br><br>
                    <h1 class="text-secondary">Agenda Personal</h1>
                </div>
            </div>
        </div>
    </body>
</html>
