package lt.codeacademy.eshop.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.IOException;

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
