<%--
  Created by IntelliJ IDEA.
  User: xiong
  Date: 2018/11/18
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%= request.getContextPath()%>/js/jquery.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath()%>/js/index.js"></script>
    <script>
        var baseDir = "<%=request.getContextPath()%>";
    </script>
</head>
<body>
<h1>Hello World!</h1>
<span>请上传头像：</span><input id="img" type="file">
<button id="submit">提交</button>
<button id="save_data">保存数据</button>
<button id="get_data">获取数据</button>
<button id="del_data">删除数据</button>
<div>
    <img id="show_img" src="">
</div>
</body>
</html>
