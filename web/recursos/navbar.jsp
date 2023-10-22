<%-- 
    Memorand by Gengram © 2023
--%>
<nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top" style="padding:1%;">
    <div class="container-fluid">
        <!-- Barra lateral -->
        <button type="button" class="btn border-0 rounded-circle" style="color: #27988A;" data-bs-toggle="dropdown" aria-expanded="false">
            <i class="bi bi-list" style="font-size: 28px;"></i>
        </button>
        
        <!-- Empresa -->
        <a class="navbar-brand" href="index.jsp">
            <img src="images/logotypes/me-logoEX.png" alt="memorand" width="200" style="margin-left:40%">
        </a>
        
        <!-- Barra para buscar -->
        <form class="d-flex" role="search" style="margin-left:40%">
            <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search">
            <button class="btn custom-bsign" type="submit">Buscar</button>
        </form>
        <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left: 15%;">
            <!-- Noticaciones -->
            <div class="btn-group dropstart mx-3">
                <button type="button" class="btn border-0 rounded-circle" style="color: #27988A;" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="bi bi-bell-fill" style="font-size: 22px;"></i>
                </button>
                <ul class="dropdown-menu my-4">
                    <!-- Dropdown menu links -->
                </ul>
            </div>
            
            <!-- Perfil -->
            <div class="btn-group dropstart">
                <button type="button" class="btn border-0 rounded-circle" style="color: #27988A;" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="bi bi-gear-fill" style="font-size: 22px;"></i>
                </button>
                <ul class="dropdown-menu my-4">
                    <!-- Dropdown menu links -->
                </ul>
            </div>
        </div>
    </div>
</nav>
        
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