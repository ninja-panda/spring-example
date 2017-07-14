package com.tuturself.spring.boot.consul;

import com.tuturself.spring.boot.consul.config.ConsulConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@RefreshScope
public class SpringBootConsulApplication {

    private static ConsulConfiguration consulConfiguration;

    @Autowired
    private ConsulConfiguration consulConfigurationInstance;

    @PostConstruct
    public void init() {
        consulConfiguration = consulConfigurationInstance;
    }

    public static void main(String[] args) {
        try {
            String consulHost = System.getProperty("spring.cloud.consul.host");
            System.out.println("consulHost ::" + consulHost);

            String consulPort = System.getProperty("spring.cloud.consul.port");
            System.out.println("consulPort ::" + consulPort);

            String consulPrefix = System.getProperty("spring.cloud.consul.config.prefix");
            System.out.println("consulPrefix ::" + consulPrefix);

            new SpringApplicationBuilder(SpringBootConsulApplication.class).web(true).run(args);
            //consulConfiguration = consulConfigurationInstance;
            consulConfiguration.printConsulConfiguration();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
