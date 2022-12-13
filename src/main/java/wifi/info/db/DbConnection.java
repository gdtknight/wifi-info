package wifi.info.db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
  private static final String dbDriver;
  private static final String url;
  private static final String user;
  private static final String password;
  private static final DbConnection dbConnection;

  static {
    URL resourceURL = null;
    FileReader resourceFile = null;
    Properties properties = new Properties();

    resourceURL = DbConnection.class.getClassLoader().getResource("db.properties");

    try {
      resourceFile = new FileReader(resourceURL.getPath());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
      properties.load(resourceFile);
    } catch (IOException e) {
      e.printStackTrace();
    }

    dbDriver = properties.getProperty("driver");
    url = properties.getProperty("url");
    user = properties.getProperty("username");
    password = properties.getProperty("password");

    // 1. DB Driver를 로딩
    try {
      Class.forName(dbDriver);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    dbConnection = new DbConnection();
  }

  public static DbConnection getInstance() {
    return dbConnection;
  }

  public Connection getConnection() throws SQLException {
    // 2. DB(MySQL)에 접속하기
    return DriverManager.getConnection(url, user, password);
  }

  public void close(AutoCloseable... closeables) {
    for (AutoCloseable c : closeables) {
      if (c != null) {
        try {
          c.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
