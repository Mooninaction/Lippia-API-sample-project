package services.TimeEntry;

import api.model.TimeEntry.AddResponse;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class AddTimeEntryService extends BaseServices {

    public static Response post(String jsonName) {
        return post(jsonName, AddResponse.class,setParams());
    }

    private static Map<String, String> setParams() {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        params.put("api-key",API_KEY.get());
        params.put("id-project",ID_PROJECT.get());
        params.put("id-work",ID_WORKSPACE.get());
        params.put("description",DESCRIPTION.get());
        return params;
    }
}
