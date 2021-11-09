package ar.steps;

import api.config.EntityConfiguration;
import api.model.TimeEntry.TimeEntryResponse;
import ar.validator.ProjectValidator;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import com.github.jknack.handlebars.internal.lang3.StringUtils;
import com.google.api.client.repackaged.com.google.common.base.Splitter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.TimeEntry.BaseServices;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ProjectSteps extends PageSteps {

    @Given("^My account created in clockify and my X-Api-Key$")
    public void myAccountCreatedInClockifyAndMyXApiKey() {
        BaseServices.API_KEY.set("YWU1MDQ4ZTAtM2U5MS00ODMwLTg3YjYtMmEzYzkxZmI4MTRl");
    }

    @And("My valid workspace id")
    public void myValidWorkspaceId() {
        BaseServices.ID_WORKSPACE.set("616f3e6f3a4a8554be9ca59d");
    }

    @And("My valid project id")
    public void myValidProjectId() {
        BaseServices.ID_PROJECT.set("617b3de3dc8bab727ecd3a01");
    }

    @Then("Validate the expected response was obtained in (.*)")
    public void theExpectedResponseWasObtainedInEntityWithTheJsonNameResponse(String entity) {
        ProjectValidator.validateId(entity);
    }

    @When("I perform a '(.*)' to '(.*)' with the endpoint '(.*)' and '(.*)'")
    public void iPerformAOperationToEntityWithTheEndpointJsonNameAnd(String methodName, String entity, String jsonName, String jsonReplacementValues) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<?> entityService = EntityConfiguration.valueOf(entity).getEntityService();
        Map<String, String> parameters = getParameters(jsonReplacementValues);
        String jsonPath = "request/".concat(jsonName);
        if (parameters == null) {
            entityService.getMethod(methodName.toLowerCase(), String.class).invoke("", jsonPath);
        } else {
            entityService.getMethod(methodName.toLowerCase(), String.class, Map.class).invoke("", jsonPath, parameters);
        }

    }

    private Map<String, String> getParameters(String jsonReplacementValues) {
        Map<String, String> parameters = null;
        if (!StringUtils.isEmpty(jsonReplacementValues)) {
            parameters = Splitter.on(",").withKeyValueSeparator(":").split(jsonReplacementValues);
        }
        return parameters;
    }


    @And("I have a new hour (.*) to set")
    public void theNewHour(String hour) {
        BaseServices.HOUR.set(hour);
    }

    @And("Save the time entry id")
    public void myValidTimeEntryId() {
        TimeEntryResponse response = (TimeEntryResponse) APIManager.getLastResponse().getResponse();
        BaseServices.ID_TIME.set(response.getId());
    }

    @Given("My account created in clockify and my Api-Key generated")
    public void myAccountCreatedInClockifyAndMyApiKeyGenerated() {
    }

    @Then("I will get the proper status code {string}")
    public void iWillGetTheProperStatusCodeStatusCode() {
    }

    @And("Got the status code <status>")
    public void gotTheStatusCodeStatus() {
    }
}
