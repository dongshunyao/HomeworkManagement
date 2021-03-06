<%@ page import="java.util.List" %>
<%@ page import="com.hwm.model.Homework" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>查看作业列表</title>
    </head>

    <body>
        <h1 style="text-align: center;">
            作业列表
        </h1>
        <%
            List<Homework> list = (List<Homework>) request.getAttribute("list");
            if (list == null || list.isEmpty()) {
        %>
        <h2 style="text-align: center;">
            作业列表为空
        </h2>
        <%
        } else {
        %>
        <form id="homework" method="post" action="submit_homework_list">
            <table align="center" cellpadding="8" style="text-align: center; width: 1024px;">
                <input id="homeworkId" name="homeworkId" type="hidden">
                <tr style="background-color: lightblue;">
                    <th>ID</th>
                    <th>标题</th>
                    <th>内容</th>
                    <th>创建时间</th>
                    <th>已提交作业</th>
                </tr>
                <%
                    for (Homework homework : list) {
                %>
                <tr style="background-color: lightgrey">
                    <td>
                        <%=homework.getId()%>
                    </td>
                    <td>
                        <%=homework.getTitle()%>
                    </td>
                    <td>
                        <%=homework.getContent()%>
                    </td>
                    <td>
                        <%=homework.getCreateTime()%>
                    </td>
                    <td>
                        <input type="button" value="查看" onclick="showDetail(<%=homework.getId()%>)">
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </form>
        <h2 style="text-align: center;">
            <a href="addHomework.jsp">
                添加作业
            </a>
        </h2>
    </body>

    <script>
        function showDetail(id) {
            let homeworkId = document.getElementById('homeworkId');
            homeworkId.setAttribute("value", id);
            document.getElementById('homework').submit();
        }
    </script>
</html>
