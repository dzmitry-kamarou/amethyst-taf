package api.service;

import io.restassured.response.Response;

public class AccountsService extends BaseApiService {

  // TODO: change endpoint name after AMET-1 done
  private static final String ACCOUNTS_ENDPOINT = "/users";

  public Response getAccount(String email) {
    logger.info("GET ACCOUNT");
    return amethystSpecification()
        .basePath(ACCOUNTS_ENDPOINT)
        .queryParam("email", email)
        .when()
        .get();
  }

  public Response deleteAccount(String objectId) {
    logger.info("DELETE ACCOUNT");
    return amethystSpecification()
        .basePath(ACCOUNTS_ENDPOINT)
        .pathParam("objectId", objectId)
        .when()
        .delete("/{objectId}");
  }
}
