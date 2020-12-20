
import com.zhu.Dao.StudentMapper;
import com.zhu.Dao.TeacherMapper;
import com.zhu.POJO.Student;
import com.zhu.POJO.Teacher;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void getAllStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getAllStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();


    }

    @Test
    public void getAllStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getAllStudent2();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();

    }
}
