package com.hibernateTest.HibernateAllTopic;

import java.util.Locale.Category;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/HibernateTest")
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "arif12345678arif")
                    .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .setProperty("hibernate.hbm2ddl.auto", "create")
                    .setProperty("hibernate.show_sql", "true")
                    
                    .addAnnotatedClass(Question.class)
                    .addAnnotatedClass(QuesCategory.class); // add your entity class here
                
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            
          return  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        
        return sessionFactory;
    }
}

