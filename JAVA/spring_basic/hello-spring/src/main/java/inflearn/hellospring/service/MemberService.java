package inflearn.hellospring.service;

import inflearn.hellospring.domain.Member;
import inflearn.hellospring.repository.MemberRepository;
import inflearn.hellospring.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원 가입
    public Long join(Member member) {
        // 같은 이름인 회원 안 됨
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalArgumentException("중복 회원입니다.");
        });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}