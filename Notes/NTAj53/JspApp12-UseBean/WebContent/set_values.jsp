

<h1><center> From SetValues.jsp</center></h1>

<jsp:useBean id="st"  class="com.nt.bean.StudentBean" scope="session"/>

<%-- <jsp:setProperty name="st" property="sno" value="101"/>
<jsp:setProperty name="st" property="sname" value="raja"/>
<jsp:setProperty name="st" property="result" value="pass"/>
 --%>
 <%-- <jsp:setProperty name="st"  property="sno" param="stno"/>
 <jsp:setProperty name="st"  property="sname" param="stname"/>
 <jsp:setProperty name="st"  property="result" param="stresult"/>
  --%>
   <jsp:setProperty name="st" property="*"/>
 
<h1><center> Values are added.....</center></h1>