package ar.validator;

import api.model.TimeEntry.AddResponse;
import api.model.TimeEntry.TimeEntryResponse;
import api.model.TimeEntry.TimeInterval;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;
import services.TimeEntry.BaseServices;

public class ProjectValidator {


    public static void validateTime(String time) {
        TimeInterval response = (TimeInterval) APIManager.getLastResponse().getResponse();
        Assert.assertTrue(time.contains(response.getDuration()), "The time of project don't exist");
    }

    public static void validateDescription() {
        AddResponse response = (AddResponse) APIManager.getLastResponse().getResponse();
        Assert.assertTrue(response.getDescription().contains("NewHour"), "The description don't exist");
    }

    public static void validateWorkspaceId() {
        TimeEntryResponse[] response = (TimeEntryResponse[]) APIManager.getLastResponse().getResponse();
        for (TimeEntryResponse timeEntry : response) {
            if(timeEntry.getWorkspaceId().contains(BaseServices.ID_WORKSPACE.get())){
                return;
            }
        }
        Assert.fail("The workspace id doesn't match");

    }
}
