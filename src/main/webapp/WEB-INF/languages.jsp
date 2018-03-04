<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<table>
    <header>
        <th>Name</th>
        <th>Creator</th>
        <th>Version</th>
        <th>Action</th>
    </header>
    <tbody>
        <c:forEach items="${languages}" var="language" varStatus="loop">
            <tr>
                <td><a href="<c:url value="/languages/${language.id}"/>"><c:out value="${language.name}"/></a></td>
                <td><c:out value="${language.creator}"/></td>
                <td><c:out value="${language.version}"/></td>
                <td><a href="<c:url value="/languages/edit/${language.id}"/>">Edit</a> - <a href="<c:url value="/languages/delete/${language.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>


<form:form method="POST" action="/languages/new" modelAttribute="language">
    <fieldset>
        <legend>Create a Language:</legend>
        <form:label path="name">Name
            <form:errors path="name"/>
            <form:input path="name"/>
        </form:label>

        <form:label path="creator">Creator
            <form:errors path="creator"/>
            <form:input path="creator"/>
        </form:label>

        <form:label path="version">Version
            <form:errors path="version"/>
            <form:input path="version"/>
        </form:label>

        <input type="submit" value="Submit">

    </fieldset>
</form:form>


</html>