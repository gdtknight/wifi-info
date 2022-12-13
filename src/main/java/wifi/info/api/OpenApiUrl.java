package wifi.info.api;

public class OpenApiUrl {
  private final String baseURL;
  private static OpenApiUrl openApiUrl = new OpenApiUrl();

  private OpenApiUrl() {
    baseURL = "http://openapi.seoul.go.kr:8088/" + OpenApiKey.getInstance().getKey() + "/json/TbPublicWifiInfo/";
  }

  public static OpenApiUrl getInstance() {
    return openApiUrl;
  }

  public String getBaseUrl() {
    return baseURL;
  }

  public String getOpenApiRequestUrl(int startIdx, int endIdx) {
    return getBaseUrl() + startIdx + "/" + endIdx + "/";
  }
}
