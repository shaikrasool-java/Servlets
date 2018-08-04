
<h1><center> From B.jsp </center></h1> 
<br>
attr1(pageScope) attribute value= <%=pageContext.findAttribute("attr1") %> <br>
attr2(requestScope) attribute value= <%=pageContext.findAttribute("attr2") %> <br>
attr3(sessionScope) attribute value= <%=pageContext.findAttribute("attr3") %> <br>
attr4(applicationScope) attribute value= <%=pageContext.findAttribute("attr4") %> <br>
<!-- forward request to C.jsp -->
<jsp:forward page="C.jsp" />