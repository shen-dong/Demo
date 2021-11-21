package com.shen.demo.service;

import com.shen.demo.dao.entity.Item;
import com.shen.demo.dao.vo.InsertItemVo;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public interface ItemService {
    /**
     * query item by name
     */
    Item queryItemByName(@NotNull String name);

    /**
     * insert one item
     */
    String insertItem(@NotNull InsertItemVo insertItemVo);

    /**
     * delete one item by name
     */
    String deleteItemByName(@NotNull String name);

    /**
     * update one item by id
     */
    String updateItemById(@NotNull Item item);
}
