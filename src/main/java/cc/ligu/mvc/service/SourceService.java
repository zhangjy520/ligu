package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.persistence.entity.Source;
import cc.ligu.mvc.persistence.entity.UserView;
import com.github.pagehelper.PageInfo;

public interface SourceService {
    PageInfo<Source> listAllSource(int pageSize, int pageNum, Source source);

    int saveSource(Source source, UserView userView);

    Source selectSourceByPrimary(int sourceId);

    int deleteSource(Source source);
}
