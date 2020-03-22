<%@ page import="java.util.List" %>
<%@ page import="com.hwm.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>学生列表</title>
    </head>
    <body>
        <h1 style="text-align: center;">
            学生列表
        </h1>
        <%
            List<Student> list = (List<Student>) request.getAttribute("list");
            if (list == null || list.isEmpty()) {
        %>
        <h2 style="text-align: center;">
            学生列表为空
        </h2>
        <%
        } else {
        %>
        <table align="center" cellpadding="8" style="text-align: center; width: 1024px;">
            <tr style="background-color: lightblue;">
                <th>学号</th>
                <th>姓名</th>
                <th>添加时间</th>
            </tr>
            <%
                for (Student student : list) {
            %>
            <tr style="background-color: lightgrey">
                <td>
                    <%=student.getId()%>
                </td>
                <td>
                    <%=student.getName()%>
                </td>
                <td>
                    <%=student.getCreateTime()%>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
        <h2 style="text-align: center;">
            <a href="addStudent.jsp">
                添加学生
            </a>
        </h2>
    </body>
</html>
