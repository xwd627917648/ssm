package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author weidong Xue
 * @date 2018/11/20  13:40
 */
public interface IUserInfoDao {


    /**
     * 根据用户名查询用户的信息
     * @param username
     * @return
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles" ,column = "id",javaType = java.util.List.class,
                    many =@Many(select = "cn.itcast.ssm.dao.IRoleDao.findByUsersId"))
    })
    public UserInfo findByUsername(String username);


    /**
     * 查询用户信息
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll();


    /**
     * 添加新用户
     * @param userInfo
     */
    @Insert("insert into users(email,username,password,phoneNum,status)" +
            " values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);


    /**
     * 查询用户详情
     * @param id
     * @return
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles" ,column = "id",javaType = java.util.List.class,
                    many =@Many(select = "cn.itcast.ssm.dao.IRoleDao.findByUsersId"))
    })
    public UserInfo findById(String id);


    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     */
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    public void addRole(@Param("userId") String userId,@Param("roleId")String roleId);
}
