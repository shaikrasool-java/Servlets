<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--  create attr with  value in a scope -->
<c:set var="msg" value="hello" scope="request"/>
<!-- display value -->
Message : <c:out value="${msg}"/>
<!-- Remove attr with value  -->
<c:remove var="msg"  scope="request"/>
<!-- display value -->
Message : <c:out value="${msg}"/>

