<#import "../base.ftl" as b>

<@b.base>
    <#include "navbar_login.ftl">
<div class="content">
    <div class="row">
        <div class="col-lg-6">

        </div>
        <div class="col-lg-6">
            <div class="row">
                <div class="card border-primary mb-3 mx-auto" style="max-width: 20rem;">
                    <div class="card-body">
                        <h4 class="card-title" align="center" style="font-family: leaf; font-size: 50px; color: #316a3a">BanaGreen</h4>
                        <!-- <p class="card-text">Registrate en la red donde puedes compartir tus pensamientos</p> -->
                        <form action="confirmLogin" autocomplete="off" method="post">
                            <div class="form-group row">
                                <div class="col-md-12" style="margin: 0 auto;">
                                    <input class="form-control" name="username" placeholder="Usuario" type="text">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-12" style="margin: 0 auto;">
                                    <input class="form-control" name="passwd" placeholder="Contraseña" type="password">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="custom-control custom-checkbox" style="margin: 0 auto;">
                                    <input class="custom-control-input" id="customCheck1" type="checkbox" name="remember">
                                    <label class="custom-control-label" for="customCheck1">Recordarme</label>
                                </div>
                            </div>
                            <div class="form-group row">
                                <button type="submit" class="btn btn-success mx-auto"><i class="fa fa-sign-in"> <strong>Entrar</strong></i></button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</@b.base>