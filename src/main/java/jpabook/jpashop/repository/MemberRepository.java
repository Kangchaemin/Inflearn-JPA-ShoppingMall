package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext // 여기에 EntityManager를 주입을 해준다.
    private EntityManager em;

    public void save(Member member) {
        em.persist(member); // memb
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id); // type, pk 넣어주기.
        //단건 조회
    }

    public List<Member> findAll() {

        //jpql을 썼다. sql이 아니라. 이건 Table이 대상이 아니라 Entity이다.
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                        .setParameter("name", name)
                        .getResultList();
    }

}
