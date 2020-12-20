package com.zhu.Dao;

import com.zhu.POJO.User;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testGetUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",2);

        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void testGetUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //通过RowBounds实现
        RowBounds rowBounds = new RowBounds(0, 2);
        //通过java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.zhu.Dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test(){
        //1.获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        logger.info("info:进入了test()");

        try{
          UserMapper mapper = sqlSession.getMapper(UserMapper.class);
          User user = mapper.getUserById(3);
          System.out.println(user);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }

    }

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

}
