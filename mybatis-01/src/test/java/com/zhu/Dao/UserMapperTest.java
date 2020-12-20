package com.zhu.Dao;

import com.zhu.POJO.User;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserLike("芒%");
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
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

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println( mapper.getUserById(1));

        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(4,"西瓜","43967777"));
        if (res>0){
            System.out.println("插入了新数据");
        }
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.updateUser(new User(4,"厂长","4396"));
        if (res>0){
            System.out.println("修改成功");
        }
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(4);
        if (res>0){
            System.out.println("删除成功");
        }
        sqlSession.commit();

        sqlSession.close();
    }
}
