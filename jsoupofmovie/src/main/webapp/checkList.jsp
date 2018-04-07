<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/6 0006
  Time: 下午 2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge" >
    <title>Document</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h1 align="center">世界前250名电影查询表</h1>
    <form action="MovieServlet" method="post" name="f" >
        <div class="form-group row">
            <input type="text" name="id" placeholder="排名" class="form-control col-sm-4">
            <input type="text" name="title" placeholder="名字" class="form-control col-sm-4">
            <input type="text" name="member" placeholder="主演" class="form-control col-sm-4">
            <button type="submit" class="btn btn-primary">查询</button>
        </div>
    </form>

    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <td align="center"><b>排名</b></td>
                <td align="center"><b>剧照</b></td>
                <td align="center"><b>名字</b></td>
                <td align="center"><b>评分</b></td>
                <td align="center"><b>描述</b></td>
                <td align="center"><b>演员</b></td>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="movie" items="${listMovie}">
        <tr>
            <td align="center">${movie.id}</td>
            <td><img src="${movie.path}" hight="100" width="100"></td>
            <td>${movie.title}</td>
            <td>${movie.rank}</td>
            <td>${movie.miaoshu}</td>
            <td>${movie.member}</td>
        </tr>
        </c:forEach>
        </tbody>

    </table>


</div>

</body>
</html>
