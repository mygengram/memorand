<%-- 
    Memorand by Gengram © 2023
--%>

<div class="modal fade" tabindex="-1" role="dialog" id="modalSignin">
    <div class="modal-dialog modal-dialog-centered text-center" role="document">
        <div class="modal-content rounded-4 shadow">
            <div class="modal-header p-5 pb-4 border-bottom-0">
                <h1 class="fw-bold mb-0 fs-2 text-primary">Registrarse</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body p-5 pt-0">
                <form class="">
                    <div class="form-floating mb-3">
                        <input type="email" class="form-control rounded-3" id="usuario">
                        <label for="floatingInput">Usuario</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" class="form-control rounded-3" id="contrasena">
                        <label for="floatingPassword">Contrase&ntilde;a</label>
                    </div>
                    <a href="/memorand/inicio.jsp"><button class="w-100 mb-2 btn btn-lg rounded-3 custom-bsign" type="submit">Registrarse</button></a>
                    <small class="text-body-secondary"><a type="button" data-bs-target="#modalLogin" data-bs-toggle="modal">¿Ya tienes una cuenta?  Inicia</a></small>
                    <hr class="my-4">
                    <p class="mb-3 text-primary" style="font-size: 70%;">Condiciones de uso | Política de privacidad</p>
                </form>
            </div>
        </div>
    </div>
</div>
