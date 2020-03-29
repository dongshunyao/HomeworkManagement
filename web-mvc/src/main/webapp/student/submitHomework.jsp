<%@ page import="com.hwm.model.Homework" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>提交作业</title>
    </head>
    <body>
        <h1 style="text-align: center;">
            提交作业
        </h1>
        <%
            Homework homework = (Homework) request.getAttribute("homework");
        %>
        <form align="center" action="submit_homework" method="post">
            <table align="center" cellpadding="10" style="text-align: center;">
                <tr>
                    <th>
                        ID
                    </th>
                    <td>
                        <%=homework.getId()%>
                    </td>
                </tr>
                <tr>
                    <th>
                        标题
                    </th>
                    <td>
                        <%=homework.getTitle()%>
                    </td>
                </tr>
                <tr>
                    <th>
                        内容
                    </th>
                    <td>
                        <%=homework.getContent()%>
                    </td>
                </tr>
                <tr>
                    <th>
                        学号
                    </th>
                    <td>
                        <label>
                            <input type="number" name="studentId" maxlength="9" style="width:500px;" required>
                        </label>
                    </td>
                </tr>
                <input type="hidden" name="homeworkId" value="<%=homework.getId()%>">
                <tr>
                    <th>
                        作业标题
                    </th>
                    <td>
                        <label>
                            <input type="text" name="homeworkTitle" style="width:500px;" required>
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>
                        作业内容
                    </th>
                    <td>
                        <label>
                            <textarea name="homeworkContent" rows="12" style="width:500px;" required></textarea>
                        </label>
                    </td>
                </tr>
            </table>
            <br>
            <input align="center" type="submit" value="提交">
            <br><br>
            <input align="center" type="reset" value="重置">
        </form>
    </body>
</html>
