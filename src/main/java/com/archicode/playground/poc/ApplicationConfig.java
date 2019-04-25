package com.archicode.playground.poc;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tomasz Kozlowski (created on 16.04.2019)
 */
@Configuration
@PropertySource("classpath:config/jdbc.properties")
public class ApplicationConfig {

    @Bean
    @Primary
    public DataSource dataSource(DataSourceProperties properties) {
        return DataSourceBuilder.create().build();
        /*HikariDataSource dataSource = (HikariDataSource) DataSourceBuilder.create()
                .type(properties.getType())
                .driverClassName(properties.getDriverClassName())
                .url(properties.getUrl())
                .username(properties.getUsername())
                .password(properties.getPassword())
                .build();

        // Hikari properties
        dataSource.setPoolName("AppConnectionPool");
        dataSource.setMaximumPoolSize(5);
        dataSource.setMinimumIdle(2);
        return dataSource;*/
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSourceProperties dataSourceProperties, DataSource dataSource) {
        // JPA Properties
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.ddl-auto", "create-drop");
        // hibernate.hbm2ddl.auto -> update
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.connection.provider_class", "org.hibernate.hikaricp.internal.HikariCPConnectionProvider");

        properties.put(AvailableSettings.DRIVER, dataSourceProperties.getDriverClassName());
        properties.put(AvailableSettings.URL, dataSourceProperties.getUrl());
        properties.put(AvailableSettings.USER, dataSourceProperties.getUsername());
        properties.put(AvailableSettings.PASS, dataSourceProperties.getPassword());

//        spring.datasource.type=com.zaxxer.hikari.HikariDataSource
//        spring.datasource.driverClassName=org.h2.Driver

//        spring.datasource.username=poc
//        spring.datasource.password=poc

        // JPA Vendor Adapter
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.H2);
        jpaVendorAdapter.setGenerateDdl(true);

        // Entity Manager Factory Bean
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        //factoryBean.setDataSource(dataSource);
        factoryBean.setJpaPropertyMap(properties);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("com.archicode.playground.poc");
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
