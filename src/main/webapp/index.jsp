<html>
<head>
<title>take-away</title>
</head>
<body>
</body>
<script>
    function getContextPath() {
        var fullPath = window.location.pathname;
        var contextPath = fullPath.split("/")[1];
        return contextPath;
    }
    window.location.href = "/" + getContextPath() + "/main";
</script>
<body>

</body>
</html>