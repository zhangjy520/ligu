package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.Item;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ItemService {
    PageInfo<Item> listAllItem(int pageSize, int pageNum, Item item);

    List<Item> listAllItem();

    int saveItem(Item item);

    Item selectItemByPrimary(int itemId);

    int deleteItem(Item item);
}
