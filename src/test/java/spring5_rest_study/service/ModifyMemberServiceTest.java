package spring5_rest_study.service;

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
public class ModifyMemberServiceTest {
	static final Log log = LogFactory.getLog(ModifyMemberServiceTest.class);
	
	@Autowired
	private ModifyMemberService service;
	
	@Autowired
	private RegisterMemberService regService;
	
	@Autowired
	private RemoveMemberService remService;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testModifyMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member upMember = new Member("test20@test.co.kr", "2222", "테스트20");
		regService.registerMember(upMember);
		
		int res = service.modifyMember(upMember);
		Assert.assertEquals(1, res);
		
		log.debug("res > " + res);
		
		remService.removeMember(upMember.getId());
	}

}
