package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author weidong Xue
 * @date 2018/11/18  11:02
 */
public interface IProductDao {


    /**
     * 查询所有产品信息的方法
     * @return
     */
    @Select("select * from product")
    public List<Product> findProductAll();


    /**
     * 添加新的商品信息
     * @param product
     */
    @Insert("insert into " +
            " product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            " values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice}," +
            " #{productDesc},#{productStatus})")
    void save(Product product);


    /**
     * 根据id查询产品
     * @param id
     * @return
     */
    @Select("select * from product where id = #{id}")
    public Product findById(String id);
}
