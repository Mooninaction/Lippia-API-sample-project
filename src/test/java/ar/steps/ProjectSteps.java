package ar.steps;

import api.config.EntityConfiguration;
import api.model.TimeEntry.TimeInterval;
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
        BaseServices.ID_WORKSPACE.set("6187065f73a4fb750e89f2b8");
    }

    @And("My valid project id")
    public void myValidProjectId() {
        BaseServices.ID_PROJECT.set("61870689d1dc1e56c7c3a927");
    }

    @When("^I perform a '(.*)' to '(.*)' with the endpoint '(.*)' and '(.*)'$")
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

    @And("Add <description> to the project")
    public void addDescriptionToTheProject() {
        BaseServices.DESCRIPTION.set("NewHours");
    }

    @And("Search id_time")
    public void searchId_time() {
        BaseServices.ID_TIME.get();
    }

    @And("Edit (.*)")
    public void editTime(String time) {
        BaseServices.TIME.set(time);
    }

    @And("Delete <time>")
    public void deleteTime() {
        BaseServices.TIME.remove();
    }

    @Then("Validate that the corresponding <description>")
    public void validateThatTheCorrespondingDescriptionWasAdded() {
        ProjectValidator.validateDescription();
    }

    @Then("Validate that the <time> is null")
    public void validateThatTheTimeIsNull(String time) {
        ProjectValidator.validateTime(time);
    }

    @Then("Validate that the corresponding <time>")
    public void validateThatTheCorrespondingTime(String time) {
        ProjectValidator.validateTime(time);
    }

    @Then("Validate the expected workspace id")
    public void validateTheExpectedWorkspaceId() {
        ProjectValidator.validateWorkspaceId();
    }
}

