package spring5_rest_study.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_rest_study.config.ContextRoot;
import spring5_rest_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class MemberMapperTest {
protected static final Log log = LogFactory.getLog(MemberMapperTest.class);
	
	@Autowired 
	private MemberMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test1SelectByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Member> list = mapper.selectByAll();
		Assert.assertNotNull(list);
		
		list.forEach(s->log.debug(s.toString()));
	}

	@Test
	public void test2InsertMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member newMember = new Member("test20@test.co.kr", "1111", "test20", LocalDateTime.now());
		
		int res = mapper.insertMember(newMember);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test3SelectById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		long mem = 43;
		
		Member member = mapper.selectById(mem);
		Assert.assertNotNull(member);
		
		log.debug(member.toString());
	}

	@Test
	public void test4UpdateMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Member newMember = new Member("test20@test.co.kr", "2222", "테스트20",LocalDateTime.now());
		
		int res = mapper.updateMember(newMember);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test5DeleteMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member newMember = new Member("test20@test.co.kr", "2222", "테스트20",LocalDateTime.now());
		int res = mapper.deleteMember(newMember);
		Assert.assertEquals(1, res);
	}

}
