<#macro base>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Banagreen</title>
    <link rel="icon" type="image/x-icon"  href="/images/favicon.ico">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
    <link  href="/css/lumen.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>

    <#include "menu.ftl">
    <#nested>
    <script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="/js/intercooler-1.2.1.js"></script>
</body>
</html>

</#macro>
