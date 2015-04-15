import java.sql.*;

public class FirstJdbc {

    public static void main(String[] args) {
        String sql = "select deptno, loc from dept";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try { 
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.184.128:1521:orcl", "scott","oracle");
            //con = DriverManager.getConnection("jdbc:oracle:thin:@scott_vm:orcl", "scott","oracle");
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()) {
                System.out.println(rs.getString("loc") + "    " + rs.getInt("deptno"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch(Exception e) {

            }

            try {
                st.close(); 
            } catch(Exception e) {

            }

            try {
                rs.close();
            } catch(Exception e) {

            }
        }

    }
}
