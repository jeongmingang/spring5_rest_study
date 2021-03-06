package spring5_rest_study.mappers;

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
@ContextConfiguration(classes = {ContextRoot.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class MemberMapperTest {
	private static final Log log = LogFactory.getLog(MemberMapperTest.class);
	
	@Autowired
	private MemberMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test01SelectMemberByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Member> list = mapper.selectMemberByAll();
		Assert.assertNotNull(list);
		
		list.forEach(s->log.debug(s.toString()));
	}
	
	
	@Test
	public void test02SelectMemberById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member member = mapper.selectMemberById(2);
		Assert.assertNotNull(member);
		
		log.debug(member.toString());
	}
	
	@Test
	public void test03InsertMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member newMember = new Member("test20@test.co.kr", "1234", "test20");
		
		int res = mapper.insertMember(newMember);
		Assert.assertEquals(1, res);
		log.debug("res id >>" + res);
		
		mapper.deleteMember(newMember.getId());
	}
	
	@Test
	public void test04updateMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member upMember = new Member("test20@test.co.kr", "2222", "?????????20");
		mapper.insertMember(upMember);
		
		upMember.setPassword("1111");
		int res = mapper.updateMember(upMember);
		Assert.assertEquals(1, res);
		
		mapper.deleteMember(upMember.getId());
	}
	
	@Test
	public void test05DeleteMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member delMember = new Member("test20@test.co.kr", "2222", "?????????20");
		mapper.insertMember(delMember);
		
		int res = mapper.deleteMember(delMember.getId());
		Assert.assertEquals(1, res);
	}
}
