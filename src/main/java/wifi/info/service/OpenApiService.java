package wifi.info.service;

import java.io.IOException;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import wifi.info.api.OpenApiUrl;
import wifi.info.dto.TbPublicWifi;

public class OpenApiService {
  public static TbPublicWifi getTbPublicWifiObj(int startIdx, int endIdx) {
    TbPublicWifi tbPublicWifi = null;
    String requestUrl = OpenApiUrl.getInstance().getOpenApiRequestUrl(startIdx, endIdx);

    OkHttpClient client = new OkHttpClient();
    Moshi moshi = new Moshi.Builder().build();
    JsonAdapter<TbPublicWifi> tbPublicWifiJsonAdapter = moshi.adapter(TbPublicWifi.class);

    Request request = new Request.Builder()
        .url(requestUrl)
        .build();

    try (Response response = client.newCall(request).execute()) {
      tbPublicWifi = tbPublicWifiJsonAdapter.fromJson(response.body().source());

    } catch (IOException e) {
      e.printStackTrace();
    }

    return tbPublicWifi;
  }
}
