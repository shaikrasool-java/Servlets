
<table border="0" width="100%"  height="100%"  rows="3" cols="2">
  <tr height="20%" width="100%">
     <td colspan="2"> <jsp:include page="/headurl" flush="true"/> </td>
  </tr>
  <tr height="70%" width="100%">
     <td  width="30%"> <jsp:include page="left_content.jsp" flush="true"/> </td>
      <td  width="70%"> <jsp:include page="wheather.jsp" flush="true"/> </td>
  </tr>
  <tr height="10%" width="100%">
     <td colspan="2"> <%@include  file="footer.html" %> </td>
  </tr>
</table>