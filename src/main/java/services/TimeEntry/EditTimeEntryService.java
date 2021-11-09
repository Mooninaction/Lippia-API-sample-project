package services.TimeEntry;

import api.model.TimeEntry.EditResponse;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class EditTimeEntryService extends BaseServices {

    public static Response put(String jsonName) {
        return put(jsonName, EditResponse.class,setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();
        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        params.put("api-key",API_KEY.get());
        params.put("id-project",ID_PROJECT.get());
        params.put("id-work",ID_WORKSPACE.get());
        params.put("time-id",ID_TIME.get());
        params.put("hour",HOUR.get());
        return params;
    }
}
