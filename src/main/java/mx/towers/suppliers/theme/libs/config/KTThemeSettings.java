package mx.towers.suppliers.theme.libs.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class KTThemeSettings {
    public KTThemeBaseConfig config;

    public KTThemeSettings() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("theme/config/themesettings.json");
        try {
            config = objectMapper.readValue(file, KTThemeBaseConfig.class);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
