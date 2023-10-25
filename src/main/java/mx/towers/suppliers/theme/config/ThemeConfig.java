package mx.towers.suppliers.theme.config;

import mx.towers.suppliers.theme.libs.KTTheme;
import mx.towers.suppliers.theme.libs.config.KTThemeBaseConfig;
import mx.towers.suppliers.theme.libs.config.KTIconsBaseSettings;
import mx.towers.suppliers.theme.libs.config.KTThemeSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class ThemeConfig {
    @Bean("theme")
    @RequestScope
    public KTTheme theme(){
        return new KTTheme();
    }

    @Bean("settings")
    public KTThemeBaseConfig settings() {
        KTThemeSettings settings = new KTThemeSettings();
        return settings.config;
    }

    @Bean("iconsSettings")
    public KTIconsBaseSettings iconsSettings(){
       return new KTIconsBaseSettings();
    }
}
