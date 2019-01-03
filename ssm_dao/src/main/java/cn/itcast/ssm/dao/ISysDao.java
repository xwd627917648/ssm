package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;

/**
 * @author weidong Xue
 * @date 2018/11/24  13:16
 */
public interface ISysDao {


    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method)" +
            " values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);
}
