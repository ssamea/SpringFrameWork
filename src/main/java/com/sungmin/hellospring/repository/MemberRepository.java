package com.sungmin.hellospring.repository;

import com.sungmin.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 지금까지 저장된 모든 환자 리스트 반


}
