package com.qinchy.imoocdemo.repository;

import com.qinchy.imoocdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    /**
     * 扩展Jpa接口，根据年龄查询，方法名findBy后面必须跟上字段，比如age字段
     * @param age
     * @return
     */
    public List<Student> findByAge(Integer age);
}
