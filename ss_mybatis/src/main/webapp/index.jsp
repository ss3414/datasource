<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <td><a href="/user">User</a></td>
    </tr>
    <tr>
        <td><a href="/userPage">UserPage</a></td>
    </tr>
    <tr>
        <td><a href="/druid/index.html">Druid监控</a></td>
    </tr>
</table>

<!--************************************************************分割线************************************************************-->

<!-- todo Test1Mapper -->
<table border="1">
    <tr>
        <td><a href="/mybatis/index">CURD</a></td>
    </tr>
    <tr>
        <td><a href="/mybatis/sql">动态SQL</a></td>
    </tr>
</table>

<!-- todo Test2Mapper -->
<table border="1">
    <tr>
        <td><a href="/mybatis/boxing">包装器类</a></td>
    </tr>
    <tr>
        <td><a href="/mybatis/param">传入参数</a></td>
    </tr>
    <tr>
        <td><a href="/mybatis/time">varchar型时间</a></td>
    </tr>
    <tr>
        <td><a href="/mybatis/escape">MyBatis转义符</a></td>
    </tr>
    <tr>
        <td><a href="/mybatis/count">select count返回值</a></td>
    </tr>
</table>

</body>
</html>
