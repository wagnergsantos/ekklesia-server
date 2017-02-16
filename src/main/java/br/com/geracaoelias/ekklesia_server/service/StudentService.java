package br.com.geracaoelias.ekklesia_server.service;

import java.util.List;

import br.com.geracaoelias.ekklesia_server.model.Student;

public interface StudentService {
	Student save(Student student);
	boolean findByLogin(String userName, String password);
	boolean findByUserName(String userName);
	List<Student> listAll();
}
