<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>操作结果</title>
    </head>
    <body>
        <h1 style="text-align: center">
            <%
                String info = (String) request.getAttribute("info");
                out.print(info);
            %>
        </h1>
        <div style="text-align:center">
            <input type="button" name="close" value="关闭" onclick="window.close();"/>
        </div>
    </body>
</html>
