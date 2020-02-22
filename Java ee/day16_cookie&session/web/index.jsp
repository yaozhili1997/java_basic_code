<%--
  Created by IntelliJ IDEA.
  User: yaozhili
  Date: 2020/1/28
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <%
      System.out.println("hello jsp");
      String contextPath = request.getContextPath();
      out.print(contextPath);
    %>
  <h1>hi~jsp</h1>
  </body>
</html>
