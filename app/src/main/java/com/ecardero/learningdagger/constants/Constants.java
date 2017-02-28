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
        String PUBLIC_API_KEY           = "5ec64c8831aa5b8f4e363a47aadcc5e1";
        String PRIVATE_API_KEY          = "3ba3f1314510d29a0f12cfa304e86a52f9946f6d";

        String STARWARS_SERVICE_URL     = "http://172.20.17.7:5000/";
    }

    interface CustomFirebase{
        interface Event{
            String ACTIVITY_START       = "activity_start";
            String USER_LOGIN           = "user_login";
            String USER_LOGOUT          = "user_logout";

        }
        interface Params{
            String ACTIVITY_NAME        = "activity_name";
            String USER_UID             = "user_login_name";
        }
    }
}
