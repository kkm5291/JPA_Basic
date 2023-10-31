package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();

            member.setName("hello");

            em.persist(member);

            em.flush();
            em.clear();

            //
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
            //
            Member findMember = em.getReference(Member.class, member.getId());
            System.out.println("findMember = " + findMember.getClass());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }

}
