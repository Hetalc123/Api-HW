package org.example;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
@Test
public class JasonPlaceHolder {
    public void verify_that_id_2_is_not_completed(){
        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com/todos")
                .when()
                .get("2")
                .then()
                .extract().response();
        response.prettyPrint();
       Assert.assertEquals(response.getStatusCode(),200);
        JsonPath jsonPath = response.getBody().jsonPath();
        Assert.assertEquals(jsonPath.getString("title"),"quis ut nam facilis et officia qui");
        Assert.assertEquals(jsonPath.getString("completed"),"false");
    }
    @Test
    public void verify_that_id_4_is_completed(){
        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com/todos")
                .when()
                .get("4")
                .then()
                .extract().response();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
        JsonPath jsonPath = response.getBody().jsonPath();
        Assert.assertEquals(jsonPath.getString("title"),"et porro tempora");
        Assert.assertEquals(jsonPath.getString("completed"),"true");
    }
    @Test
    public void verify_lng_ang_lat(){
        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com/todos/users/2")
                .when()
                .get()
                .then()
                .extract().response();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
        JsonPath jsonPath = response.getBody().jsonPath();
        Assert.assertEquals(jsonPath.getDouble("address.geo.lat"),"quis ut nam facilis et officia qui");

    }
}
