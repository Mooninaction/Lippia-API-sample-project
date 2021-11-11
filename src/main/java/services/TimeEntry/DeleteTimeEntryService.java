package services.TimeEntry;

import api.model.TimeEntry.TimeEntryResponse;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class DeleteTimeEntryService extends BaseServices {

    public static Response delete(String jsonName) {
        return delete(jsonName, TimeEntryResponse[].class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        params.put("api-key", API_KEY.get());
        params.put("id-project", ID_PROJECT.get());
        params.put("id-work", ID_WORKSPACE.get());
        params.put("time-id", ID_TIME.get());
        return params;
    }
}