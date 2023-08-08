package step_definitions;

import org.junit.Assert;

import com.jayway.restassured.response.ResponseBody;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.MyConfig;
import support.SupportFunctions;

public class VetsStepDef {
	
	private static ResponseBody body;

    
   
    @When("^i add new vet for each of the specialities \"([^\"]*)\",\"([^\"]*)\"$")
    public void IAddNewVet(String specialtiesId, String specialtiesName) throws Throwable {
    	String Bodyrequest="{\r\n"
    			+ "    \"id\": 2,\r\n"
    			+ "    \"firstName\": \"Test\",\r\n"
    			+ "    \"lastName\": \"Leary\",\r\n"
    			+ "    \"specialties\": [\r\n"
    			+ "      {\r\n"
    			+ "        \"id\": "+specialtiesId+",\r\n"
    			+ "        \"name\": \""+specialtiesName+"\"\r\n"
    			+ "      }\r\n"
    			+ "    ]\r\n"
    			+ "  }";
    	
        body = SupportFunctions.post(MyConfig.Endpoint + "api/vets", Bodyrequest);
        System.out.println(body.asString());
        
    }
    
    @Then("^should be added for each of the specialities \"([^\"]*)\",\"([^\"]*)\"$")
    public void NewVetAdded(String specialtiesId, String specialtiesName) throws Throwable {
    	Assert.assertEquals(body.jsonPath().getString("specialties[0].id"),specialtiesId);
        Assert.assertEquals(body.jsonPath().getString("specialties[0].name"),specialtiesName);

    }

}
