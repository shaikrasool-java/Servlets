
<%! public String generateWishMsg(String uname){
         java.util.Calendar calendar=null;
         int hour=0;
          int a=10;
           int square=a*a;
           /* System.out.println("sqaure "+square); */
          // get System date
          calendar=java.util.Calendar.getInstance();
          //get current hour of the day
          hour=calendar.get(java.util.Calendar.HOUR_OF_DAY);
          if(hour<=12)
            return "Good Morning"+uname;
          else if(hour<=16)
           return "Good AfterNoon"+uname;
           else if(hour<=20)
             return "Good Evening "+uname;
            else
             return "Good Ninght"+uname;
            }
            %>
          <!--  <h1><center> Welcome to Jsp</center></h1> -->
          <br>
           Date and Time : <%=new java.util.Date() %> <br>
           <%String user="raja"; %>
           <br><br> 
           Wish Message :::   <%--  <%=generateWishMsg(user) %> --%>  
          
          
          