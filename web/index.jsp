<%@page contentType="text/html" pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html lang="es">

    <head>
        <jsp:include page="recursos/import.jsp"/>
        <link rel="shortcut icon" href="images/logotypes/me-logoP.png">
        <link rel="stylesheet" href="bootstrap/style.css">
        <title>Memorand - Inicio</title>
    </head>

    <body>
        <jsp:include page="recursos/shortbar.jsp"/>
        
        <!-- PRESENTATION -->
        <div class="container text-center">
            <div class="row">
                <div class="col">
                </div>
                <div class="col-8 my-5">
                    <img src="images/logotypes/me-bee.png" alt="icon" width="100" style="margin-top:8%;">
                    <h1 style="padding:4%"><strong>Organiza tu día sin complicaciones</strong></h1>
                    <p style="margin-left: 6%; margin-right: 6%;">Memorand es tu espacio ideal para planear tu día a día en poco tiempo, permitíendote saber en todo momento lo que quieres hacer.</p>
        <!-- PRESENTATION <button class="btn btn-primary fs-6 text-white" data-bs-toggle="modal" data-bs-target="#loginModal" type="button" style="padding:2%;">Ir a Memorand</button> -->
                    
                </div>
                <div class="col">
                </div>
            </div>
        </div>
        
        <jsp:include page="recursos/footer.jsp"/>
    </body>
</html>