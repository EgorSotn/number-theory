package ru.studies.numbertheorylaba1.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class AppConfig {
    String filePath;
}
