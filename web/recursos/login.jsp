<%-- 
    Memorand by Gengram © 2023
--%>

<div class="modal fade" tabindex="-1" role="dialog" id="modalLogin">
                                   <div class="modal-dialog modal-dialog-centered text-center" role="document">
                                       <div class="modal-content rounded-4 shadow">
                                           <div class="modal-header p-5 pb-4 border-bottom-0">
                                               <h1 class="fw-bold mb-0 fs-2 text-primary ">Iniciar Sesi&oacute;n</h1>
                                               <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                           </div>

                                           <div class="modal-body p-5 pt-0">
                                               <form class="">
                                                   <div class="form-floating mb-3">
                                                       <input type="email" class="form-control rounded-3" id="floatingInput" placeholder="name@example.com">
                                                       <label for="floatingInput">Usuario</label>
                                                   </div>
                                                   <div class="form-floating mb-3">
                                                       <input type="password" class="form-control rounded-3" id="floatingPassword" placeholder="Password">
                                                       <label for="floatingPassword">Contraseña</label>
                                                   </div>
                                                   <button class="w-100 mb-2 btn btn-lg rounded-3 custom-bsign" type="submit">Iniciar sesi&oacute;n</button>
                                                   <small class="text-body-secondary">By clicking Sign up, you agree to the terms of use.</small>
                                                   <hr class="my-4">
                                                   <h2 class="fs-5 fw-bold mb-3">Or use a third-party</h2>
                                                   <button class="w-100 py-2 mb-2 btn btn-outline-secondary rounded-3" type="submit">
                                                       <svg class="bi me-1" width="16" height="16"><use xlink:href="#twitter"/></svg>
                                                       Sign up with Twitter
                                                   </button>
                                                   <button class="w-100 py-2 mb-2 btn btn-outline-primary rounded-3" type="submit">
                                                       <svg class="bi me-1" width="16" height="16"><use xlink:href="#facebook"/></svg>
                                                       Sign up with Facebook
                                                   </button>
                                                   <button class="w-100 py-2 mb-2 btn btn-outline-secondary rounded-3" type="submit">
                                                       <svg class="bi me-1" width="16" height="16"><use xlink:href="#github"/></svg>
                                                       Sign up with GitHub
                                                   </button>
                                               </form>
                                           </div>
                                       </div>
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
