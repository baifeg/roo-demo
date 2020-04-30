package com.eadp.config;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eadp.dao.IStudentDao;
import com.eadp.entity.Clazz;
import com.eadp.entity.Student;
import com.slyak.spring.jpa.EntityAssemblerMany;

@Component
public class ClazzStudentAssembler extends EntityAssemblerMany<Clazz, Long, Student> {

	@Autowired
	private IStudentDao studentDao;

	@Override
	protected void setValue(Clazz bean, List<Student> value) {
		bean.setStudents(value);
	}

	@Override
	protected List<Student> getValue(List<Long> keys) {
		return studentDao.findAll(keys);
	}

	@Override
	protected List<Long> getKeys(Clazz bean) {
		return studentDao.findIdByClazzId(bean.getId());
	}

	@Override
	protected Map<Long, Student> mgetValue(Collection<Long> keys) {
		return studentDao.mget(keys);
	}

}
