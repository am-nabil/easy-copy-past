package org.nynl.easycopypast.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.nynl.easycopypast")
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class AppConfiguration implements WebMvcConfigurer {


    private static final String PACKAGES_TO_SCAN = "org.nynl.easycopypast";
    private static final EmbeddedDatabaseType EMBEDDED_DATABASE_TYPE = EmbeddedDatabaseType.H2;
    private static final String EMBEDDED_DATABASE_NAME = "testDB";
    private static final String EMBEDDED_DATABASE_SCRIPT = "classpath:schema.sql";
    private static final String EMBEDDED_DATABASE_DATA = "classpath:data.sql";

    @Autowired
    private Environment env;

    @Bean
    public Properties getJDBCProperties() {
        Properties properties = new Properties();
        properties.put(DRIVER, env.getProperty("db.driver"));
        properties.put(URL, env.getProperty("db.url"));
        properties.put(USER, env.getProperty("db.username"));
        properties.put(PASS, env.getProperty("db.password"));
        return properties;
    }

    @Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        properties.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put(DIALECT, env.getProperty("hibernate.dialect"));
        return properties;
    }

    /**
     * Only for DEV Profile, local deployment and test purposes
     * @return the embedded datasource
     */
    @Bean
    public DataSource getEmbeddedDataSource() {
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        embeddedDatabaseBuilder.setType(EMBEDDED_DATABASE_TYPE)
                .setName(EMBEDDED_DATABASE_NAME)
                .addScript(EMBEDDED_DATABASE_SCRIPT)
                .addScript(EMBEDDED_DATABASE_DATA);
        DataSource dataSource = embeddedDatabaseBuilder.build();
        return dataSource;
    }

    /**
     * for production use, we prefer an external database
     * @return the external datasource
     */
    @Bean
    public DataSource getExternalDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(getJDBCProperties().getProperty(DRIVER));
        dataSource.setUrl(getJDBCProperties().getProperty(URL));
        dataSource.setUsername(getJDBCProperties().getProperty(USER));
        dataSource.setPassword(getJDBCProperties().getProperty(PASS));
        return dataSource;
    }

    /**
     * Get a hibernate session factory
     * @return localSessionFactory
     */
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setHibernateProperties(getHibernateProperties());
        factoryBean.setDataSource(getEmbeddedDataSource());
        factoryBean.setPackagesToScan(PACKAGES_TO_SCAN);
        return factoryBean;
    }

    /**
     * create the Hibernate transaction manager using session factory
     * @return
     */
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

}