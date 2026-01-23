package com.klu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hiberante.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student s = new Student("Ravi", 85);

        session.save(s);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("Student inserted successfully");
    }
}
