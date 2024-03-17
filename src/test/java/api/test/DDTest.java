package api.test;

import api.endponits.UserEndpoints;
import api.payload.UserPOJO;
import api.utilities.DataProvider123;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class DDTest {

    @Test(dataProvider="excelData",dataProviderClass = DataProvider123.class)
    public void testPostUser(Map<String,String>getData){
        UserPOJO  userPayload=new UserPOJO();

        userPayload.setId(Integer.parseInt(getData.get("UserID")));
        userPayload.setUsername(getData.get("UserName"));
        userPayload.setFirstName(getData.get("FIrstName"));
        userPayload.setLastName(getData.get("LastName"));
        userPayload.setEmail(getData.get("Email"));
        userPayload.setPhone(getData.get("Phone"));
        userPayload.setPassword(getData.get("Password"));

       Response response= UserEndpoints.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

        System.out.println("=========================================================================");
    }
  /*  @Test(priority = 2)
    public void testGetUserByUserName(){
        Response response= UserEndpoints.readUser(this.userPayload.getUsername());
        response.then().log().all();
        //response.statusCode();

        Assert.assertEquals(response.getStatusCode(),200);

        System.out.println("=========================================================================");
    }

    @Test(priority = 3)
    public void testUpdateUserByUserName(){
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());

        //update data using same playload
        Response response= UserEndpoints.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        //checking data after update
        Response responseAfterUpdate= UserEndpoints.readUser(this.userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);

        System.out.println("=========================================================================");

    }

    @Test(priority = 4)
    public void testDeleteUserByUserName(){
        Response response= UserEndpoints.delete(this.userPayload.getUsername());
        response.then().log().all();
        //response.statusCode();

        Assert.assertEquals(response.getStatusCode(),200);

        System.out.println("=========================================================================");
    }*/



}
