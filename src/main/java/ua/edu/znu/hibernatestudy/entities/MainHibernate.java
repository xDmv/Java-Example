package ua.edu.znu.hibernatestudy.entities;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ua.edu.znu.hibernatestudy.entities.Roles;

import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import java.sql.Date;


public class MainHibernate {
    public static void main(String[] args) {

        try (Session session = getSessionFactory().openSession())  {
            // add new item for Role
            Roles role = new Roles();
            role.setType("specialist");
            role.setDescription("specialist in salon");
            session.beginTransaction();
            Long roleId = (Long) session.save(role);
            System.out.println("add Role id: " + roleId);
            session.getTransaction().commit();

            // remove new item for Role
            Roles roleDelete = session.get(Roles.class, roleId);
            session.beginTransaction();
            session.delete(roleDelete);
            session.getTransaction().commit();

            // update item for Role
            Roles roleToUpdate = session.get(Roles.class, 6L);
            session.evict(roleToUpdate);
            roleToUpdate.setEdited_ed(Instant.now());
            roleToUpdate.setAuthor_id(2L);
            roleToUpdate.setType("specialist");
            roleToUpdate.setDescription("type specialist");
            roleToUpdate.setCreated_at(Instant.now());
            session.beginTransaction();
            session.update(roleToUpdate);
//            session.saveOrUpdate(roleToUpdate);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private static SessionFactory getSessionFactory() {
/*Load configuration data from src/main/resources/hibernate.cfg.xml
          and build services registry use it*/
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        /*Build session factory using services registry*/
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        return sessionFactory;
    }
}
