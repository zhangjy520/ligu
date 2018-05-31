package cc.ligu.test.service.impl;

import cc.ligu.test.persistence.entity.DocQuestion;
import cc.ligu.test.persistence.dao.DocQuestionMapper;
import cc.ligu.test.service.DocQuestionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 题库表 服务实现类
 * </p>
 *
 * @author zjy
 * @since 2018-05-31
 */
@Service
public class DocQuestionServiceImpl extends ServiceImpl<DocQuestionMapper, DocQuestion> implements DocQuestionService {

}
