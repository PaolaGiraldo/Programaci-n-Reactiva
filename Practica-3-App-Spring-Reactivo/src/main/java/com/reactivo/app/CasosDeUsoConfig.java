package com.reactivo.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(basePackages = "com.reactivo.app.casodeuso",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^CasoDeUso+.$")
        },
        useDefaultFilters = false)

public class CasosDeUsoConfig {



}
