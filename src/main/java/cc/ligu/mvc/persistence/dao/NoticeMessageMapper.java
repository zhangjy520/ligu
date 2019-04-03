package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.NoticeMessage;
import cc.ligu.mvc.persistence.entity.NoticeMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeMessageMapper {
    int deleteByExample(NoticeMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NoticeMessage record);

    int insertSelective(NoticeMessage record);

    List<NoticeMessage> selectByExample(NoticeMessageExample example);

    NoticeMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NoticeMessage record, @Param("example") NoticeMessageExample example);

    int updateByExample(@Param("record") NoticeMessage record, @Param("example") NoticeMessageExample example);

    int updateByPrimaryKeySelective(NoticeMessage record);

    int updateByPrimaryKey(NoticeMessage record);

    int insertSelectiveDuUpdate(NoticeMessage record);
}