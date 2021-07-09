package com.sungmin.hellospring;

import com.sungmin.hellospring.domain.Member;
import com.sungmin.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

// 테스트 케이스는 먼저 테스트케이스를 작성하고 나서 코딩해도 되고
// 코딩 먼저 하고 테스트케이스를 구현해두됨.

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  // @AfterEach: 어떤 메서드가 끝날때 마다 실행하는 문장
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        repository.save(member);
        //then
        Member result = repository.findById(member.getId()).get();
        //System.out.println("result = "+ (result==member));
        //Assertions.assertEquals(result, member);
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);  // 원래는 assertThat하고 바로 사용가능한데 왜 이런지 몰게쎉

    }

    @Test
    public void findByName(){
        Member m1 = new Member();
        m1.setName("Jin Sung Min");
        repository.save(m1);

        Member m2 = new Member();
        m2.setName("Hong Gil Dong");
        repository.save(m2);

        Member res = repository.findByName("Jin Sung Min").get();

        org.assertj.core.api.Assertions.assertThat(res).isEqualTo(m1); // res가 m1이랑 같니?

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Jin Sung Min");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("Hong Gil Dong");
        repository.save(member2);

        List<Member> result = repository.findAll();

        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2); // res가 m1이랑 같니?
    }
    // 만약 수백, 수천개의 데이터가 있다면 test/java/본인프로젝트 이름 좌클릭해서 테스트 실행하면 알아서 해줌ㅋㅋ
}
