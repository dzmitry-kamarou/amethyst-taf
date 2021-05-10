package api;

import static java.util.Arrays.asList;

import api.filter.CustomCookieFilter;
import api.filter.CustomFilter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ui.AmethystConfig;

public class AmethystApiRequestSpecification {

  private static final ThreadLocal<RequestSpecification> THREAD_LOCAL_INSTANCE = new ThreadLocal<>();
  private static final AmethystConfig AMETHYST_CONFIG = AmethystConfig.config;
  private static final String URI = AMETHYST_CONFIG.uri();
  // TODO: change to /api after AMET-2 done
  private static final String API_ENDPOINT = "";

  public static synchronized RequestSpecification getRequestSpecification() {
    if (THREAD_LOCAL_INSTANCE.get() == null) {
      THREAD_LOCAL_INSTANCE.set(new RequestSpecBuilder()
          .setBaseUri(URI + API_ENDPOINT)
          .addFilters(asList(new CustomCookieFilter(), new CustomFilter()))
          .setContentType(ContentType.JSON)
          .setUrlEncodingEnabled(false)
          .build());
    }
    return THREAD_LOCAL_INSTANCE.get();
  }
}
