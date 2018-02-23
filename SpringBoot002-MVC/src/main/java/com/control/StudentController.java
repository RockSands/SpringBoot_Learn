package com.control;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "students")
public class StudentController {

    static List<Student> students = Collections.synchronizedList(new LinkedList<Student>());

    static {
	System.out.println("我是静态代码块!");
	students.add(new Student(1L, 12, "s1"));
	students.add(new Student(2L, 13, "s2"));
	students.add(new Student(3L, 14, "s3"));
    }

    /**
     * 查询
     * @ApiOperation 是Swagger2的说明标签
     */
    @ApiOperation(value="获取学生列表", notes="")
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> get() {
	return students;
    }

    /**
     * 增加
     * @RequestBody: 需要
     * Content-Type: application/json 且Body为Json串
     * 
     * Body样例:
     * {"id":4,"name":"mengzh","age":18}
     */
    @RequestMapping(method = RequestMethod.POST)
    public Student add(@RequestBody Student student) {
	System.out.println("新增前students的size:" + students.size());
	students.add(student);
	System.out.println("新增后students的size:" + students.size());
	return student;
    }

    /**
     * 更新
     * @PathVariable : 路径上的{}参数
     * @RequestParam : URL的参数,?xxx=yyy这种
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable long id, @RequestParam String name, @RequestParam int age) throws IOException {
	System.out.println("更新前:");
	students.forEach(student -> System.out.println(student.getName()));

	students.forEach(student -> {
	    if (id == student.getId()) {
		if (!StringUtils.isEmpty(name)) {
		    student.setName(name);
		}
		if (0 != age) {
		    student.setAge(age);
		}
	    }
	});

	System.out.println("更新后:");
	students.forEach(student -> System.out.println(student.getName()));

	return "success";
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id) {
	System.out.println("删除前students的size :" + students.size());
	for (Student student : students) {
	    if (id == student.getId()) {
		students.remove(student);
		break;
	    }
	}
	System.out.println("删除后students的size :" + students.size());
	return "success";
    }
}