package commGom.hellospring.service;

import commGom.hellospring.domain.Member;
import commGom.hellospring.repository.JdbcMemberRepository;
import commGom.hellospring.repository.MemberRepository;
import commGom.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @Test
    void join() {
        //given : 무언가가 주어졌을 때,
        Member member=new Member();

        member.setName("jdbc");

        //when : 이 상황에
        Long saveId=memberService.join(member);

        //then : 이 결과가 나와야한다.
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

}