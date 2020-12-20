import com.zhu.dao.BlogMapper;
import com.zhu.dao.UserMapper;
import com.zhu.pojo.Blog;
import com.zhu.pojo.User;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void queryUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.queryUserById(1);
        User user2 = mapper.queryUserById(1);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println("============");
        System.out.println(user1 == user2);
        sqlSession.close();
    }

    @Test
    public void queryUserById2(){
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user1 = mapper1.queryUserById(1);
        sqlSession1.close();

        User user2 = mapper2.queryUserById(1);
        sqlSession2.close();

        System.out.println(user1);
        System.out.println(user2);
        System.out.println("============");
        System.out.println(user1 == user2);

    }

    @Test
    public void queryUserById3(){
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        BlogMapper mapper2 = sqlSession1.getMapper(BlogMapper.class);

        User user1 = mapper1.queryUserById(1);

        HashMap map = new HashMap();
        ArrayList<String> ids = new ArrayList<>();
        ids.add("ea6e7cf707204f8fb5c27f0e56658539");
        ids.add("0ed657ce1e264fe082b740bd884327af");
        ids.add("86301c8ddf2447be800dfcab50324cb4");
        map.put("ids",ids);
        List<Blog> blogs1 = mapper2.queryBlogForeach(map);

        sqlSession1.close();


        UserMapper mapper3 = sqlSession2.getMapper(UserMapper.class);
        BlogMapper mapper4 = sqlSession2.getMapper(BlogMapper.class);

        User user2 = mapper3.queryUserById(1);

        List<Blog> blogs2 = mapper4.queryBlogForeach(map);

        System.out.println(user1 == user2);
        System.out.println(blogs1 == blogs2);

        sqlSession2.close();
    }



}
