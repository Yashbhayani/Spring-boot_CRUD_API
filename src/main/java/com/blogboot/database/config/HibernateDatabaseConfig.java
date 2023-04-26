package com.blogboot.database.config;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.blogboot.model.User;


public class HibernateDatabaseConfig {
	
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		System.out.println("Hibernate java configuration sessionFactory >>>>"+sessionFactory);
		if (sessionFactory == null) {

			try {
				Configuration configuration = new Configuration();

				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/blogapp?useSSL=true");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "Yash@$#9974143053");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				settings.put(Environment.POOL_SIZE, "60");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(User.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate java configuration serviceRegistrery created");
				sessionFactory = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);

				System.out.println("After Hibernate java configuration sessionFactory >>>>"+sessionFactory);
				return sessionFactory;

			} catch (Exception e) {
				System.err.println(e);
			}

		}
		return sessionFactory;
	}
}

