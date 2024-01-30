package lt.codeacademy.eshop;

public final class HttpEndpoints {

  public static final String PUBLIC_WORKSPACE = "/public";
  public static final String PRIVATE_WORKSPACE = "/private";
  public static final String PRODUCTS = "/products";
  public static final String PRODUCT_LIST = PUBLIC_WORKSPACE + "/products";
  public static final String PRODUCTS_CREATE = PRIVATE_WORKSPACE + PRODUCTS + "/create";
  public static final String PRODUCTS_UPDATE = PRIVATE_WORKSPACE + PRODUCTS + "/{productId}/update";
  public static final String PRODUCTS_DELETE = PRIVATE_WORKSPACE + PRODUCTS + "/{productId}/delete";

  public static final String CART = PUBLIC_WORKSPACE + "/cart";

  public static final String USER_REGISTRATION = PUBLIC_WORKSPACE + "/users";
  public static final String USER_CREATE = USER_REGISTRATION + "/create";
}
