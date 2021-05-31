
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Hello jsp</title>

</head>
<body>
<table>
    <thead>
    <tr>
        <th>team</th>
        <th>goals</th>
    </tr>
    </thead>
    <tbody>
         <c:forEach items="${map}" var="list">
            <tr>
               <td> ${list.key} <br/> </td>
               <td> ${list.value} <br/> </td>
            </tr>
         </c:forEach>
    </tbody>
</table>

</body>
</html>

