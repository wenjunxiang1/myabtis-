import com.sun.javafx.collections.MappingChange;
import mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import utils.SqlSessionUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static utils.SqlSessionUtil.openSession;


public class StudentMapperTest {
    @Test
    public void testSelectById(){
        SqlSession sqlSession = openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students =  studentMapper.selectById(1L);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectByName(){
        SqlSession sqlSession = openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students =  studentMapper.selectByName("lisi");
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectByDate() throws ParseException {
        SqlSession sqlSession = openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        SimpleDateFormat simpleDateFormatf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = simpleDateFormatf.parse("2000-09-01");
        List<Student> students = studentMapper.selectByBirth(birth);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testInsertStudentByMap(){
        SqlSession sqlSession = openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id",3);
        map.put("姓名","赵六");
        map.put("年龄",15);
        map.put("身高",190);
        map.put("性别","男");
        map.put("生日",new Date());
        studentMapper.insertStudentByMap(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //根据pojo插入
    public void testInsertByPojo(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student(null,"张飞",50,189.9,new Date(),'男');
        studentMapper.insertByPojo(student);
        sqlSession.commit();
        sqlSession.close();
    }
}

