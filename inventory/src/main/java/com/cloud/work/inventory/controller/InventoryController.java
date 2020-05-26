package com.cloud.work.inventory.controller;

import com.cloud.work.core.R;
import com.cloud.work.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：库存控制层
 *
 * @ClassName InventoryController
 * @Author 徐旭
 * @Date 2020-05-25 17:20
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping(value = "insert")
    public R insert() throws Exception {
        return service.insert();
    }
}
