<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="wifi.info.dto.WifiInfo" %>

<%@ page import="wifi.info.service.WifiInfoService" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="index.css">
  <title>Public Wifi Information</title>
</head>

<body>
  <%
    WifiInfoService wifiInfoService  = (WifiInfoService)request.getSession().getAttribute("wifiInfoService");
    List<WifiInfo> wifiInfoList = wifiInfoService.getWifiInfoList();
  %>

  <h1><%= wifiInfoList.size() %> 개의 공공와이파이 정보를 불러왔습니다.</h1>
  <a href="index.jsp"> 홈으로 돌아가기 </a>
</body>

</html>
