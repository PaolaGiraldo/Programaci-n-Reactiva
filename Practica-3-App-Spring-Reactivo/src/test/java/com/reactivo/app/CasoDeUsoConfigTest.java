package com.reactivo.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration
class CasoDeUsoConfigTest{

    @Test
    public void whenRegexFilterIsUsed_thenComponentScanShouldRegisterBeanMatchingRegex() {
        System.out.println("TEST");
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(CasoDeUsoConfig.class);
        List<String> beans = Arrays.stream(applicationContext.getBeanDefinitionNames())
                .filter(bean -> !bean.contains("org.springframework")
                        && !bean.contains("CasoDeUsoConfig"))
                .collect(Collectors.toList());



        System.out.println(beans);

    }

}