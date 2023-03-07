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

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.changeTeam(team);;
            em.persist(member);



            //저장

//            em.flush();
//            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }

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
            // GENERATE.VALUE에서 IDENTITY값의 경우에는 1차캐시에 방문하는 것이 아니라, em.persist단계에서 db에 접근해서 id값을 먼저 받아오는 방식이다
            // 버퍼링에서 값을 가져가는게 딱히 큰 매리트가 있는것은 아니라고 함

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
