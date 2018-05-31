package cc.ligu.plus.controller;


import cc.ligu.common.entity.ResultEntity;
import cc.ligu.plus.persistence.dao.DocSourceMapper;
import cc.ligu.plus.persistence.entity.DocSource;
import cc.ligu.plus.service.IDocSourceService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 媒体资源表 前端控制器
 * </p>
 *
 * @author 你的名字
 * @since 2018-05-31
 */
@Controller
public class DocSourceController {
    @Autowired
    IDocSourceService iDocSourceService;
    @Autowired
    DocSourceMapper docSourceMapper;

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResultEntity uploads() {
        Page page = new Page(1, 1);
        EntityWrapper a = new EntityWrapper();
        a.setEntity(new DocSource());
        a.where("name like{0}", "%s%");
        DocSource sa = new DocSource();
        sa.setName("asaddsadsadsadsa");
        sa.selectAll();

        return ResultEntity.newErrEntity("");
    }
}

