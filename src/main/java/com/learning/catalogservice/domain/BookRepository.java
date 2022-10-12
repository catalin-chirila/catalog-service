package com.learning.catalogservice.domain;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
	Optional<Book> findByIsbn(String isbn);

	boolean existsByIsbn(String isbn);

	@Modifying
	@Query("delete from Book where isbn = :isbn")
	@Transactional
	void deleteByIsbn(String isbn);
}
