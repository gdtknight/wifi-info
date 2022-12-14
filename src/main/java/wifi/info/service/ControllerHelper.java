package wifi.info.service;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerHelper extends BaseHelper {
  protected WifiInfoService wifiInfoService;

  ControllerHelper(
      HttpServlet httpServlet,
      HttpServletRequest request,
      HttpServletResponse response) {

    super(httpServlet, request, response);
    wifiInfoService = WifiInfoService.getInstance();
  }

  public Object getWifiInfoService() {
    return wifiInfoService;
  }

  public void doGet() throws IOException, ServletException {
    Boolean initialized = (Boolean) request.getSession().getAttribute("init");
    if (request.getParameter("getMyLocationButton") != null) {

    } else if (request.getParameter("getLocationHistoryButton") != null) {

    } else if (request.getParameter("showNearWifiInfoButton") != null) {

    } else if (request.getParameter("getWifiInfoButton") != null) {
      if (initialized == null || !initialized) {
        initialized = true;
        request.getSession().setAttribute("init", initialized);
        wifiInfoService.loadWifiInfo();
      }

      request.getSession().setAttribute("wifiInfoService", wifiInfoService);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/load-wifi.jsp");
      requestDispatcher.forward(request, response);
    }
  }

}
