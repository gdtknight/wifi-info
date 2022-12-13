package wifi.info.api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import lombok.Getter;

@Getter
public class OpenApiKey {
  private final String key;

  private static final OpenApiKey openApiKey = new OpenApiKey();

  private OpenApiKey() {
    URL resourceURL = OpenApiKey.class.getClassLoader().getResource("api.properties");
    FileReader resourceFile = null;

    try {
      resourceFile = new FileReader(resourceURL.getPath());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    Properties properties = new Properties();

    try {
      properties.load(resourceFile);
    } catch (IOException e) {
      e.printStackTrace();
    }

    key = properties.getProperty("key");
  }

  public static OpenApiKey getInstance() {
    return openApiKey;
  }

  public String getKey() {
    return openApiKey.key;
  }
}
