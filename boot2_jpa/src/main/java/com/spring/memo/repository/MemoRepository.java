package com.spring.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.memo.entity.Memo;


// T : entity명
// ID : Entity클래스의 id컬럼 타입 
public interface MemoRepository extends JpaRepository<Memo, Long> {
	// JpaRepository : CRUD 작업
	// save()
	// delete()
	// count()
	// findAll()
	// findById()
	// ......
	
}
