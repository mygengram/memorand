<%-- 
    Document   : planInst
    Created on : 24 oct. 2023, 0:06:53
    Author     : zunig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="auto">
    <head>
        <jsp:include page="recursos/import.jsp"/>
        <title>Memorand</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top shadow-sm" style="padding:1%;">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">
                    <img src="images/logotypes/me-logoEX.png" alt="memorand" width="200" style="margin-left:40%">
                </a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left: 65%;">
                </div>
            </div>
        </nav>
        <div class="container mt-4">
            <h2 class="display-6 text-center mb-4" style="font-size: 400%;">
                <svg width="70" height="70" data-name="Layer 1" viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg"><path d="M16.91 28.11a1 1 0 0 1-.7-.29 1 1 0 0 1 0-1.42l6.36-6.4A1 1 0 0 1 24 21.45l-6.36 6.37a1 1 0 0 1-.73.29Zm-5.65-3.83 9.9-9.9a1 1 0 0 0 0-1.41 1 1 0 0 0-1.42 0l-9.9 9.9a1 1 0 0 0 .71 1.71 1 1 0 0 0 .71-.3ZM9.13 16.5l4.25-4.24a1 1 0 0 0 0-1.41 1 1 0 0 0-1.42 0l-4.24 4.24a1 1 0 0 0 .71 1.71 1 1 0 0 0 .7-.3Zm15.43-3 1.08-1.52h1.87a1.09 1.09 0 0 0 .91-.54 1 1 0 0 0-.09-1.06l-1.12-1.51.6-1.77a1 1 0 0 0-1.27-1.27l-1.77.6-1.5-1.12a1 1 0 0 0-1.6.81L21.7 8l-1.53 1.07a1 1 0 0 0 .28 1.77l1.79.56.55 1.78a1 1 0 0 0 .8.69h.16a1 1 0 0 0 .81-.41Zm-1.28-4.18a1 1 0 0 0 .43-.83v-.37l.3.22a1 1 0 0 0 .92.15l.34-.12-.12.35a1 1 0 0 0 .15.92l.22.29h-.37a1 1 0 0 0-.83.42l-.21.3-.11-.35a1 1 0 0 0-.66-.66L23 9.53Zm4.46 9.05L28 18h.43a1 1 0 0 0 .8-1.6l-.23-.29.14-.4a1 1 0 0 0-.24-1 1 1 0 0 0-1-.24l-.39.13-.33-.25a1 1 0 0 0-1.18-.11 1 1 0 0 0-.54.91v.41l-.33.24a1 1 0 0 0-.41 1 1 1 0 0 0 .69.8l.39.12.12.4a1 1 0 0 0 .8.69h.16a1 1 0 0 0 .86-.44ZM16.35 9.86l.44-.63h.78a1.09 1.09 0 0 0 .9-.55 1 1 0 0 0-.09-1L17.92 7l.25-.73A1 1 0 0 0 16.9 5l-.73.24-.62-.46a1 1 0 0 0-1.06-.09 1 1 0 0 0-.54.91v.77l-.63.45a1 1 0 0 0-.41 1 1 1 0 0 0 .69.8l.74.23.22.74a1 1 0 0 0 .8.69h.16a1 1 0 0 0 .83-.42Zm-10 13.72 5-5a1 1 0 0 0 0-1.41 1 1 0 0 0-1.42 0l-5.04 4.99a1 1 0 0 0 0 1.42 1 1 0 0 0 .71.29 1 1 0 0 0 .71-.29Zm4.4 6.13 6-6a1 1 0 0 0-1.42-1.42l-6 6a1 1 0 0 0 0 1.42 1 1 0 0 0 1.42 0Z" fill="#26988a" class="fill-000000"></path></svg>
                Instituciones educativas
                <svg width="70" height="70" data-name="Layer 1" viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg"><path d="M16.91 28.11a1 1 0 0 1-.7-.29 1 1 0 0 1 0-1.42l6.36-6.4A1 1 0 0 1 24 21.45l-6.36 6.37a1 1 0 0 1-.73.29Zm-5.65-3.83 9.9-9.9a1 1 0 0 0 0-1.41 1 1 0 0 0-1.42 0l-9.9 9.9a1 1 0 0 0 .71 1.71 1 1 0 0 0 .71-.3ZM9.13 16.5l4.25-4.24a1 1 0 0 0 0-1.41 1 1 0 0 0-1.42 0l-4.24 4.24a1 1 0 0 0 .71 1.71 1 1 0 0 0 .7-.3Zm15.43-3 1.08-1.52h1.87a1.09 1.09 0 0 0 .91-.54 1 1 0 0 0-.09-1.06l-1.12-1.51.6-1.77a1 1 0 0 0-1.27-1.27l-1.77.6-1.5-1.12a1 1 0 0 0-1.6.81L21.7 8l-1.53 1.07a1 1 0 0 0 .28 1.77l1.79.56.55 1.78a1 1 0 0 0 .8.69h.16a1 1 0 0 0 .81-.41Zm-1.28-4.18a1 1 0 0 0 .43-.83v-.37l.3.22a1 1 0 0 0 .92.15l.34-.12-.12.35a1 1 0 0 0 .15.92l.22.29h-.37a1 1 0 0 0-.83.42l-.21.3-.11-.35a1 1 0 0 0-.66-.66L23 9.53Zm4.46 9.05L28 18h.43a1 1 0 0 0 .8-1.6l-.23-.29.14-.4a1 1 0 0 0-.24-1 1 1 0 0 0-1-.24l-.39.13-.33-.25a1 1 0 0 0-1.18-.11 1 1 0 0 0-.54.91v.41l-.33.24a1 1 0 0 0-.41 1 1 1 0 0 0 .69.8l.39.12.12.4a1 1 0 0 0 .8.69h.16a1 1 0 0 0 .86-.44ZM16.35 9.86l.44-.63h.78a1.09 1.09 0 0 0 .9-.55 1 1 0 0 0-.09-1L17.92 7l.25-.73A1 1 0 0 0 16.9 5l-.73.24-.62-.46a1 1 0 0 0-1.06-.09 1 1 0 0 0-.54.91v.77l-.63.45a1 1 0 0 0-.41 1 1 1 0 0 0 .69.8l.74.23.22.74a1 1 0 0 0 .8.69h.16a1 1 0 0 0 .83-.42Zm-10 13.72 5-5a1 1 0 0 0 0-1.41 1 1 0 0 0-1.42 0l-5.04 4.99a1 1 0 0 0 0 1.42 1 1 0 0 0 .71.29 1 1 0 0 0 .71-.29Zm4.4 6.13 6-6a1 1 0 0 0-1.42-1.42l-6 6a1 1 0 0 0 0 1.42 1 1 0 0 0 1.42 0Z" fill="#26988a" class="fill-000000"></path></svg>
            </h2>
            <div class="row  row-cols-md-3 mb-3 text-center">
                <div class="col-4"></div>
                <div class="col-4">
                    <div class="card border-primary mb-4 rounded-3 shadow-sm mx-5">
                        <div class="card-header py-3"  style="background-color: #3ba79c;">
                            <h4 class="my-0 fw-normal text-white"><i class="bi bi-stars" style="color: yellow;"></i><b>  Gratuito  </b><i class="bi bi-stars" style="color: yellow;"></i></h4>
                        </div>
                        <div class="card-body">
                            <h2 class="card-title pricing-card-title text-body-secondary">$0<small class="text-body-secondary fw-light">/mes</small></h2>
                            <ul class="list-unstyled mt-3 mb-4 text-justify text-start mx-5">
                                <li ><i class="bi text-primary bi-check-lg"></i> 2 espacios</li>
                                <li><i class="bi text-primary bi-check-lg"></i> Estad&iacute;sticas</li>
                                <li><i class="bi text-primary bi-check-lg"></i> Ideas y apuntes</li>
                                <li><i class="bi text-primary bi-check-lg"></i> Rutinas</li>
                                <li><i class="bi text-primary bi-check-lg"></i> Tareas</li>
                                <li><i class="bi text-primary bi-check-lg"></i> Calendario</li>
                                <li><i class="bi text-primary bi-check-lg"></i> Compartir ideas y apuntes</li>
                                <li><i class="bi text-primary bi-check-lg"></i> Aplicaci&oacute;n m&oacute;vil</li>
                            </ul>
                            <button type="button" class="w-100 btn btn-lg custom-bsign">Reg&iacute;strate gratis</button>
                        </div>
                    </div>
                </div>
                <div class="col-4"></div>
            </div>
        </div>

        <style>
            .custom-bsign {
                display: inline-block;
                padding: 8px 16px;
                border: 2px solid #27988A; /* Color del contorno */
                background-color: #27988A; /* Fondo transparente */
                color: #fff; /* Color del texto */
                text-align: center;
                text-decoration: none;
                font-size: 16px;
                cursor: pointer;
                border-radius: 4px;
            }

            .custom-bsign:hover {
                background-color: #fff; /* Cambiar el color de fondo al pasar el ratón */
                color: #27988A; /* Cambiar el color del texto al pasar el ratón */
                border: 2px solid #27988A; /* Color del contorno */
            }
        </style>
        <jsp:include page="recursos/footer.jsp"/>
    </body>
</html>
