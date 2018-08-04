
<%//read form data  
  String name=request.getParameter("name");
  int price =Integer.parseInt(request.getParameter("price"));
  int qty =Integer.parseInt(request.getParameter("qty"));
  //calc bill amount
  int billAmt=qty*price;
  if(billAmt>=50000){ %>
    <jsp:forward  page="discount.jsp">
      <jsp:param name="bAmt"  value="<%=billAmt%>"/>
    </jsp:forward> 
    <%}
      else{   %>
       Item name : <%=name %> <br>
       Bill Amount (with out discount):<%=billAmt%> <br>
      <%  } %>
        
     
  