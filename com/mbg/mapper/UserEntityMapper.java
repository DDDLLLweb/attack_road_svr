package com.mbg.mapper;

import com.mbg.entity.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserEntityMapper {
    @Delete({
        "delete from s_user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into s_user (user_id, username, ",
        "password, salt, ",
        "create_time, update_time)",
        "values (#{userId,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{salt,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIME}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserEntity record);

    @InsertProvider(type=UserEntitySqlProvider.class, method="insertSelective")
    int insertSelective(UserEntity record);

    @Select({
        "select",
        "user_id, username, password, salt, create_time, update_time",
        "from s_user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIME),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserEntity selectByPrimaryKey(Integer userId);

    @UpdateProvider(type=UserEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserEntity record);

    @Update({
        "update s_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIME},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserEntity record);
}