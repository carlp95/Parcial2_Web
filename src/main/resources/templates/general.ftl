<#macro base user>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${ title }</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link  href="https://bootswatch.com/4/darkly/bootstrap.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="icon"
          type="image/x-icon"
          href="/images/favicon.ico">
<#--<link rel="stylesheet" type="text/css" href="/css/all.css">-->
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<header class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Banana Blog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation" style="">
        <span class="navbar-toggler-icon"></span>
    </button>

        <#if user != "vacio">
            <div class="collapse navbar-collapse" id="navbarColor02">
                <ul class="navbar-nav mr-auto">
                    <#if user.administrator>
                        <li class="nav-item">
                            <a class="nav-link" href="/createUser">Crear Usuario <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/createArticle">Crear Artículo</a>
                        </li>
                    <#elseif user.author>
                        <li class="nav-item">
                            <a class="nav-link" href="/createArticle">Crear Artículo</a>
                        </li>
                    </#if>

                </ul>
            </div>
            <div>
                <div class="nav-link" style="float:left; font-style: italic">¡Hey, ${ user.username?cap_first }! What's up?</div>
                <a href="/logout"><button class="btn btn-secundary">Cerrar Sesión</button></a>
            </div>
        <#else >
            <div class="collapse navbar-collapse" id="navbarColor02">

            </div>
            <a href="/login"><button class="btn btn-secundary">Iniciar Sesión</button></a>
        </#if>

</header>

<#--contenido-->
<div class="content">
        <#nested>
    <div id="chat-button" class="chat chat-button">
        <div class="chat chat-icon">
            <i class="fa fa-comments"></i>
        </div>
    </div>

    <div id="chat-form" class="chat chat-window card hidden">
        <div class="card-header bg-success text-light">¿Cuál es tú nombre?</div>
        <div class="card-body">
            <div class="input-group mb-3">
                    <#if user == "vacio">
                        <input class="form-control" type="text" name="username" placeholder="Nombre">
                    <#else >
                        <input class="form-control" type="text" name="username" placeholder="Nombre" value="${user.username}" disabled>
                    </#if>

            </div>
            <div class="input-group mb-3">
                <input class="form-control" type="text" name="message" id ="message" placeholder="Escribe un mensaje...">
                <div class="input-group-append">
                    <button class="btn btn-primary" id="submit-message" type="submit"><i class="fa fa-paper-plane"></i></button>
                </div>
            </div>
                <#if user == "vacio">
                    <small>¿Estás registrado? <a href="/login">Inicia sesión</a></small>
                </#if>
        </div>
    </div>

    <div id="chat-main-window" class="chat chat-window card hidden">
        <div class="card-header bg-success text-light">
            Chatea con alguien
        <#--<a class="float-right"><i class="fa fa-times ml-3"></i></a>-->
            <button type="button" class="close"  aria-hidden="true"> &times;</button>
            <div class="float-right">
                <a><i class="fa fa-comment"></i></a>
                <span class="badge badge-notify">1</span>
            </div>
        </div>
        <div class="card-body">
            <div class="chat-dialog">
                <div class="chat-dialog chat-dialog-sendername">Makarena says</div>
                <div class="chat-dialog chat-dialog-message">Yo estoy bien! jijiji</div>
            </div>
            <div class="chat-dialog">
                <div class="chat-dialog chat-dialog-sendername">Manuel says</div>
                <div class="chat-dialog chat-dialog-message">Bien, porque preguntas?</div>
            </div>

            <div class="chat-dialog chat-dialog-right">
                <div class="chat-dialog chat-dialog-sendername">Henry says</div>
                <div class="chat-dialog chat-dialog-message" id="chat_message"></div>
            </div>
        </div>

        <div class="card-footer">
            <div class="input-group">
                <input class="form-control " type="text" name="message" id="message" placeholder="Escribe un mensaje...">
                <div class="input-group-append">
                    <button class="btn btn-primary " id="submit-message" type="submit"><i class="fa fa-paper-plane"></i></button>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="/js/chat.js"></script>
</div>

<#--footer-->
<footer class="footer">
        <#include "footer.ftl">
</footer>

<#--<script-->
<#--src="https://code.jquery.com/jquery-3.3.1.min.js"-->
<#--integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="-->
<#--crossorigin="anonymous"></script>-->

<#--<script src="/js/like-dislike.js"></script>-->

</body>
</html>

</#macro>
