package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id셋팅하고
        store.put(member.getId(), member); //스토어에 저장 -> 맵에 저장이 됨.
        return member;

    }

    @Override
    public Optional<Member> findById(Long id) { //스토어에서 아이디 꺼내기
        return Optional.ofNullable(store.get(id)); //null이 반환될 가능성이 있으니 optional사용
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()//람다를 사용
                .filter(member -> member.getName().equals(name)) //
                //파라미터로 넘어온 name이랑 같은 지 확인, 같은 경우에만 필터링이 됨.
                .findAny(); //찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
