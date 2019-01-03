package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author weidong Xue
 * @date 2018/11/20  17:51
 */
public interface IRoleDao {


    /**
     * 根据用户表的id查询用户所对应的角色
     * @param roleId
     * @return   返回的是一个角色对象集合
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{roleId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,
            many = @Many(select = "cn.itcast.ssm.dao.IPermissionDao.findById"))
    })
    public List<Role> findByUsersId(String roleId);


    /**
     * 查询所有角色的信息
     * @return
     */
    @Select("select * from role")
    List<Role> findAll();


    /**
     * 添加新的角色
     * @param role
     */
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);


    /**根据用户的id
     * 查询用户没有的权限
     * @param userId
     * @return
     */
    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRole(String userId);


    /**
     * 根据id查询角色
     * @param roleId
     * @return
     */
    @Select("select * from role where id = #{roleId} ")
    Role findById(String roleId);



    @Insert("insert into role_permission(permissionId,roleId) values(#{permissionId},#{roleId})")
    void addPermission(@Param("roleId") String roleId,@Param("permissionId") String permisssionId);
}
























