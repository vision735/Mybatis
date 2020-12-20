package com.zhu.dao;

import com.zhu.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface  BlogMapper {
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);


    List<Blog> queryBlogChoose(Map map);

    List<Blog> queryBlogForeach(Map map);

    int updateBlog(Map map);



}
