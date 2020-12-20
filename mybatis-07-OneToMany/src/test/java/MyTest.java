import com.zhu.Dao.TeacherMapper;
import com.zhu.POJO.Teacher;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void getTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = mapper.getTeacher();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
        sqlSession.close();

    }

    @Test
    public void getTeacherById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherById(2);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void getTeacherById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherById2(1);
        System.out.println(teacher);
        sqlSession.close();

    }
}
