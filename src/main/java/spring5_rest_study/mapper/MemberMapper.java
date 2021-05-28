package spring5_rest_study.mapper;

import java.util.List;

import spring5_rest_study.dto.Member;

public interface MemberMapper {
	
	Member selectById(Long memId);
	List<Member> selectByAll();
	
	int insertMember(Member member);
	int deleteMember(Member member);
	int updateMember(Member member);
}
