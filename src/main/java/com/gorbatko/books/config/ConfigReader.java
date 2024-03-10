package com.gorbatko.books.config;

import com.gorbatko.books.exception.unchecked.ConfigParseRuntimeException;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.Optional;
import java.util.Properties;

@Component
public class ConfigReader {
    private final Properties properties;

    private ConfigReader() {
        try (FileInputStream fileInputStream = new FileInputStream("config.ini")) {
            this.properties = new Properties();
            this.properties.load(fileInputStream);
        } catch (Exception e) {
            throw new ConfigParseRuntimeException("Can't load config file: " + e.getMessage());
        }
    }

    public String getDatasetPath() {
        return Optional.ofNullable(properties.getProperty("app.dataset.path"))
                .orElseThrow(() -> new ConfigParseRuntimeException("Dataset path not found!"));
    }

}
