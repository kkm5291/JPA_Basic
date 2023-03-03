package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

// JPA는 Transaction 단위 안에서 꼭 작업을 해줘야만 한다

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 여기서 Member는 테이블명이 아닌 객체를 의미한다.
            // 즉, Member 전체를 가져와 라는 뜻의 쿼리가 완성된 것
//            List<Member> result = em.createQuery("select m from Member as m where m.id > 1 order by m.id", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(9)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//                System.out.println("member.id = " + member.getId());
//            }

            // 회원 등록 코드
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            // 회원 찾기
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getName());

            // 회원 이름 변경
//            findMember.setName("HelloJPA");

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);

//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAAA");
//
//            em.clear();
//            Member member2 = em.find(Member.class, 150L);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
