package ua.edu.znu.hibernatestudy.entities;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainHibernate {
    public static void main(String[] args) {
        Session session = null;
        try {
            StandardServiceRegistry registry =
                    new StandardServiceRegistryBuilder()
                            .configure()
                            .build();
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        } }
}
