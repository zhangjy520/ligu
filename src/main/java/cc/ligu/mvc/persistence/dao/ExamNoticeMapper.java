package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.ExamNotice;
import cc.ligu.mvc.persistence.entity.ExamNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamNoticeMapper {
    int deleteByExample(ExamNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamNotice record);

    int insertSelective(ExamNotice record);

    List<ExamNotice> selectByExample(ExamNoticeExample example);

    ExamNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamNotice record, @Param("example") ExamNoticeExample example);

    int updateByExample(@Param("record") ExamNotice record, @Param("example") ExamNoticeExample example);

    int updateByPrimaryKeySelective(ExamNotice record);

    int updateByPrimaryKey(ExamNotice record);
}