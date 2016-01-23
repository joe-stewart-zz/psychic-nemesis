import java.sql.*;

import javax.sql.DataSource;

public class DataSourceExample {
    public static void main(String[] args) {
        testDS();
    }
    private static void testDS() {
        DataSource ds = null;
        ds = MyDataSourceFactory.getMysqlDataSource();
        try(Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from test")) {
                while(rs.next())
                    System.out.println(rs.getString(2));
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
