package com.valekseev.helloworld;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.addResource("hibernate.cfg.xml");
            configuration.configure();
            // 4.3 > StandardServiceRegistryBuilder()
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()). buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            //sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static Session getCurrentSession() throws HibernateException {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (org.hibernate.HibernateException he) {
            session = sessionFactory.openSession();
        }
        return session;
    }
}
