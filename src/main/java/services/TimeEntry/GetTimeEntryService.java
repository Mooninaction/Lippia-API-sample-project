package services.TimeEntry;

import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class GetTimeEntryService extends BaseServices {


    public static Response get(String jsonName) {
        return get(jsonName);
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        params.put("api-key",API_KEY.get());
        params.put("id-project",ID_PROJECT.get());
        params.put("id-work",ID_WORKSPACE.get());
        return params;
    }
}
