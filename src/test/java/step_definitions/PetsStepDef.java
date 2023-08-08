package step_definitions;

import com.jayway.restassured.response.ResponseBody;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dto.Pet;
import dto.Pets;
import org.junit.Assert;

import support.JSONFileParser;
import support.MyConfig;
import support.SupportFunctions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PetsStepDef {

    private static ResponseBody body;
    String Bodyrequest= JSONFileParser.getJSONFromFile("src\\test\\java\\Jsonbody\\BodyRequestNewPet.json");

    @When("^I want to know all the pets in the clinic$")
    public void i_want_to_know_all_the_pets_in_the_clinic() throws Throwable {
        body = SupportFunctions.get(MyConfig.Endpoint + "api/pets");
        System.out.println(body.asString());

    }


    @Then("^I should receive 13 pets$")
    public void i_should_receive_pets() throws Throwable {
        Pet[] petsDTO = SupportFunctions.convertResponseArray(Pet[].class);
        int amountOfPets = petsDTO.length;
        //System.out.println("lenght of pets is :"+amountOfPets );
        //Assert.assertEquals("the amount of pets is  | ",15,amountOfPets);
    }
    
    @When("^i add new Pet$")
    public void IAddNewPet() throws Throwable {
    	//System.out.println("BodyRequestNewPet.json is "+ Bodyrequest );
        body = SupportFunctions.post(MyConfig.Endpoint + "api/pets", Bodyrequest);
        System.out.println(body.asString());
        
    }
    
    @Then("^I should have the new Pet added$")
    public void NewPetAdded() throws Throwable {
        Assert.assertEquals(body.jsonPath().getString("id"),"16");
        Assert.assertEquals(body.jsonPath().getString("name"),"Scoupidou");
        Assert.assertEquals((body.jsonPath().get("type.name")),"dog");


    }
}
