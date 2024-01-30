package lt.codeacademy.eshop.filter;

import java.io.IOException;

import jakarta.servlet.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MyEshopFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    log.trace("-----> my eshop filter implementation :::before::: do filter chain. Any logic with servletRequest");

    filterChain.doFilter(servletRequest, servletResponse);

    log.trace("-----> my eshop filter implementation :::after::: do filter chain. Any logic with servletResponse");
  }
}
