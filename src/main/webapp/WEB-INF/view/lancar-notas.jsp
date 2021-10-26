<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lancar Notas</title>
</head>
<body>
<div>
    <form action="lancar-notas" method="post">
        <table>
            <tr>
                <td><input type="text" id="raAluno" name="raAluno" min="0" placeholder="RA" required="required"></td>
            </tr>
            <tr>
                <td colspan="1"><input type="submit" value="Buscar" id="button" name="button"></td>
            </tr>
        </table>
        <br /><br />

    </form>
</div>
<div>
    <c:if test="${not empty erro }">
        <h2 style="color: red"><c:out value="${erro }" /></h2>
    </c:if>
</div>
</body>
</html>