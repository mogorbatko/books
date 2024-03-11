package com.gorbatko.books.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigReader {
    @Value("${app.dataset.path}")
    private String datasetPath;

    public String getDatasetPath() {
        return this.datasetPath;
    }

}
