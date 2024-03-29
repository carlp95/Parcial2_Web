<#import "../base.ftl" as b>

<@b.base>
<#include "navbar_wall.ftl">
    <#include "../menu.ftl">

<div class="container">

    <div class="portrait mb-3">
        <#--<img src="/images/playa.jpg" alt="Imagen de portada">-->
        <div class="profile-pic">
            <img src="/images/monkey-face.png" class="image-avatar image-special" alt="Avatar">
            <div class="middle">
                <a href="#" class="myicono"><i class="fa fa-camera" style="font-size: 40px;"></i></a>
            </div>
        </div>
    </div>

<#--<div class="hero-image">-->
    <#--<div class="image-bottom-left">-->
        <#--<img src="/images/playa.jpg" class="image-avatar image-special" alt="Avatar">-->
        <#--<div class="middle" style="border-color: black">-->
            <#--<a href="/images/monkey-face.png" class="myicono"><i class="fa fa-camera" style="font-size: 40px;"></i></a>-->
        <#--</div>-->
    <#--</div>-->
<#--</div>-->

    <div class="row">
        <div class="col-lg-3">
            <div class="card">
                <div class="card-body">
                    <h3><strong>${ currentUser.name }</strong></h3>
                    <h6>${currentUser.username}</h6>
                    <button type="button" class="btn btn-link" ic-get-from="/editInfo" ic-target="#userInfo" id="showInfo"><i class="fa fa-info-circle"> Información</i></button>
                    <button type="button" class="btn btn-link"><i class="fa fa-images"> Crear Album</i></button>
                    <button type="button" class="btn btn-link"><i class="fa fa-atlas"> Crear Página</i></button>
                    <#--<button type="button" class="btn btn-link"><i class="fa fa-images"> Crear Album</i></button>-->
                </div>
            </div>
        </div>
        <div id="userInfo" class="col-lg-5"></div>
        <div class="col-lg-5 mx-auto" id="story">
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title"><strong>${currentUser.name}</strong></h5>
                    <h6 class="card-subtitle text-muted">Actualizó su foto de portada  <time datetime="2018-07-20" style="float: right"> 20-07-2018 1:08 AM</time></h6>

                <img style="height: 200px; width: 100%; display: block;" src="/images/playa.jpg" alt="Card image">
                    <p class="card-text">Aquí disfrutando de una playita</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"> A fulano y otros le ha gustado tu post</li>
                </ul>
                <div class="card-body">
                    <div class="like-panel">
                        <form action="" method="POST" style="display: inline">
                            <button class="btn btn-sm btn-outline-success" name="vote" value="like">
                                <i class="fa fa-thumbs-up"></i>&nbsp;Me gusta&nbsp;<span class="badge badge-light">0</span>
                            </button>
                        </form>
                        <form action="" method="POST" style="display: inline;">
                            <button class="btn btn-sm btn-outline-danger" name="vote" value="dislike">
                                <i class="fa fa-thumbs-down"></i>&nbsp;No me gusta&nbsp;<span class="badge badge-light">0</span>
                            </button>
                        </form>
                    </div>
                </div>
                <div class="card-footer text-muted">
                    No se ha comentado este post
                </div>
            </div>
        </div>

        <div class="col-lg-4">
            <div class="card friendsnpost" >
                <div class="card-body">
                    <h4 class="card-title">Comparte lo que piensas</h4>
                    <!-- <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6> -->
                    <form action="" method="POST">
                        <fieldset>
                            <div class="form-group">
                                <!-- <label for="exampleTextarea">Example textarea</label> -->
                                <textarea class="form-control" id="exampleTextarea" placeholder="Escribe aquí" rows="5"></textarea>
                            </div>
                            <div class="form-inline">
                                <button type="button" class="btn btn-primary"><i class="fa fa-image"> Sube una Foto</i></button>
                                <button type="button" class="btn btn-success mx-sm-3"><i class="fa fa-share-alt"> Publicar</i></button>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
            <ul class="list-group my-3 ">
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Fulanito
                    <!-- <span class="badge badge-primary badge-pill">14</span> -->
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Pperencejo
                    <!-- <span class="badge badge-primary badge-pill">2</span> -->
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Pepito
                    <!-- <span class="badge badge-primary badge-pill">1</span> -->
                </li>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/changeInfo.js"></script>
<script type="text/javascript" src="/js/city.js"></script>

</@b.base>