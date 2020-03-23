<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>添加学生</title>
    </head>
    <body>
        <h1 style="text-align: center;">
            添加学生
        </h1>

        <form align="center" action="${pageContext.request.contextPath}/teacher/add_student" method="post">
            <table align="center" cellpadding="10">
                <tr>
                    <th>
                        学号
                    </th>
                    <td>
                        <label>
                            <input type="number" name="id" maxlength="9" required>
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>
                        姓名
                    </th>
                    <td>
                        <label>
                            <input type="text" name="name" required>
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
