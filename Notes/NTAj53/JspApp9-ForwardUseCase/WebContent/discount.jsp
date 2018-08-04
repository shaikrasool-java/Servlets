
<% //read billAmt from bill.jsp 
   int billAmt=Integer.parseInt(request.getParameter("bAmt"));
   //calc discount amout
   float discount=billAmt*0.3f;
   float finalAmt=billAmt-discount; %>
   Item name :  <%=request.getParameter("name") %> <br>
   Bill Amount : <%=billAmt %> <br>
   Discount Amount : <%=discount %> <br>
   Final  bill Amount : <%=finalAmt %>
    
   