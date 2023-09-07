package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonResourceTest 
{
  @Test
  public void testPersonEndpoint() 
  {
    String requestBody = "{\"id\":\"1\",\"firstName\":\"Piet\",\"lastName\":\"Pompies\"}";

    given()
      .header("Content-type", "application/json")
      .header("Accept", "application/json")
      .and()
      .body(requestBody)
      .when()
        .post("/person")
      .then()
        .statusCode(200)
        .body(is("{\"code\":\"SUCCESS\",\"description\":\"Successfully processed1 Piet\"}"));
  }


  @Test
  public void testRestDslEndpoint() 
  {
    String requestBody = "{\"id\":\"1\",\"firstName\":\"Jan\",\"lastName\":\"Pompies\"}";

    given()
      .header("Content-type", "application/json")
      .header("Accept", "application/json")
      .and()
      .body(requestBody)
      .when()
        .post("/restdsl/person")
      .then()
        .statusCode(200)
        .body(is("{\"code\":\"SUCCESS\",\"description\":\"Successfully processed1 Jan\"}"));
  }

  @Test
  public void testXmlDslEndpoint() 
  {
    String requestBody = "{\"id\":\"1\",\"firstName\":\"Koos\",\"lastName\":\"Pompies\"}";

    given()
      .header("Content-type", "application/json")
      .header("Accept", "application/json")
      .and()
      .body(requestBody)
      .when()
        .post("/xmldsl/person")
      .then()
        .statusCode(200)
        .body(is("{\"code\":\"SUCCESS\",\"description\":\"Successfully processed1 Koos\"}"));
  }
}
