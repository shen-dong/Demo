package com.shen.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.shen.demo.common.ConstUtil;
import com.shen.demo.dao.entity.Item;
import com.shen.demo.dao.mapper.ItemMapper;
import com.shen.demo.dao.vo.InsertItemVo;
import com.shen.demo.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shen
 * @date 2021/11/17 21:33
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Override
    public Item queryItemByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        return itemMapper.queryItemByName(name);
    }

    @Override
    public String insertItem(InsertItemVo insertItemVo) {
        Item item = new Item();
        BeanUtil.copyProperties(insertItemVo, item, true);
        //check if already existed same item
        if (queryItemByName(item.getName()) != null) {
            return ConstUtil.REPEAT_NAME_MSG;
        }
        boolean insertFlag = itemMapper.insertItem(item);
        return insertFlag ? ConstUtil.INSERT_SUCCESS_MSG : ConstUtil.INSERT_FAIL_MSG;
    }

    @Override
    public String deleteItemByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return ConstUtil.REQUEST_EMPTY_MSG;
        }
        boolean deleteFlag = itemMapper.deleteItemByName(name);
        return deleteFlag ? ConstUtil.DELETE_SUCCESS_MSG : ConstUtil.NO_ITEM_DELETE_MSG;
    }

    @Override
    public String updateItemById(Item item) {
        //check need update content
        if (StringUtils.isBlank(item.getName())
                && item.getPrice() == null
                && StringUtils.isBlank(item.getData())) {
            return ConstUtil.UPDATE_CONTENT_EMPTY_MSG;
        }
        //check id whether existed
        if (itemMapper.queryItemById(item.getId()) == null) {
            return ConstUtil.NOT_EXISTED_MSG;
        }
        itemMapper.updateItem(item);
        return ConstUtil.UPDATE_SUCCESS_MSG;
    }
}
