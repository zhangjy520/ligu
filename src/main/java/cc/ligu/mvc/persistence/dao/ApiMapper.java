package cc.ligu.mvc.persistence.dao;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface ApiMapper {
    String testse();

    //获取下拉列表的数据集合。0 承包公司/ 1隶属单位
    List<String> getAllSelect(@Param("type") int type);

    //获取所有的施工单位专业/中标公司的人员信息
    List<HashMap> getAllCompanyInfo();

    //获取这一批人的身份分布（多少个*管理员，多少个普通员工）
    List<HashMap> getAllRoleInfo(@Param("idList") List<String> idList);

    //获取这一批人某个月的考试情况（多少个通过考试，多少个未通过考试）
    List getAllPass(@Param("idList") List<String> idList, @Param("passScore") Integer passScore, @Param("examTime") String examTime);
}