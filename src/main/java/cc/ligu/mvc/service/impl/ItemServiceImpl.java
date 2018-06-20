package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.ItemMapper;
import cc.ligu.mvc.persistence.entity.Item;
import cc.ligu.mvc.persistence.entity.ItemExample;
import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.persistence.entity.QuestionExample;
import cc.ligu.mvc.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class ItemServiceImpl extends BasicService implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    @Override
    public PageInfo<Item> listAllItem(int pageSize, int pageNum, Item item) {
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();

        if (!StringUtils.isEmpty(item.getName())) {
            criteria.andNameLike("%" + item.getName() + "%");
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Item> itemList = itemMapper.selectByExample(itemExample);
        PageInfo<Item> page = new PageInfo<Item>(itemList);
        return page;
    }

    @Override
    public List<Item> listAllItem() {
        ItemExample example = new ItemExample();
        example.createCriteria().andDelFlagEqualTo(0);
        return itemMapper.selectByExample(example);
    }

    @Override
    public int saveItem(Item item) {
        if (StringUtils.isEmpty(item.getId())) {
            item.setCreateBy(9999);//创建人
            item.setCreateDate(System.currentTimeMillis());//创建时间
            itemMapper.insertSelective(item);
        } else {
            item.setUpdateBy(9999);
            item.setUpdateDate(System.currentTimeMillis());
            itemMapper.updateByPrimaryKeySelective(item);
        }
        return 1;
    }

    @Override
    public Item selectItemByPrimary(int itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public int deleteItem(Item item) {
        return itemMapper.deleteByPrimaryKey(item.getId());
    }
}
