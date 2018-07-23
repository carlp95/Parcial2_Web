        <div class="card">
            <div class="card-body">
                <form autocomplete="off">
                    <div class="form-group row">
                        <div class="col-md-6" style="margin: 0 auto;">
                            <!-- <label for="username">Usuario</label> -->
                            <input class="form-control" name="personName" value="${currentUser.name}" type="text">
                        </div>
                        <div class="col-md-6" style="margin: 0 auto;">
                            <!-- <label for="password">Contraseña</label> -->
                            <input class="form-control"  name="lastName" ${currentUser.lastname} type="text">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-12" style="margin: 0 auto;">
                            <input class="form-control" name="username" ${currentUser.username} type="text">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-12" style="margin: 0 auto;">
                            <input class="form-control" name="born" value="${currentUser.birthdate}" type="date">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-12" style="margin: 0 auto;">
                            <input class="form-control" name="bornPlace" placeholder="Lugar de nacimiento" type="text">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-12 autocomplete" style="margin: 0 auto;">
                            <input class="form-control" id="citylist" name="city" placeholder="Ciudad" type="text">
                        </div>
                    </div>
                    <div class="form-group row">
                        <button type="submit" class="btn btn-success mx-auto" ic-put-to="/editInfo/${currentUser.username}"><strong>Actualizar</strong></button>
                    </div>
                </form>
            </div>
        </div>
<script type="text/javascript" src="/js/city.js"

