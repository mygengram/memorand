<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="recursos/import.jsp"/>
        <title>Calendario</title>
        
        <style>
            .container {
                max-width: 800px;
            }
            .table-bordered td, .table-bordered th {
                border: 1px solid #dee2e6;
            }
            #mesSelector, #a�oSelector {
                display: none;
            }
        </style>
    </head>
    <body>
        <jsp:include page="recursos/navbar.jsp"/>
        <div class="container mt-5">
            <h3 id="mesA�o"></h3>
            <div class="table-responsive">
                <table class="table table-bordered mt-3 border-primary border-5">
                    <thead>
                        <tr>
                            <th class="border-primary border-2">Dom</th>
                            <th class="border-primary border-2">Lun</th>
                            <th class="border-primary border-2">Mar</th>
                            <th class="border-primary border-2">Mi�</th>
                            <th class="border-primary border-2">Jue</th>
                            <th class="border-primary border-2">Vie</th>
                            <th class="border-primary border-2">S�b</th>
                        </tr>
                    </thead>
                    <tbody id="calendario">
                    </tbody>
                </table>
            </div>
            <div id="mesSelector" class="table-responsive">
                <table class="table table-bordered mt-3 border-primary border-5">
                    <thead>
                        <tr>
                            <th colspan="4">Selecciona un Mes</th>
                        </tr>
                    </thead>
                    <tbody id="meses">
                    </tbody>
                </table>
            </div>
            <div id="a�oSelector" class="table-responsive">
                <table class="table table-bordered mt-3 border-primary border-5">
                    <thead>
                        <tr>
                            <th colspan="4">Selecciona un A�o</th>
                        </tr>
                    </thead>
                    <tbody id="a�os">
                    </tbody>
                </table>
            </div>
            <div class="d-flex justify-content-between align-items-center">
                <button id="btnAnterior" class="btn btn-secondary">Anterior</button>
                
                <button id="btnSiguiente" class="btn btn-secondary">Siguiente</button>
                <button id="btnElegirMes" class="btn btn-primary">Elegir Mes</button>
                <button id="btnElegirA�o" class="btn btn-primary">Elegir A�o</button>
            </div>
        </div>
        <jsp:include page="recursos/calendarJS.jsp"/>
    </body>
</html>
