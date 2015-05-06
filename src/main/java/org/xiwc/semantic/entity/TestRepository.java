package org.xiwc.semantic.entity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TestRepository extends JpaRepository<Test, Long> {

	Test findTopByFirstName(String firstName);

	List<Test> findAllByFirstName(String firstName);

	List<Test> findTop3ByUserName(String userName);

	List<Test> findByFirstNameAndLastName(String firstName, String lastName);

	List<Test> findByFirstNameAndLastNameAllIgnoreCase(String firstName, String lastName);

	List<Test> findDistinctTestByUserName(String userName);

	List<Test> findByUserNameOrderByLastNameAsc(String userName);

	List<Test> findByUserNameOrderByLastNameDesc(String userName);

	Page<Test> findByUserName(String userName, Pageable pageable);

	Slice<Test> readByUserName(String userName, Pageable pageable);

	// @Query("select t from #{#entityName} t where t.userName = ?1")
	@Query("select t from Test t where t.userName = ?1")
	List<Test> findAllByCustomQuery(String userName);

	// @NamedQuery(name = "Test.listAll", query = "select t from Test t")
	@Query
	List<Test> listAll();

	@Modifying(clearAutomatically = true)
	@Query("update Test t set t.firstName = ?1 where t.userName = ?2")
	int updateFirstNameByUserName(String firstName, String userName);
}
