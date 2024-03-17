package api.endponits;

import api.payload.UserPOJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

// created to perform CURD operations
public class UserEndpoints {
   public static Response response;
    public static Response createUser(UserPOJO payload){
        response= given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(Roots.post_url);

       return response;

    }

    public static Response readUser(String userName){
          response= given().pathParam("username",userName)

                .when()
                .get(Roots.get_url);

        return response;

    }

    public static Response updateUser(String userName,UserPOJO payload){
        response= given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .body(payload)

                .when()
                .put(Roots.update_url);

        return response;

    }

    public static Response delete(String userName){
         response= given().pathParam("username",userName)

                .when()
                .delete(Roots.delete_url);

        return response;

    }

}
