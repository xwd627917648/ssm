package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author weidong Xue
 * @date 2018/11/19  22:23
 */
public interface ITravellerDao {


    /**
     * 查询某一订单中的游客信息
     * @param orderId
     * @return
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{orderId})")
    public List<Traveller> findByOrdersId(String orderId);
}
