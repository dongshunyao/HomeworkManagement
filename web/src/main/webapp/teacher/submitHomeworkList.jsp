<%@ page import="java.util.List" %>
<%@ page import="com.hwm.model.SubmitHomework" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>作业提交详情</title>
    </head>
    <body>
        <h1 style="text-align: center;">
            作业提交详情
        </h1>
        <%
            List<SubmitHomework> list = (List<SubmitHomework>) request.getAttribute("list");
            if (list == null || list.isEmpty()) {
        %>
        <h2 style="text-align: center;">
            作业提交列表为空
        </h2>
        <%
        } else {
        %>
        <table align="center" cellpadding="8" style="text-align: center; width: 1024px;">
            <tr style="background-color: lightblue;">
                <th>ID</th>
                <th>学号</th>
                <th>作业编号</th>
                <th>提交作业标题</th>
                <th>提交作业内容</th>
                <th>创建时间</th>
            </tr>
            <%
                for (SubmitHomework submitHomework : list) {
            %>
            <tr style="background-color: lightgrey">
                <td>
                    <%=submitHomework.getId()%>
                </td>
                <td>
                    <%=submitHomework.getStudentId()%>
                </td>
                <td>
                    <%=submitHomework.getHomeworkId()%>
                </td>
                <td>
                    <%=submitHomework.getHomeworkTitle()%>
                </td>
                <td>
                    <%=submitHomework.getHomeworkContent()%>
                </td>
                <td>
                    <%=submitHomework.getCreateTime()%>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </body>
</html>
