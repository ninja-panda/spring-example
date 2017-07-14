package com.tuturself.spring.boot.consul.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.bootstrap.config.PropertySourceBootstrapProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties(PropertySourceBootstrapProperties.class)
public class ConsulConfiguration {

    @Value("${cassandra.hosts}")
    private String cassandraHost;

    @Value("${cassandra.user}")
    private String userName;

    @Value("${cassandra.password}")
    private String password;

    @Value("${cassandra.pooling.maxThread}")
    private int maxThread;

    @Value("${cassandra.pooling.timeout}")
    private int timeout;

    @Value("${cassandra.keyspace.name}")
    private String keyspace;

    @Value("${cassandra.keyspace.readConsistency}")
    private String readConsistency;

    @Value("${cassandra.keyspace.writeConsistency}")
    private String writeConsistency;

    @PostConstruct
    public void printConsulConfiguration() {
        System.out.println("ConsulConfiguration{" +
                "cassandraHost='" + cassandraHost + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", maxThread=" + maxThread +
                ", timeout=" + timeout +
                ", keyspace='" + keyspace + '\'' +
                ", readConsistency='" + readConsistency + '\'' +
                ", writeConsistency='" + writeConsistency + '\'' +
                '}');
    }
}
