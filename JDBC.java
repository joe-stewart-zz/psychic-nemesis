import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/Users/joe/JAVA/testdb.sqlt");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer, name string)");
            statement.executeUpdate("insert into person values(1, 'joe')");
            statement.executeUpdate("insert into person values(2, 'row')");
            ResultSet rs = statement.executeQuery("select * from person");
            while(rs.next()) {
                System.out.print("id = " + rs.getInt("id") + " ");
                System.out.println("name = " + rs.getString("name"));
            }
        } catch(SQLException e) {
                e.printStackTrace();
        } finally {
            try {
                statement.close();
                if(connection != null)
                    connection.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
