package ar.validator;

import api.model.TimeEntry.TimeEntryResponse;
import api.model.TimeEntry.TimeInterval;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class ProjectValidator {

    public static void validateId(String entity){
        TimeEntryResponse response = (TimeEntryResponse)APIManager.getLastResponse().getResponse();
        Assert.assertTrue(entity.contains(response.getId()),"The id of project is null");
    }

    public static void validateTime(String time) {
        TimeInterval response = (TimeInterval)APIManager.getLastResponse().getResponse();
        Assert.assertTrue(time.contains(response.getDuration()), "The time of project is null");
    }


    public static void validateDescription(String description) {
        TimeEntryResponse response = (TimeEntryResponse)APIManager.getLastResponse().getResponse();
        Assert.assertTrue(description.contains(response.getDescription()), "The description is null");
    }
}
