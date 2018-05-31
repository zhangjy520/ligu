package cc.ligu.test.service.impl;

import cc.ligu.test.persistence.entity.DocSource;
import cc.ligu.test.persistence.dao.DocSourceMapper;
import cc.ligu.test.service.DocSourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 媒体资源表 服务实现类
 * </p>
 *
 * @author zjy
 * @since 2018-05-31
 */
@Service
public class DocSourceServiceImpl extends ServiceImpl<DocSourceMapper, DocSource> implements DocSourceService {

}
