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
import spring5_rest_study.service.impl.RegisterMemberServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class RegisterMemberServiceTest {
	static final Log log = LogFactory.getLog(RegisterMemberServiceImpl.class);
	
	@Autowired
	private RegisterMemberService service;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testRegisterMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member newMember = new Member("test20@test.co.kr", "1234", "test20");
		
		int res = service.registerMember(newMember);
		Assert.assertEquals(1, res);
	}
}
