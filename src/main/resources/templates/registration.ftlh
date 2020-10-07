<!DOCTYPE html>
<html >
<head>
    <title>Spring Security Example </title>
</head>
<body>
Add new User
<#if message?has_content>
    ${message}
</#if>
<form action="/registration" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value=${_csrf.token} />
    <div><input type="submit" value="Registrate"/></div>
</form>
</body>
</html>