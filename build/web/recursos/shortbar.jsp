<%-- 
    Memorand by Gengram � 2023
--%>
<nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top" style="padding:1%;">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">
            <img src="images/logotypes/me-logoEX.png" alt="memorand" width="200" style="margin-left:40%">
        </a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left: 65%;">
            <!-- BUTTONS -->
            
            <button class="btn custom-blog btn-sm me-2 fs-6 border-opacity-25 rounded-4" data-bs-toggle="modal" data-bs-target="#loginModal" type="button">Iniciar sesi�n</button>
            
            <!-- Modal de inicio de sesi�n -->

            <a href="signup.jsp?a=n">
                <button class="btn custom-bsign btn-lg fs-6 border-2 rounded-4" data-bs-toggle="modal" type="button">Registrarse</button>
            </a>
        </div>
    </div>
</nav>
        
<style>
    .custom-blog {
    display: inline-block;
    padding: 8px 16px;
    border: 2px solid #27988A; /* Color del contorno */
    background-color: transparent; /* Fondo transparente */
    color: #27988A; /* Color del texto */
    text-align: center;
    text-decoration: none;
    font-size: 16px;
    cursor: pointer;
    border-radius: 4px;
    }

    .custom-blog:hover {
        background-color: #27988A; /* Cambiar el color de fondo al pasar el rat�n */
        color: #fff; /* Cambiar el color del texto al pasar el rat�n */
    }
    
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
        background-color: #fff; /* Cambiar el color de fondo al pasar el rat�n */
        color: #27988A; /* Cambiar el color del texto al pasar el rat�n */
        border: 2px solid #27988A; /* Color del contorno */
    }

</style>