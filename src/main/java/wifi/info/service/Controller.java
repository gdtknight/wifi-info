package wifi.info.service;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
  private boolean isLoaded = false;

  @Override
  protected void doGet(
      HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    ControllerHelper controllerHelper = new ControllerHelper(this, request, response);

    if (!isLoaded) {
      controllerHelper.loadWifiInfo();
    }

    controllerHelper.doGet();
  }
}
