<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>Registration</h1>
    <form:form modelAttribute="registration">
        <table>
            <tr>
                <spring:message code="name" />
                <td>
                    <form:input path="name" />
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Add Registration" />
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
