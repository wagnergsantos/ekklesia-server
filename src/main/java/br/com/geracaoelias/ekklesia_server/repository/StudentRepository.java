package br.com.geracaoelias.ekklesia_server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.geracaoelias.ekklesia_server.model.Student;
import br.com.geracaoelias.ekklesia_server.model.StudentInterface;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("select s from Student s where s.userName = :userName")
	StudentInterface findByUserName(@Param("userName") String userName);
	
	@Query("select s from Student s")
	List<StudentInterface> listAll();
	
	
}