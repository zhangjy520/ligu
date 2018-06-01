package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.persistence.entity.Source;
import com.github.pagehelper.PageInfo;

public interface SourceService {
    PageInfo<Source> listAllSource(int pageSize, int pageNum, Source source);

    int saveSource(Source source);

    Source selectSourceByPrimary(int sourceId);

    int deleteSource(Source source);
}
