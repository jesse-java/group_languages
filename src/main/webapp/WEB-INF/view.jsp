<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<a href="<c:url value="/languages/edit/${language.id}"/>">Edit</a>
<a href="<c:url value="/"/>">Dashboard</a>
<p><c:out value="${language.name}"/></p>
<p><c:out value="${language.creator}"/></p>
<p><c:out value="${language.version}"/></p>
</html>