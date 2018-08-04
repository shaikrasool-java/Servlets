
<%-- uname req param value  :  ${param.uname } <br>
address request param values : ${paramValues.addrs[0] },
                                                              ${paramValues.addrs[1] }. --%>
                                                              
<%--   user-agent req header value : ${header['user-agent']} <br>
 accept languages : ${headerValues.accept[0]}
 --%> 
  <%-- dbuser context param value :  ${initParam.dbuser }
   --%>
   <%-- Cookie name : ${cookie.JSESSIONID.name}
   cookie value :   ${cookie.JSESSIONID.value}
    --%>
    <%pageContext.setAttribute("attr1","val1",pageContext.PAGE_SCOPE); %>
    <%pageContext.setAttribute("attr2","val2",pageContext.REQUEST_SCOPE); %>
    <%pageContext.setAttribute("attr3","val3",pageContext.SESSION_SCOPE); %>
    <%pageContext.setAttribute("attr4","val4",pageContext.APPLICATION_SCOPE); %>
    <br><br>
    attr1 value : ${pageScope.attr1} <br>
    attr2 value : ${requestScope.attr2} <br>
    attr3 value : ${sessionScope.attr3} <br>
    attr4 value : ${applicationScope.attr4} <br>
    
    
    
    
    
    
    
   
                                                                