package br.com.geracaoelias.ekklesia_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geracaoelias.ekklesia_server.model.Student;
import br.com.geracaoelias.ekklesia_server.model.StudentInterface;
import br.com.geracaoelias.ekklesia_server.repository.StudentRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public StudentInterface save(StudentInterface student) {
		return studentRepository.save((Student)student);
	}

	public boolean findByLogin(String userName, String password) {	
		StudentInterface stud = studentRepository.findByUserName(userName);
		
		if(stud != null && stud.getPassword().equals(password)) {
			return true;
		} 
		
		return false;		
	}

	public boolean findByUserName(String userName) {
		StudentInterface stud = studentRepository.findByUserName(userName);
		
		if(stud != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<StudentInterface> listAll() {
		return studentRepository.listAll();
	}
}
