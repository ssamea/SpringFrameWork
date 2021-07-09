package com.sungmin.hellospring.repository;

import com.sungmin.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// 아직 데이터 저장소가 선정되지 않아서, 우선 인터페이스로 구현 클래스를 변경할 수 있도록 설계
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 지금까지 저장된 모든 환자 리스트 반


}
