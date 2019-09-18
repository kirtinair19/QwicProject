package com.qwic.buyacar.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class readConfigProperties {

  private static Properties prop;

  /**
   * Reads the config.properties file
   */
  public static Properties getProperties() {
    try {
      InputStream input = new FileInputStream("src/test/resources/config.properties");
      prop = new Properties();
      prop.load(input);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return prop;
  }

}
