package wifi.info.service;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseHelper {
  protected HttpServlet httpServlet;
  protected HttpServletRequest request;
  protected HttpServletResponse response;
}
