<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<body>
<h1>Editing <c:out value="${language.name}"/></h1>

<form:form method="POST" action="/languages/edit/${language_id}" modelAttribute="language">
    <fieldset>
        <legend>Editing</legend>
        <form:label path="name">Name
            <form:errors path="name"/>
            <form:input path="name" value="${language.name}"/>
        </form:label>

        <form:label path="creator">Creator
            <form:errors path="creator"/>
            <form:input path="creator" value="${language.creator}"/>
        </form:label>

        <form:label path="version">Version
            <form:errors path="version"/>
            <form:input path="version" value="${language.version}"/>
        </form:label>

        <input type="submit" value="Submit">
    </fieldset>

</form:form>

<a href="<c:url value="/"/>">Dashboard</a>
</body>
</html>