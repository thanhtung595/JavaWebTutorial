package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.Employee;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
public class HibernateUtil {
	private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;
    static {
        try {
            if(sessionFactory == null) {
                standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
                MetadataSources  metadataSources = new MetadataSources(standardServiceRegistry).addAnnotatedClass(Employee.class);
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
        }catch(Throwable ex) {
            ex.printStackTrace();
        }
    }
    public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }
}
