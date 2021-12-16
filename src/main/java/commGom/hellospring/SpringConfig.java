package commGom.hellospring;

import commGom.hellospring.repository.MemberRepository;
import commGom.hellospring.repository.MemoryMemberRepository;
import commGom.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//java를 이용한 직접 bean 등록, 유용하다.
@Configuration
public class SpringConfig {
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
}
