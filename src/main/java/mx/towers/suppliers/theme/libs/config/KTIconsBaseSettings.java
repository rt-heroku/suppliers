package mx.towers.suppliers.theme.libs.config;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KTIconsBaseSettings {
    public Map<String, Integer> config;

    public KTIconsBaseSettings() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("theme/config/icons.json");
        try {
            config = objectMapper.readValue(file, new TypeReference<Map<String, Integer>>() {});
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
