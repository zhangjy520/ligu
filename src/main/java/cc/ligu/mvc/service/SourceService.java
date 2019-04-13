package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.persistence.entity.Source;
import cc.ligu.mvc.persistence.entity.UserView;
import com.github.pagehelper.PageInfo;

public interface SourceService {
    PageInfo<Source> listAllSource(int pageSize, int pageNum, Source source);

    //根据文档类型获取文档数据 0全部 1安全生产视频课程 2安全生产培训文档 3安全生产安全守则
    // 4施工工艺视频课程 5施工工艺培训文档 6施工工艺工艺示例 7H5图文资料 type传0查非h5 1只查h5
    PageInfo<Source> listAllSourceByType(int pageSize, int pageNum, Source source,int type);

    int saveSource(Source source, UserView userView);

    Source selectSourceByPrimary(int sourceId);

    int deleteSource(Source source);
}
