<#import "../base.ftl" as b>

<@b.base>
    <#include "navbar_portfolio.ftl">
    <div class="hero-image">
        <div class="image-bottom-left">
            <img src="playa.jpg" class="image-avatar image-special" alt="Avatar">
            <div class="middle">
                <a href="/" class="myicono"><i class="fa fa-camera" style="font-size: 40px;"></i></a>
            </div>
        </div>
    </div>

<div class="card">
    <div class="card-body">
        <div class="row">
            <div class="col-lg-2">
                <h3><strong>Usuario</strong></h3>
                <h6>username</h6>
            </div>
            <div class="col-lg-5 mx-auto">
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title"><strong>Usuario</strong></h5>
                        <h6 class="card-subtitle text-muted">Actualizó su foto de portada  <time datetime="2018-07-20" style="float: right"> 20-07-2018 1:08 AM</time></h6>
                    </div>
                    <img style="height: 200px; width: 100%; display: block;" src="playa.jpg" alt="Card image">
                    <div class="card-body">
                        <p class="card-text">Aquí disfrutando de una playita</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"> A fulano y otros le ha gustado tu post</li>
                    </ul>
                    <div class="card-body">
                        <div class="like-panel">
                            <form action="" method="POST">
                                <button class="btn btn-sm btn-outline-success" name="vote" value="like">
                                    <#--<i class="fa fa-thumbs-up"></i>&nbsp;Me gusta&nbsp;<span class="badge badge-light">${ likes }</span>-->
                                </button>
                            </form>
                            <form action="" method="POST">
                                <button class="btn btn-sm btn-outline-danger" name="vote" value="dislike">
                                    <#--<i class="fa fa-thumbs-down"></i>&nbsp;No me gusta&nbsp;<span class="badge badge-light">${ dislikes }</span>-->
                                </button>
                            </form>
                        </div>
                    </div>
                    <div class="card-footer text-muted">
                        No se ha comentado este post
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="row">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Comparte lo que piensas</h4>
                            <!-- <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6> -->
                            <form action="" method="POST">
                                <fieldset>
                                    <div class="form-group">
                                        <!-- <label for="exampleTextarea">Example textarea</label> -->
                                        <textarea class="form-control" id="exampleTextarea" placeholder="Escribe aquí" rows="5"></textarea>
                                    </div>
                                    <div class="form-group row">
                                        <button type="button" class="btn btn-primary"><i class="fa fa-picture-o"> Sube una Foto</i></button>
                                        <button type="button" class="btn btn-success"><i class="fa fa-share-alt"> Publicar</i></button>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <ul class="list-group">
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
    </div>
</div>
</@b.base>