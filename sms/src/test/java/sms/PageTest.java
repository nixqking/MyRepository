package sms;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neil.mapper.ScMapper;
import com.neil.pojo.Sc;

public class PageTest {

	@Test
	public void test() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		ScMapper scm = context.getBean(ScMapper.class);
		PageHelper.startPage(2, 5);
		ArrayList<Sc> al = (ArrayList<Sc>) scm.queryStudentScore("10000");
		PageInfo<Sc> p = new PageInfo<>(al);
		System.out.println(p.getNextPage());
		System.out.println(p.getPrePage());
		System.out.println(p.getPageNum());
		System.out.println(p.getPageSize());
		System.out.println(p.getPages());
	}

}
