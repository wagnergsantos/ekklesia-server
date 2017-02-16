package br.com.geracaoelias.ekklesia_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geracaoelias.ekklesia_server.model.Student;
import br.com.geracaoelias.ekklesia_server.repository.StudentRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public Student save(Student student) {
		return studentRepository.save((Student) student);
	}

	public boolean findByLogin(String userName, String password) {
		Student stud = studentRepository.findByUserName(userName);

		if (stud != null && stud.getPassword().equals(password)) {
			return true;
		}

		return false;
	}

	public boolean findByUserName(String userName) {
		Student stud = studentRepository.findByUserName(userName);

		if (stud != null) {
			return true;
		}

		return false;
	}

	@Override
	public List<Student> listAll() {
		return studentRepository.listAll();
	}
}
