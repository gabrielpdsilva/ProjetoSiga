<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lancar Notas</title>
</head>
<body>
<div>
    <jsp:include page="menu.jsp" />
    <br />
</div>
<div>
    <form action="lancar-faltas" method="post">
        <c:if test="${not empty listaDeDisciplinas }">
            <select name="disciplinas">
                <c:forEach items="${listaDeDisciplinas}" var="disciplina">
                    <option value="${disciplina.codigo}">${disciplina.nome} (${disciplina.turno})</option>
                </c:forEach>
            </select>
        </c:if>
        <input type="submit" value="FFF" id="button" name="button"/>
    </form>
</div>

<div>
    <c:if test="${not empty erro }">
        <h2 style="color: red"><c:out value="${erro }" /></h2>
    </c:if>
</div>
</body>
</html>