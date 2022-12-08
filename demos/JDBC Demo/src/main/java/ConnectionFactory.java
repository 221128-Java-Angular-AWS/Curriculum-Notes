import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static Connection connection;

    private ConnectionFactory() {
        //nothing here, just exists to stop the default constructor
    }

//jdbc:postgresql://hostname:port/databaseName
//postgres://YourUserName:YourPassword@YourHostname:5432/YourDatabaseName
// jdbc:postgresql://host:port/dbname?user=postgres&password=postgres

    public static Connection getConnection() {
        if(connection == null) {
            connection = connect();
        }
        return connection;
    }


    private static Connection connect() {
        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = loader.getResourceAsStream("jdbc.properties");


        try {
            props.load(inputStream);

            StringBuilder builder = new StringBuilder();
            builder.append("jdbc:postgresql://");
            builder.append(props.getProperty("host"));
            builder.append(":");
            builder.append(props.getProperty("port"));
            builder.append("/");
            builder.append(props.getProperty("dbname"));
            builder.append("?user=");
            builder.append(props.getProperty("username"));
            builder.append("&password=");
            builder.append(props.getProperty("password"));

            Class.forName(props.getProperty("driver"));

            connection = DriverManager.getConnection(builder.toString());



        } catch(IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }


}
