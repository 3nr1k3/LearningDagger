package com.ecardero.learningdagger.constants;

/**
 * Created by ecardero on 3/02/17.
 */

public interface Constants {
    interface Database {
        String REALM_MIGRATION_NAME     = "characters.realm";
        long REALM_MIGRATION_VERSION    = 1;
    }

    interface MarvelService{
        String PORT                     = "80";
        String SERVICE_URL              = "http://gateway.marvel.com" + PORT;
        String PUBLIC_API_KEY           = "<YOUR_PUBLIC_KEY>";
        String PRIVATE_API_KEY          = "<YOUR_PRIVATE_KEY>";
    }

    interface CustomFirebase{
        interface Event{
            String ACTIVITY_START       = "activity_start";
        }
        interface Params{
            String ACTIVITY_NAME        = "activity_name";
        }
    }
}
