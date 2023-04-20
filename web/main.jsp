<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navbar.jsp"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
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
    <body onclick="closeNav()">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-10">
                    <br><br>
                    <h1 class="text-secondary">Lo que tienes que hacer hoy</h1>
                    <div class="row"> 
                        <div class="col-sm-4">
                            <div class="card border-3 ms-4 mt-4" style="width: 18rem;">
                                <a class="navbar-brand" href="nuevo_pendiente.jsp">
                                    <div style="text-align: center;"><img src="images/plus-pequeno.png" alt="plus"> </div>
                                </a>
                                <div class="card-body">
                                    <div style="text-align: center;"><a href="nuevo_pendiente.jsp" class="btn btn-light btn-custom">Nuevo Pendiente</a> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 ">
                            <div class="card border-3 ms-4 mt-4 " style="width: 18rem;">
                                <a class="navbar-brand" href="nueva_agenda.jsp">
                                    <div style="text-align: center;"><img src="images/agregar-usuario.png" alt="plus"> </div>
                                </a>
                                <div class="card-body">
                                    <div style="text-align: center;"><a href="nueva_agenda.jsp" class="btn btn-light btn-custom">Crear una agenda comunitaria</a> </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="card border-3 ms-4 mt-4" style="width: 18rem;">
                                <a class="navbar-brand" href="unirse_agenda.jsp">
                                    <div style="text-align: center;"><img src="images/usuario-de-grafico.png" alt="plus"> </div>
                                </a>
                                <div class="card-body">
                                    <div style="text-align: center;"><a href="unirse_agenda.jsp" class="btn btn-light btn-custom">Unirse a una agenda</a> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br><hr><br>
                    
                    <h2 class="text-secondary">Esta semana...</h2>
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
                    
                    <h2 class="text-secondary">Pr&oacute;xima semana...</h2>
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
</html>
