package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author weidong Xue
 * @date 2018/11/19  22:20
 */
public interface IMemberDao {


    /**
     * 根据id查询会员信息
     * @param id
     * @return
     */
    @Select("select * from member where id = #{id}")
    public Member findById(String id);
}
