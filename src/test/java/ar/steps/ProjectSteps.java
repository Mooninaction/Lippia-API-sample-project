package ar.steps;

import api.config.EntityConfiguration;
import ar.validator.ProjectValidator;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import com.google.api.client.repackaged.com.google.common.base.Splitter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import services.TimeEntry.BaseServices;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ProjectSteps extends PageSteps {

    @Given("My account created in clockify and my Api-Key generated")
    public void myAccountCreatedInClockifyAndMyApiKeyGenerated() {
        BaseServices.API_KEY.set("YWU1MDQ4ZTAtM2U5MS00ODMwLTg3YjYtMmEzYzkxZmI4MTRl");
    }

    @And("My valid workspace id")
    public void myValidWorkspaceId() {
        BaseServices.ID_WORKSPACE.set("617f1d51fb81833974f0b318");
    }

    @And("My valid project id")
    public void myValidProjectId() {
        BaseServices.ID_PROJECT.set("6187065f73a4fb750e89f2b8");
    }

    @When("I perform a '(.*)' to '(.*)' with the endpoint '(.*)' and '(.*)'")
    public void iPerformAOperationToEntityWithTheEndpointJsonNameAnd(String methodName, String entity, String jsonName, String jsonReplacementValues) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class entityService = EntityConfiguration.valueOf(entity).getEntityService();
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

    @Then("Validate the expected response was obtained in (.*)")
    public void validateTheExpectedResponseWasObtainedInEntity(String entity) {
        ProjectValidator.validateId(entity);
    }


    @And("Add time to the project")
    public void addTimeToTheProject() {
    }

    @Then("Validate that the corresponding <time> was added")
    public void validateThatTheCorrespondingTimeWasAdded() {
    }

    @And("I save time entry id")
    public void iSaveTimeEntryId() {
    }

    @And("I setting <startedHour>")
    public void iSettingStartedHour() {
    }

    @Then("Validate that the edited time is as expected")
    public void validateThatTheEditedTimeIsAsExpected() {
    }

    @Then("Validate that the {string} is as expected")
    public void validateThatTheStatusCodeIsAsExpected() {
    }
}

