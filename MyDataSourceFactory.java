import java.io.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MyDataSourceFactory {
    public static DataSource getMysqlDataSource() {
        Properties props = new Properties();
        MysqlDataSource ds = null;
        try(FileInputStream is = new FileInputStream("db.properties")) {
            props.load(is);
            ds = new MysqlDataSource();
            ds.setURL(props.getProperty("MYSQL_DB_URL"));
            ds.setUser(props.getProperty("MYSQL_DB_USERNAME"));
            ds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        return ds;
    }
}
