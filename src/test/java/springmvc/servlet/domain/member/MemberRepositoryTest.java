package springmvc.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {
    MemberRepository repository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }


    @Test
    void test() {
        Member member = new Member("hello", 20);

        Member savedMember = repository.save(member);

        Member findMember = repository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        Member member1 = new Member("hello1", 20);
        Member member2 = new Member("hello2", 30);

        repository.save(member1);
        repository.save(member2);

        List<Member> members = repository.findAll();

        assertThat(members.size()).isEqualTo(2);
    }
}
