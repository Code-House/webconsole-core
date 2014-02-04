package org.webconsole.api;

import java.util.Map;

public interface PreferencesProvider {

    Map<String, Object> getPreferences(String username);

    Map<String, Object> getPreferences();

}
