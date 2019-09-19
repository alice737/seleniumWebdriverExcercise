package jpstore.navigation;

import jpstore.configuration.AppProperties;

public class ApplicationUrl {
    public static final String APPLICATION_URL = AppProperties.getAllUrl();
    public static final String LOGIN_URL = APPLICATION_URL + "actions/Account.action?signonForm=";

}
