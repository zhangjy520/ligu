package cc.ligu.mvc.persistence.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiMapper {
    //获取下拉列表的数据集合。0 承包公司/ 1隶属单位
    List<String> getAllSelect(@Param("type") int type);
}