<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="wifi.info.dto.WifiInfo" %>

<%@ page import="wifi.info.service.WifiInfoService" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%
Boolean initialized = null;

  if(request.getSession().getAttribute("init") == null) {
    initialized = false;
    System.out.println("init first");
  } else {
    initialized = (Boolean)request.getSession().getAttribute("init");
  }
%>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="index.css">
  <title>Public Wifi Information</title>
  <style>
    td {
      font-size: 8px;
      text-align: center;
    }
  </style>
</head>

<body>
  <h1>와이파이 정보 구하기</h1>

  <div>
    <form action="/Controller">
      <label for="LAT">LAT:</label>
      <input type="text" id="input-text-lat" name="LAT" value="${locationInfo.lat}"/>
      <label for="LNT">LNT:</label>
      <input type="text" id="input-text-lnt" name="LNT" value="${locationInfo.lnt}"/>
      <button type="submit" class="btn get-location-btn"  name="getMyLocationButton">내 위치 가져오기</button>
      <button type="submit" class="btn get-location-history-btn"  name="getLocationHistoryButton">위치 히스토리 조회</button>
      <button type="submit" class="btn get-wifi-info-btn" name="showNearWifiInfoButton">근처 WIFI 정보 보기</button>
      <button type="submit" class="btn get-wifi-info-btn"  name="getWifiInfoButton">Wifi 정보 가져오기</button>
    </form>
  </div>

  <table>
    <thead>
      <tr>
        <th>관리번호</th><th>자치구</th><th>와이파이명</th><th>도로명주소</th><th>상세주소</th><th>설치위치(층)</th><th>설치유형</th><th>설치기관</th><th>서비스구분</th><th>망종류</th><th>설치년도</th><th>실내외구분</th><th>WIFI접속환경</th><th>Y좌표</th><th>X좌표</th><th>작업일자</th>
      </tr>
    </thead>
    <tbody>

      <% if (!initialized) { %>

        <tr>
          <td colspan="16" id="table-message" style="text-align:center;">
            위치 정보를 입력한 후에 조회해 주세요
          </td>
        </tr>

      <% } else { %>

        <%
          WifiInfoService wifiInfoService = (WifiInfoService)request.getSession().getAttribute("wifiInfoService");
          List<WifiInfo> wifiInfoList = wifiInfoService.getWifiInfoList();
        %>
        <% for (WifiInfo e: wifiInfoList) { %>
          <tr>
            <td> <%= e.getX_SWIFI_MGR_NO() %> </td>
            <td> <%= e.getX_SWIFI_WRDOFC() %> </td>
            <td> <%= e.getX_SWIFI_MAIN_NM() %> </td>
            <td> <%= e.getX_SWIFI_ADRES1 () %> </td>
            <td> <%= e.getX_SWIFI_ADRES2() %> </td>
            <td> <%= e.getX_SWIFI_INSTL_FLOOR() %> </td>
            <td> <%= e.getX_SWIFI_INSTL_TY() %> </td>
            <td> <%= e.getX_SWIFI_INSTL_MBY() %> </td>
            <td> <%= e.getX_SWIFI_SVC_SE() %> </td>
            <td> <%= e.getX_SWIFI_CMCWR() %> </td>
            <td> <%= e.getX_SWIFI_CNSTC_YEAR() %> </td>
            <td> <%= e.getX_SWIFI_INOUT_DOOR() %> </td>
            <td> <%= e.getX_SWIFI_REMARS3() %> </td>
            <td> <%= e.getLAT() %> </td>
            <td> <%= e.getLNT() %> </td>
            <td> <%= e.getWORK_DTTM() %> </td>
          </tr>
        <% } %>
      <% } %>
    </tbody>
  </table>
</body>

</html>
