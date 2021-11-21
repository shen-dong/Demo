package com.shen.demo.controller;

import com.shen.demo.dao.entity.Item;
import com.shen.demo.dao.vo.*;
import com.shen.demo.service.ItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ItemController {

    @Resource
    private ItemService itemService;

    @PostMapping("/queryItemByName")
    public BaseResponse<Item> queryItemByName(@RequestBody BaseRequest<String> request) {
        Item data = itemService.queryItemByName(request.getData());
        return BaseResponse.success(data);
    }

    @PostMapping("/insertItem")
    public BaseResponse<String> insertItem(@RequestBody BaseRequest<InsertItemVo> request) {
        String data = itemService.insertItem(request.getData());
        return BaseResponse.success(data);
    }

    @PostMapping("/deleteItemByName")
    public BaseResponse<String> deleteItemByName(@RequestBody BaseRequest<String> request) {
        String data = itemService.deleteItemByName(request.getData());
        return BaseResponse.success(data);
    }

    @PostMapping("/updateItemById")
    public BaseResponse<String> updateItemById(@RequestBody BaseRequest<Item> request) {
        String data = itemService.updateItemById(request.getData());
        return BaseResponse.success(data);
    }
}
