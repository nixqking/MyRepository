package sms;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neil.mapper.ScMapper;
import com.neil.pojo.Sc;

public class SearchTest {

	@Test
	public void test() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		ScMapper sm = context.getBean(ScMapper.class);
		ArrayList<Sc> al=(ArrayList<Sc>) sm.queryStudentScore("10002");
			System.out.println(al.size());
	}

}
