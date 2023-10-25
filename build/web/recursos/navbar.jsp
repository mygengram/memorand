<%-- 
    Memorand by Gengram © 2023
--%>
<nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top shadow-sm" style="padding:1%;">
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
            <button class="btn custom-bsign" type="submit"><i class="bi bi-search"></i></button>
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