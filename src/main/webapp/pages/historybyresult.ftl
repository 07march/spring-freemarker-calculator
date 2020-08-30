<html>
<head>
    <title>History By Result</title>
</head>
<body>
<form action="/history/byResult" method="post">
    <input type="number" name="result" placeholder="enter result">
    <button>Find</button>
</form>
<#list result as s>
    <p>${s}</p>
</#list>
</body>
</html>