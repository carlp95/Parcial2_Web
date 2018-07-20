<#macro base user>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${ title }</title>
    <link rel="icon" type="image/x-icon"  href="/images/favicon.ico">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link  href="https://bootswatch.com/4/darkly/bootstrap.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>

    <#nested>

    <script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="/js/chat.js"></script>

</body>
</html>

</#macro>
