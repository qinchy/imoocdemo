package com.qinchy.imoocdemo.controller;

import com.qinchy.imoocdemo.model.Student;
import com.qinchy.imoocdemo.repository.StudentRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * 获取所有学生
     *
     * @return
     */
    @GetMapping(path = "/students")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    /**
     * 创建一个学生
     *
     * @param name
     * @param age
     * @return
     */
    @PostMapping(path = "/students")
    public Student createOne(@RequestParam(name = "name", required = true) String name,
                             @RequestParam(name = "age", required = true) Integer age) {
        Student stu = new Student(name, age);
        return studentRepository.save(stu);
    }

    /**
     * 获取一个学生
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/students/{id}")
    public Student getOne(@PathVariable(name = "id", required = true) Integer id) {
        return studentRepository.findOne(id);
    }


    /**
     * 更新一个学生
     *
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping(path = "/students/{id}")
    public Student updateOne(@PathVariable(name = "id", required = true) Integer id,
                             @RequestParam(name = "name", required = true) String name,
                             @RequestParam(name = "age", required = true) Integer age) {
        Student stu = new Student(name, age);
        stu.setId(id);
        return studentRepository.save(stu);
    }

    /**
     * 删除一个学生
     *
     * @param id
     * @return
     */
    @DeleteMapping(path = "/students/{id}")
    public Boolean deleteOne(@PathVariable(name = "id", required = true) Integer id) {
        studentRepository.delete(id);
        return true;
    }

    /**
     * 根据年龄获取学生列表
     *
     * @param age
     * @return
     */
    @GetMapping(path = "/students/age/{age}")
    public List<Student> findByAge(@PathVariable(name = "age", required = true) Integer age) {
        return studentRepository.findByAge(age);
    }

    @PostMapping(path = "/students/find")
    public List<Student> find(@RequestParam(name = "name", required = false) String name,
                              @RequestParam(name = "age", required = false) Integer age) {
        Student stu = new Student(name, age);

        // 创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching();
        // 改变默认字符串匹配方式：模糊查询
        matcher.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        // 改变默认大小写忽略方式：忽略大小写
        matcher.withIgnoreCase(true);
        matcher.withIgnoreNullValues();

//        if (StringUtils.isNotBlank(name)) {
            // name采用“模糊”的方式查询
            matcher.withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith());
//        }
//        if (null != age) {
            // age采用精确匹配
            matcher.withMatcher("age", ExampleMatcher.GenericPropertyMatchers.exact());
//        }

        Example<Student> example = Example.of(stu, matcher);
        return studentRepository.findAll(example);
    }

}
