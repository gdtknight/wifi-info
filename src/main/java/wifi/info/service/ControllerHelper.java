package wifi.info.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wifi.info.db.DbConnection;
import wifi.info.dto.WifiInfo;

public class ControllerHelper extends BaseHelper {
  protected List<WifiInfo> wifiInfoList;

  ControllerHelper(
      HttpServlet httpServlet,
      HttpServletRequest request,
      HttpServletResponse response) {

    super(httpServlet, request, response);
  }

  public void loadWifiInfo() {
    DbConnection dbConnection = DbConnection.getInstance();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = dbConnection.getConnection();

      String loadWifiInfoSql = "SELECT * FROM PublicWifiInfo;";
      preparedStatement = connection.prepareStatement(loadWifiInfoSql);

      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        WifiInfo wifiInfo = new WifiInfo(
            rs.getString("X_SWIFI_MGR_NO"),
            rs.getString("X_SWIFI_WRDOFC"),
            rs.getString("X_SWIFI_MAIN_NM"),
            rs.getString("X_SWIFI_ADRES1"),
            rs.getString("X_SWIFI_ADRES2"),
            rs.getString("X_SWIFI_INSTL_FLOOR"),
            rs.getString("X_SWIFI_INSTL_TY"),
            rs.getString("X_SWIFI_INSTL_MBY"),
            rs.getString("X_SWIFI_SVC_SE"),
            rs.getString("X_SWIFI_CMCWR"),
            rs.getString("X_SWIFI_CNSTC_YEAR"),
            rs.getString("X_SWIFI_INOUT_DOOR"),
            rs.getString("X_SWIFI_REMARS3"),
            rs.getString("LAT"),
            rs.getString("LNT"),
            rs.getString("WORK_DTTM"));
        wifiInfoList.add(wifiInfo);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

      try {
        if (preparedStatement != null && !preparedStatement.isClosed()) {
          preparedStatement.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }

      try {
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  }

  public void doGet() throws IOException, ServletException {
    // if ("/load-wifi.jsp".equals(request.getRequestURI())) {

    // }
    // if (request.getParameter("getMyLocationButton") != null) {

    // } else if (request.getParameter("showNearWifiInfoButton") != null) {
    // request.setAttribute("wifiInfoList", wifiInfoList);
    // RequestDispatcher requestDispatcher =
    // request.getRequestDispatcher("index.jsp");
    // requestDispatcher.forward(request, response);
    // }

    // if (request.getRequestURI() == "/load_wifi.jsp") {
    // List<WifiInfo> wifiInfoList = null;
    // request.setAttribute("wifiInfoList", wifiInfoList);

    // RequestDispatcher requestDispatcher =
    // request.getRequestDispatcher("load_wifi.jsp");
    // requestDispatcher.forward(request, response);

    // } else if (request.getRequestURI() == "/history.jsp") {
    // List<HistoryInfo> historyInfoList = null;

    // request.setAttribute("historyInfoList", historyInfoList);

    // RequestDispatcher requestDispatcher =
    // request.getRequestDispatcher("history.jsp");
    // requestDispatcher.forward(request, response);
    // }

  }

}
