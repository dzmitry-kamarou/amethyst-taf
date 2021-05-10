package api.service;

import static api.AmethystApiRequestSpecification.getRequestSpecification;
import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseApiService {

  protected static final Logger logger = LoggerFactory.getLogger(BaseApiService.class);

  protected RequestSpecification amethystSpecification() {
    return given().spec(getRequestSpecification());
  }
}
