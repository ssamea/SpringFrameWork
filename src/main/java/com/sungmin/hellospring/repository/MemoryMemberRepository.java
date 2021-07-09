package com.sungmin.hellospring.repository;

import com.sungmin.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long seq = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++seq); // 아이디를 세팅
        store.put(member.getId(),member); // 맵에 저장

        return member;  // 반환
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // 널 값일 경우 처리를 위해 Optionalble 객체 이용
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))  // filter: 람다 수행, 파라미터로 넘어온 name이 같은 지 비교하고 찾으면 반환한다.
                .findAny();

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());  // 리스트 멤버들이 반환
    }

    public void clearStore(){
        store.clear();
    }

    // 이 기능들이 제대로 동작하는 지 어떻게 알지? -> 테스트 케이스를 작성하면 됨됨
}
