<%-- 
    Document   : nueva_agenda
    Created on : 13 abr 2023, 0:08:39
    Author     : zunig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Navbar.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anónimo">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/css/bootstrap.min.css" integrity="sha512-1M7VdJjKb+ofV81pFpAa7VrjJgGGQolV1HcIgOev7JG8CegYk7teuJDrxMJ28gDTu8rRUmVZaOwCvQJ6TUYq3g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-icons/font/bootstrap-icons.css">
        <link rel="stylesheet" type="text/css" href="style.css">
        
        <title>Nueva agenda</title>
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
                <div class="col-sm-2"></div>
                <div class="col-sm-10">
                    <br><br>
                    <h1 style="color: #ffec9f; font-size: 250%; text-align: center;">Nuevo Agenda</h1>
                </div>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
