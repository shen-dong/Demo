package com.shen.demo;

import com.shen.demo.controller.ItemController;
import com.shen.demo.dao.entity.Item;
import com.shen.demo.dao.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
@Slf4j
class DemoApplicationTests {
    @Resource
    private ItemController itemController;

    @Test
    void testQuery() {
        BaseRequest<String> request = new BaseRequest<>(null, "phone");
        BaseResponse<Item> response = itemController.queryItemByName(request);

        log.info("request: {}, response: {}", request, response);
    }

    @Test
    void testInsert() {
        BaseRequest<InsertItemVo> request = new BaseRequest<>();
        InsertItemVo insertItemVo = new InsertItemVo("pen", new BigDecimal("2.88"), "a new pen");
        request.setData(insertItemVo);
        BaseResponse<String> response = itemController.insertItem(request);

        log.info("request: {}, response: {}", request, response);
    }

    @Test
    void testDelete() {
        BaseRequest<String> request = new BaseRequest<>(null, "pen");
        BaseResponse<String> response = itemController.deleteItemByName(request);

        log.info("request: {}, response: {}", request, response);
    }

    @Test
    void testUpdate() {
        BaseRequest<Item> request = new BaseRequest<>();
        Item item = Item.builder()
                .id(3)
                .price(new BigDecimal("998"))
                .build();
        request.setData(item);
        BaseResponse<String> response = itemController.updateItemById(request);

        log.info("request: {}, response: {}", request, response);
    }
}
