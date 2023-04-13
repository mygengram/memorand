<%-- 
    Document   : menu_principal
    Created on : 7 abr 2023, 23:30:15
    Author     : zunig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Navbar.jsp"/>
<!DOCTYPE html>
<html lang="en">
    
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

        <title>Memorand</title>
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
                    <h1 style="color: #77dbc3; font-size: 340%;">Lo que tienes que hacer hoy</h1>
                    <div class="row"> 
                        <div class="col-sm-4">
                            <div class="card border-3 ms-4 mt-4" style="width: 18rem;">
                                <a class="navbar-brand" href="nuevo_pendiente.jsp">
                                    <div style="text-align: center;"><img src="imagenes/plus-pequeno.png" alt="plus"> </div>
                                </a>
                                <div class="card-body">
                                    <div style="text-align: center;"><a href="nuevo_pendiente.jsp" class="btn btn-light btn-custom">Nuevo Pendiente</a> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 ">
                            <div class="card border-3 ms-4 mt-4 " style="width: 18rem;">
                                <a class="navbar-brand" href="#">
                                    <div style="text-align: center;"><img src="imagenes/agregar-usuario.png" alt="plus"> </div>
                                </a>
                                <div class="card-body">
                                    <div style="text-align: center;"><a href="#" class="btn btn-light btn-custom">Nuevo Agenda Comunitaria</a> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="card border-3 ms-4 mt-4" style="width: 18rem;">
                                <a class="navbar-brand" href="#">
                                    <div style="text-align: center;"><img src="imagenes/usuario-de-grafico.png" alt="plus"> </div>
                                </a>
                                <div class="card-body">
                                    <div style="text-align: center;"><a href="#" class="btn btn-light btn-custom">Unirse a una AC</a> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br><hr><br>
                    <h2 style="color: #ffec9f; font-size: 340%;">Esta semana...</h2>
                    <br>
                    <div class="row"> 
                        <div class="col-sm-4">
                            <div class="card  mb-2 ms-4 mt-4" style="width: 18rem;">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="card  mb-2 ms-4 mt-4" style="width: 18rem;">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="card  mb-2 ms-4 mt-4" style="width: 18rem;">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              </div>
                            </div>
                        </div>
                    </div>
                    <br><hr><br>
                    <h2 style="color: #ffec9f; font-size: 340%;">Pr&oacute;xima semana...</h2>
                    <br>
                    <div class="row"> 
                        <div class="col-sm-4 ">
                            <div class="card  mb-2 ms-4 mt-4" style="width: 18rem;">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="card  mb-2 ms-4 mt-4" style="width: 18rem;">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="card  mb-2 ms-4 mt-4" style="width: 18rem;">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              </div>
                            </div>
                        </div>
                    </div>
                    <br><br>
                </div>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
