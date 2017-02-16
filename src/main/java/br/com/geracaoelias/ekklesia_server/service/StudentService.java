package br.com.geracaoelias.ekklesia_server.service;

import java.util.List;

import br.com.geracaoelias.ekklesia_server.model.StudentInterface;

public interface StudentService {
	StudentInterface save(StudentInterface student);
	boolean findByLogin(String userName, String password);
	boolean findByUserName(String userName);
	List<StudentInterface> listAll();
}
