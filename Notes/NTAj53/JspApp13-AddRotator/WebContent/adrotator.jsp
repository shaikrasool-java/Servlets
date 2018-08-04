
<%@page import="com.nt.bean.Rotator"%>

<!--  create or locate java bean -->
<jsp:useBean id="rotator"  class="com.nt.bean.Rotator"  scope="session"/>

<% rotator.nextAdvertisement();
      response.setHeader("refresh","2"); %>
  <!-- display add... -->
  
  <a href="<jsp:getProperty name="rotator" property="link"/>">
   <img src="<jsp:getProperty name="rotator" property="image"/>" width="400" heigh="300"/>
</a>
      
      