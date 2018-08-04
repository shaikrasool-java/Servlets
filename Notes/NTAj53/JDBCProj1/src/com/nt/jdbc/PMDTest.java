package com.nt.jdbc;
import java.sql.*;

public class PMDTest {

    public static void main(java.lang.String[] args) throws Exception
    {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");

		PreparedStatement ps =
				con.prepareStatement("insert into student values(?, ?, ?)");
       
		ParameterMetaData pmd=ps.getParameterMetaData();
	
		System.out.println("pmd obj class name is "+pmd.getClass());

         int cnt=pmd.getParameterCount();

        for (int i =1; i<=cnt; i++) {
            System.out.println("Parameter number " + i);
          
              System.out.println("  Mode is " + pmd.getParameterMode(i));
            System.out.println("  Type is " + pmd.getParameterType(i));
            System.out.println("  Type name is " + pmd.getParameterTypeName(i));
            System.out.println("  Precision is " + pmd.getPrecision(i));
            System.out.println("  Scale is " + pmd.getScale(i));
            System.out.println("  Nullable? is " + pmd.isNullable(i));
            System.out.println("  Signed? is " + pmd.isSigned(i));
        }//for
    }//main
}//class