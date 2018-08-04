<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

 <c:set var="wishMsg"  value="hello how are u?" scope="request"/>
 
 <c:forTokens  var="msg"  items="${wishMsg}"  delims=" ">
    <c:out value="${msg}"/> <br>
 </c:forTokens>