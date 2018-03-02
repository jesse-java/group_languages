<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<table>
    <header>
        <th>Name</th>
        <th>Creator</th>
        <th>Version</th>
        <th>Action</th>
    </header>
    <tbody>
        <c:forEach items="${languages}" var="language">
            <tr>
                <td><c:out value="${language.name}"/></td>
                <td><c:out value="${language.creator}"/></td>
                <td><c:out value="${language.version}"/></td>
                <td>Edit - Delete</td>
            </tr>
        </c:forEach>
    </tbody>
</table>


<form action="">
    <fieldset>
        <legend>Create New Language:</legend>

    </fieldset>
</form>
</html>