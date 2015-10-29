package com.cmcc.syw;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sunyiwei on 2015/10/29.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sf = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).buildMetadata().buildSessionFactory();

        //测试乐观锁的用法
        insert(sf);
        list(sf);
//        testOptimisticLock(sf);

        sf.close();
    }
    
    private static void list(SessionFactory sf){
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        List result = session.createQuery("from Course").list();
        for (Object o : result) {
            System.out.println(o);
        }

        transaction.commit();

        session.close();
    }

    private static void insert(SessionFactory sf){
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(new Course(27, "Patrick1", Gender.FEMALE, new Name("sun", "yiwei")));
        session.save(new Course(27, "Patrick2", Gender.MALE, new Name("sun", "yiwei")));
        session.save(new Course(27, "Patrick3", null, new Name("sun", "yiwei")));

        transaction.commit();

        session.close();
    }

    private static void testOptimisticLock(SessionFactory sf){
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        final long courseId = 0L;
        Course course = session.load(Course.class, courseId);
        course.setName("Patrick" + new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date()));
        transaction.commit();

        session.close();
    }
}
