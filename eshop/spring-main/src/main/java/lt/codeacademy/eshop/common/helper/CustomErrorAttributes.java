package lt.codeacademy.eshop.common.helper;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

  public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
    final Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
    errorAttributes.put("myCustomAttribute", "Custom Attribute");

    return errorAttributes;
  }
}
