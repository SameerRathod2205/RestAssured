package api.test;

import api.endponits.UserEndpoints;
import api.payload.UserPOJO;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {

    Faker faker;
    UserPOJO userPayload;
    @BeforeClass
    public void setupData(){

        faker= new Faker();
        userPayload=new UserPOJO();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setUsername(faker.name().username());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
        userPayload.setPassword(faker.internet().password(5,10));


    }
    @Test(priority = 1)
    public void testPostUser(){
       Response response= UserEndpoints.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

        System.out.println("=========================================================================");
    }
    @Test(priority = 2)
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
    }



}
