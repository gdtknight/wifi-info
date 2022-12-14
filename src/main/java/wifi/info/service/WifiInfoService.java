package wifi.info.service;

import java.util.ArrayList;
import java.util.List;

import wifi.info.dto.WifiInfo;

public class WifiInfoService {
  static WifiInfoService wifiInfoService = new WifiInfoService();
  List<WifiInfo> wifiInfoList;

  private WifiInfoService() {
    wifiInfoList = new ArrayList<>();
  }

  public static WifiInfoService getInstance() {
    return wifiInfoService;
  }

  public List<WifiInfo> getWifiInfoList() {
    return wifiInfoList;
  }

  public void loadWifiInfo() {
    int rowsPerRequests = 1000;
    int totalRows = OpenApiService.getTbPublicWifiObj(1, 1).getTbPublicWifiInfo().getList_total_count();
    int totalRequests = (totalRows - 1) / rowsPerRequests + 1;

    int startIdx = 0;
    int endIdx = 0;

    for (int requestIdx = 1; requestIdx <= totalRequests; requestIdx++) {
      startIdx = (requestIdx - 1) * rowsPerRequests + 1;
      endIdx = requestIdx == totalRequests
          ? totalRows
          : requestIdx * rowsPerRequests;

      List<WifiInfo> list = OpenApiService.getTbPublicWifiObj(startIdx, endIdx)
          .getTbPublicWifiInfo()
          .getRow();
      wifiInfoList.addAll(list);
    }

  }
}
