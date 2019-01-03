package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author weidong Xue
 * @date 2018/11/22  13:46
 */
public interface IPermissionDao {


    /**
     * 查询角色所对应的权限
     * @param id
     * @return
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id} )")
    List<Permission> findById(String id);


    /**
     * 查询所有的权限
     * @return
     */
    @Select("select * from permission")
    List<Permission> findAll();


    /**
     * 添加权限
     * @param permission
     */
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);


    /**
     * 查询用户没有的权限
     * @param roleId
     * @return
     */
    @Select("select *from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermission(String roleId);
}
