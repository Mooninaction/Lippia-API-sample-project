package ar.validator;

import api.model.TimeEntry.TimeEntryResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class ProjectValidator {
    public static void validateId(String entity){
        TimeEntryResponse response = (TimeEntryResponse)APIManager.getLastResponse().getResponse();
        Assert.assertTrue(entity.contains(response.getId()),"The id of project is null");
    }
}
