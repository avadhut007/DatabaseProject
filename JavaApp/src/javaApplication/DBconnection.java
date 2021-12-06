package javaApplication;
import java.sql.*;
import javax.swing.*;


public class DBconnection {
	static Connection conn = null;
	public static Connection DBconnect()
	{
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 
		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;

		}

		System.out.println("Oracle JDBC Driver Registered!");
		
		try {
			 
            conn = DriverManager.getConnection("jdbc:oracle:thin:@acaddbprod-2.uta.edu:1523/pcse1p.data.uta.edu", "oxg7237", "Omkargawade96");
            System.out.println("You made it, take control of your database now!\n");
            
            return conn;
				} catch (SQLException e) {
					
					System.out.println("Connection Failed! Check output console");
					e.printStackTrace();
					return null;
			}
		
		
		/*
		if (conn != null) {
			System.out.println("You made it, take control of your database now!\n");
            //System.out.println("Printing employee names from the sharmac.employee table stored on omega");
		} else {
			System.out.println("Failed to make connection!");
		}
		
        try {
        	 String query = "select * from F21_S003_7_RestaurantBranch";
        	 System.out.println("line 46");
        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
        		 System.out.println("line 48");
                try (ResultSet result = pStatement.executeQuery()) {
                	 System.out.println("line 50");
                    while (result.next()) {
                    	 System.out.println("line 52");
                        System.out.println("Name: "+result.getString("name")+"   Phone: "+result.getString("location"));
                    }
                }
            }catch (SQLException e) {

                System.out.println("Error connecting to the DB - list");
                System.exit(1);
                e.printStackTrace();
            }
	       
	       
           conn.close();
        }
        catch (SQLException e) {
 
			System.out.println("erro in accessing the relation");
			e.printStackTrace();
			return conn;
 
		} 
        
        return conn;
        */

		
		}

}

	

