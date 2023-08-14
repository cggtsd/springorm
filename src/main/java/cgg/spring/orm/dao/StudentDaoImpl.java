package cgg.spring.orm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import cgg.spring.orm.entities.Student;

public class StudentDaoImpl implements StudentDao {

	
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	//save student
	@Override
	@Transactional
	public int insert(Student student) {
		//insert
		Integer i =(Integer)hibernateTemplate.save(student);
		return i;
	}

}
