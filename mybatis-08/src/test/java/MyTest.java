
import com.zhu.dao.BlogMapper;
import com.zhu.pojo.Blog;
import com.zhu.utils.IdUtils;
import com.zhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void test(){
        System.out.println(IdUtils.getId());
        System.out.println(IdUtils.getId());
        System.out.println(IdUtils.getId());
    }

    @Test
    public void addInitBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId( IdUtils.getId());
        blog.setTitle( "Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime ( new Date( ));
        blog.setViews (9999) ;

        mapper.addBlog(blog);

        blog.setId( IdUtils.getId());
        blog.setTitle( "Java如此简单");
        mapper.addBlog(blog);

        blog.setId( IdUtils.getId());
        blog.setTitle( "spring如此简单");
        mapper.addBlog(blog);

        blog.setId( IdUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
}

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
//        map.put("title","Java如此简单");
        map.put("author","狂神说");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();

    }
    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("title","Java如此简单");
        hashMap.put("author","狂神说");
        hashMap.put("views","9999");
        //<choose>只会执行其中一个
        List<Blog> blogs = mapper.queryBlogChoose(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("title","Java如此简单");
        hashMap.put("author","狂神说2");
        hashMap.put("views","9234234");
        hashMap.put("id","ea6e7cf707204f8fb5c27f0e56658539");
        //<choose>只会执行其中一个
        int i = mapper.updateBlog(hashMap);
        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<String> ids = new ArrayList<>();
        ids.add("ea6e7cf707204f8fb5c27f0e56658539");
        ids.add("0ed657ce1e264fe082b740bd884327af");
        ids.add("86301c8ddf2447be800dfcab50324cb4");
        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();

    }

}
