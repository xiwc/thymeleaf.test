package org.xiwc.semantic.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xiwc.semantic.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
// @WebAppConfiguration
public class TestRepositoryTest {

	static Logger logger = LoggerFactory.getLogger(TestRepositoryTest.class);

	@Autowired
	TestRepository repo;

	@Test
	@Transactional
	@Rollback
	public void testSave() {

		org.xiwc.semantic.entity.Test test = new org.xiwc.semantic.entity.Test("zhao", "liu", "zhaoliu", "12345678",
				Sex.BOY, 33D);
		Set<ChildTest> childTests = new HashSet<ChildTest>();
		childTests.add(new ChildTest("zhao", "liu1", "zhaoliu", "12345678", Sex.BOY, 33D));
		childTests.add(new ChildTest("zhao", "liu2", "zhaoliu", "12345678", Sex.BOY, 33D));
		childTests.add(new ChildTest("zhao", "liu3", "zhaoliu", "12345678", Sex.BOY, 33D));
		test.setChildTests(childTests);

		repo.save(test);

		// test.setPassword("123456789");

		// repo.save(test);

		repo.findAll();

	}

	@Test
	@Transactional
	@Rollback
	public void testUpdate() {

		repo.findTop3ByUserName("wangwu").forEach(System.out::println);
		System.out.println(repo.updateFirstNameByUserName("xxx", "wangwu"));
		repo.findTop3ByUserName("wangwu").forEach(System.out::println);

	}

	@Test
	public void testQuery() {

		repo.findAll().forEach(System.out::println);
		System.out.println(repo.count());

		System.out.println(Stream.of(repo.findTopByFirstName("zhang")).peek(System.out::println).count());
		System.out.println(repo.findAllByFirstName("zhang").stream().peek(System.out::println).count());
		System.out.println(repo.findByFirstNameAndLastName("li", "si").stream().peek(System.out::println).count());
		System.out.println(repo.findByFirstNameAndLastNameAllIgnoreCase("LI", "SI").stream().peek(System.out::println)
				.count());
		System.out.println(repo.findDistinctTestByUserName("lisi").stream().peek(System.out::println).count());
		System.out.println(repo.findByUserNameOrderByLastNameAsc("lisi").stream().peek(System.out::println).count());
		System.out.println(repo.findByUserNameOrderByLastNameDesc("lisi").stream().peek(System.out::println).count());

		Pageable pageable = new PageRequest(0, 5);
		Page<org.xiwc.semantic.entity.Test> tests = repo.findByUserName("wangwu", pageable);
		tests.forEach(System.out::println);
		System.out.println(String.format("Pages: %s / Total: %s", tests.getTotalPages(), tests.getTotalElements()));
		System.out.println(String.format("Page: %s / count: %s", tests.getNumber(), tests.getContent().size()));

		while (tests.hasNext()) {
			tests = repo.findByUserName("wangwu", tests.nextPageable());
			tests.forEach(System.out::println);
			System.out.println(String.format("Page: %s / count: %s", tests.getNumber(), tests.getContent().size()));
		}

		System.out.println(repo.findAllByCustomQuery("wangwu").stream().peek(System.out::println).count());
		System.out.println(repo.listAll().stream().peek(System.out::println).count());

	}
}
