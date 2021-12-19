package commGom.hellospring;

import commGom.hellospring.repository.JdbcMemberRepository;
import commGom.hellospring.repository.JpaMemberRepository;
import commGom.hellospring.repository.MemberRepository;
import commGom.hellospring.repository.MemoryMemberRepository;
import commGom.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

//java를 이용한 직접 bean 등록, 유용하다.
@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return  new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//
//    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
}
