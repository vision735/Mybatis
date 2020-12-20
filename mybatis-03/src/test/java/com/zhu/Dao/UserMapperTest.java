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
          UserMapper mapper = sqlSession.getMapper(UserMapper.class);
          User user = mapper.getUserById(2);
          System.out.println(user);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }

    }

}
