package ro.sdacademy.javaremote12;

import java.util.TimeZone;

public class DataBaseUtils {

    public static final String DB_URL = "jdbc:mysql://localhost:3309/yellow_team?serverTimezone= "+ TimeZone.getDefault().getID();
    public static final String DB_USER  = "root";
    public static final String DB_PASSWORD = "root";
    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_DIALECT = "org.hibernate.dialect.MySQL8Dialect";

}
