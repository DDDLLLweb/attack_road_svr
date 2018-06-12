package com.el.demo.mapper;

import com.el.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author danfeng
 * @since 2018/1/25.
 *
 * @CacheConfig 该注解是用来开启声明的类参与缓存，
 * 如果方法内的@Cacheable注解没有添加key值，
 * 那么会自动使用cahceNames配置参数并且追加方法名
 */
public interface DemoUserMapper {

    @Select({
        "select ID id , USERNAME username, PASSWORD password ",
        "from s_user"
    })
    List<User> selectAll();

    @Select({
        "select USERNAME username ",
        "from s_user"
    })
    String selectStr();

    @Insert({
        "insert into s_user(",
        "username,password,deleteflag)",
        "values(#{username,jdbcType=NVARCHAR}," ,
        "#{password,jdbcType=NVARCHAR},#{deleteflag,jdbcType=NUMERIC})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(User user);
}
