<h1><center> From GetValues.jsp</center></h1>
<!-- Locate Bean class obj -->
<jsp:useBean id="st"  class="com.nt.bean.StudentBean" scope="session"/>

<!--  Read and display bean property values -->
sno= <jsp:getProperty name="st" property="sno"/><br>
sname= <jsp:getProperty name="st" property="sname"/><br>
Result= <jsp:getProperty name="st" property="result"/><br>



<br>
<h1> Bean values retrieved and displayed</h1>


