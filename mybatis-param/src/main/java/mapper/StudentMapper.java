package mapper;

import pojo.Student;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface StudentMapper {

    int insertByPojo(Student student);
    int insertStudentByMap(Map<String, Object> map);
    List<Student> selectById(Long id);

    List<Student> selectByName(String name);

    List<Student> selectByBirth(Date birth);

    List<Student> selectBySex(Character sex);
}
