import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

public class mySQL_demo {
     public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dct119c1";
        String username = "root";
        String password = "";

        try
        {
            Connection conn = null;
            conn = DriverManager.getConnection(url, username, password);

            Statement st =  conn.createStatement();

            ResultSet rs = st.executeQuery("select* from user");

            while (rs.next())
            {
                System.out.println(rs.getString(1) +" | " + rs.getString(2));
            }

            conn.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
