package com.zhu.Dao;

import com.zhu.POJO.User;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {


    @Test
    public void test(){
        //1.获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try{
            //方式一：getMapper执行sql
          UserMapper mapper = sqlSession.getMapper(UserMapper.class);
          List<User> userList = mapper.getUserList();

//            //方式二：不推荐使用
//            List<User> userList = sqlSession.selectList("com.zhu.Dao.UserMapper.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }

    }

}
