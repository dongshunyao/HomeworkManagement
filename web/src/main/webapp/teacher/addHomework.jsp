<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>添加作业</title>
    </head>
    <body>
        <h1 style="text-align: center;">
            添加作业
        </h1>

        <form align="center" action="${pageContext.request.contextPath}/teacher/add_homework" method="post">
            <table align="center" cellpadding="10">
                <tr>
                    <th>
                        作业标题
                    </th>
                    <td>
                        <label>
                            <input type="text" name="title" style="width:500px;" required>
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>
                        作业内容
                    </th>
                    <td>
                        <label>
                            <textarea name="content" rows="12" style="width:500px;" required></textarea>
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
