package commGom.hellospring.repository;

import commGom.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        System.out.println(member.getId()+": 왜 값이 이래??");
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member=em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
//        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
//                .setParameter("name", name)
//                .getResultList();
//        return result.stream().findAny();
        return null;
    }

    @Override
    public List<Member> findAll() {
        List<Member> result=em.createQuery("select m from Member as m",Member.class).getResultList();
        return result;
    }
}
