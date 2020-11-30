<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <table border="1">
        <label>
            用户名：<input type="text" name="username" placeholder="用户名"><br/>
            密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" placeholder="密码"><br/>
            <input type="submit" value="登录">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
            ${requestScope.error}
         </label>
    </table>
</form>
</body>
</html>