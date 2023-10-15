package inflearn.hellospring;

import inflearn.hellospring.repository.MemberRepository;
import inflearn.hellospring.repository.MemoryMemberRepository;
import inflearn.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
