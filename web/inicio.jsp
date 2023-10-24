<%-- 
    Memorand by Gengram © 2023
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="recursos/import.jsp"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap">
        <title>Memorand - Inicio</title>
    </head>
    <body>
        <jsp:include page="recursos/navbar.jsp"/>
        <div class="container text-center" >
            <div class="row" >
                <div class="col-1">
                    <br><br><br>
                </div>
                <div class="col-10">
                    <div class="row">
                        <h1 class="text-start mt-5" style="color: #62646A; font-size: 350%;">Mi Zona</h1><br>
                        <button type="button" class="btn btn-secondary btn-lg me-4 mt-4 float-start text-white custom-size-b1" ><i class="bi bi-clock custom-icon1" ></i><br>HORARIO</button>
                        <button type="button" class="btn btn-secondary btn-lg mx-4 mt-4 float-start text-white custom-size-b1"><i class="bi bi-calendar3 custom-icon1"></i><br>CALENDARIO</button>
                        <button type="button" class="btn btn-secondary btn-lg mx-4 mt-4 float-start text-white custom-size-b1"><i class="bi bi-journals custom-icon1"></i><br>CUADERNO</button>
                        <button type="button" class="btn btn-secondary btn-lg mx-4 mt-4 mb-5 float-start text-white custom-size-b1"><i class="bi bi-check2-circle custom-icon1"></i><br>TAREAS</button>
                        <br>
                        <h1 class="text-start mt-3" style="color: #62646A; font-size: 350%;">Mis Espacios</h1><br>
                        <button type="button" class="btn btn-secondary btn-lg me-4 mt-4 float-start text-white custom-size-b1"><svg width="60" height="60" viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg"><path d="M445.055 384.794v-162.93l-26.25 13.125v149.788l-17.504 45.008h61.25l-17.496-44.991zM229.065 306.37 121.3 252.49v53.776c0 36.243 58.764 65.625 131.25 65.625 72.49 0 131.25-29.382 131.25-65.625V252.49l-107.772 53.884c-18.447 7.307-28.515 7.305-46.963-.003Z" fill="#62646a" class="fill-000000"></path><path d="m264.291 282.897 186.52-93.26c6.459-3.229 6.459-8.51 0-11.74l-186.52-93.26c-6.455-3.229-17.021-3.229-23.48 0l-186.52 93.26c-6.455 3.229-6.455 8.51 0 11.74l186.52 93.26c6.459 3.229 17.025 3.229 23.48 0Z" fill="#62646a" class="fill-000000"></path></svg><br>CLASES</button>
                        <button type="button" class="btn btn-secondary btn-lg mx-4 mt-4 float-start text-white custom-size-b1"><svg width="60" height="60" viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg"><path d="M0 0h48v48H0z" fill="none"></path><path d="M42 12h-4v18H12v4c0 1.1.9 2 2 2h22l8 8V14c0-1.1-.9-2-2-2zm-8 12V6c0-1.1-.9-2-2-2H6c-1.1 0-2 .9-2 2v28l8-8h20c1.1 0 2-.9 2-2z" fill="#62646a" class="fill-000000"></path></svg><br>FORO</button>
                        <button type="button" class="btn btn-secondary btn-lg mx-4 mt-4 mb-5 float-start text-white custom-size-b1"><i class="bi bi-telegram custom-icon1"></i><br>CHAT</button>
                    </div> 
                </div>
                <div class="col-1">
                    <button type="button" class="btn border-0 rounded-circle ms-5" style="color: #27988A;" data-bs-toggle="dropdown" aria-expanded="false">
                        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                    <i class="bi bi-question-circle-fill" style="font-size: 30px;"></i>
                    <br>
                </button>
                </div>
            </div>
        </div>
        <jsp:include page="recursos/footer.jsp"/>
    </body>
</html>
