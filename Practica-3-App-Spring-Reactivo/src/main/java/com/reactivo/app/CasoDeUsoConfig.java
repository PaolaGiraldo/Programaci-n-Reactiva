package com.reactivo.app;

import com.reactivo.app.casodeuso.CasoDeUsoLacteo;
import com.reactivo.app.data.LacteoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(basePackages = "com.reactivo.app.casodeuso",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "CasoDeUso.*")
        },

        useDefaultFilters = false)


public class CasoDeUsoConfig {
}
