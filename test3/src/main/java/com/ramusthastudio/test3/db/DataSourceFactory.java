package com.ramusthastudio.test3.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

public final class DataSourceFactory {
  private static DSLContext sDSLContext;

  private DataSourceFactory() { }

  public static DSLContext connect() {
    if (sDSLContext == null) {
      try {
        Properties props = new Properties();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.cfg");
        props.load(is);

        String url = props.getProperty("dataSource.url");
        String dbName = props.getProperty("dataSource.databaseName");
        String user = props.getProperty("dataSource.user");
        String pass = props.getProperty("dataSource.password");

        Class.forName(props.getProperty("dataSourceClassName")).newInstance();
        Connection connection = DriverManager.getConnection(url, user, pass);
        sDSLContext = DSL.using(connection, SQLDialect.MYSQL, new Settings());

      } catch (IOException | IllegalAccessException | SQLException | InstantiationException | ClassNotFoundException aE) {
        aE.printStackTrace();
      }
    }

    return sDSLContext;
  }

  public static void disconnect() throws Exception {
    if (sDSLContext != null) {
      sDSLContext.close();
    }
  }
}