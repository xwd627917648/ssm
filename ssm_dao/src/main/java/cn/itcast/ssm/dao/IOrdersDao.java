package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Orders;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author weidong Xue
 * @date 2018/11/19  18:48
 */
public interface IOrdersDao {


    /**
     * 查询所有的订单
     * @return
     */
    @Select("select * from orders")
    @Results(value = {
            @Result( id =true,column = "id",property = "id"),
            @Result( column = "orderNum",property = "orderNum"),
            @Result( column = "orderTime",property = "orderTime"),
            @Result( column = "orderStatus",property = "orderStatus"),
            @Result( column = "productId",property = "product",
                    one = @One(select="cn.itcast.ssm.dao.IProductDao.findById")),

    })
    public List<Orders> findAll();


    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "productId", property = "product",
                    one = @One(select = "cn.itcast.ssm.dao.IProductDao.findById")),
            @Result(column = "memberId", property = "member",
                    one = @One(select = "cn.itcast.ssm.dao.IMemberDao.findById")),
            @Result(column = "id", property = "travellers",
                    one = @One(select = "cn.itcast.ssm.dao.ITravellerDao.findByOrdersId")),

    })
    public Orders findById(String id);




}





















