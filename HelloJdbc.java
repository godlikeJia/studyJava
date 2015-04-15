import java.sql.*;

public class HelloJdbc {
    private final String oracleDriverName = "oracle.jdbc.driver.OracleDriver";
    private final String oracleUrlToConnect ="jdbc:oracle:thin:@192.168.184.128:1521:orcl"; 
    private Connection myConnection = null;
    private final String loginName="scott";
    private final String loginPassword="oracle";
    
    public HelloJdbc()
    {
        try
        {
            Class.forName(oracleDriverName);
        }
        catch(ClassNotFoundException ex)
        {
            //System.out.println(getErrorMessage(ex,"The Driver loaded error,please contact to your Software Designer!").toString());
            System.out.println(ex.getMessage()+"\n"+ex.getStackTrace());
        }
    }
    
    public StringBuffer getErrorMessage(Exception ex,String alarmMessage)
    {
        StringBuffer errorStringBuffer = new StringBuffer();
        errorStringBuffer.append(alarmMessage);
        errorStringBuffer.append(ex.getMessage());
        return errorStringBuffer;
    }
    
    /**
     * getConnection method 
     * @return Connection
     */
    public Connection getConnection()
    {
        try
        {
            this.myConnection = DriverManager.getConnection(oracleUrlToConnect,loginName,loginPassword);
            //System.out.print("connection successfully");
        }
        catch(Exception ex)
        {
            //System.out.println(getErrorMessage(ex,"Can not get connection,please contact to your Software Designer!").toString());
            System.out.println(ex.getMessage()+"\n"+ex.getStackTrace());
            System.out.println("Here");
        }
        
        return this.myConnection;
        
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
     HelloJdbc he = new HelloJdbc();
        try
        {
            Connection conn = he.getConnection();
            Statement stmt = conn.createStatement() ;
            ResultSet rs =stmt.executeQuery("select loc from dept where rownum<=5");
            while(rs.next())
            {
                System.out.println(rs.getString(1));                
            }
            //System.out.println("Now begin to excute.............");
            if(rs != null){   
                try{   
                    rs.close() ;   
                }catch(SQLException e){   
                    e.printStackTrace() ;   
                }   
                }   
                  if(stmt != null){   
                try{   
                    stmt.close() ;   
                }catch(SQLException e){   
                    e.printStackTrace() ;   
                }   
                  }   
                  if(conn != null){  
                 try{   
                    conn.close() ;   
                 }catch(SQLException e){   
                    e.printStackTrace() ;   
                 }   
               }
        }
        catch(Exception ex)
        {
            System.out.println(he.getErrorMessage(ex,"Application error,please contact to your Software Designer!").toString());
        }        
    }
}
