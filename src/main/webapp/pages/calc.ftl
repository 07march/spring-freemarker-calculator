<html>
<head>
    <title>Calc</title>
</head>
<body>
<form action="/calc" method="post">
    <input type="number" name="num1" placeholder="enter num1">
    <input type="number" name="num2" placeholder="enter num2">
    <select name="operation">
        <option name="sum" value="sum">+</option>
        <option name="sub" value="sub">-</option>
        <option name="mul" value="mul">*</option>
        <option name="div" value="div">/</option>
    </select>
    <button>Ok</button>
</form>

<#if resultFlag>
    ${result}
<#else>
    ${message}
</#if>

</body>
</html>