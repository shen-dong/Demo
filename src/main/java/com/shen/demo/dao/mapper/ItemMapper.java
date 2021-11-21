package com.shen.demo.dao.mapper;

import com.shen.demo.dao.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author shen
 * @date 2021/11/18 16:43
 */
@Mapper
public interface ItemMapper {
    Item queryItemByName(String name);

    boolean insertItem(Item item);

    boolean deleteItemByName(String name);

    boolean updateItem(@Param("item") Item item);

    Item queryItemById(Integer id);
}
