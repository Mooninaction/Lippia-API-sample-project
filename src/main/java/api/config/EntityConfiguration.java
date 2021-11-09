package api.config;

import services.*;
import services.TimeEntry.AddTimeEntryService;
import services.TimeEntry.DeleteTimeEntryService;
import services.TimeEntry.EditTimeEntryService;
import services.TimeEntry.GetTimeEntryService;

public enum EntityConfiguration {

    USER {
        @Override
        public Class<?> getEntityService() {
            return UserService.class;
        }
    },
    GET_TIME {
        @Override
        public Class<?> getEntityService() {
            return GetTimeEntryService.class;
        }
    },
    ADD_TIME {
        @Override
        public Class<?> getEntityService() {
            return AddTimeEntryService.class;
        }
    },
    EDIT_TIME {
        @Override
        public Class<?> getEntityService() {
            return EditTimeEntryService.class;
        }
    },
    DELETE_TIME {
        @Override
        public Class<?> getEntityService() {
            return DeleteTimeEntryService.class;
        }
    };

    public abstract Class<?> getEntityService();
}



