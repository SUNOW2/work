package com.cloud.work.order.controller;

import com.cloud.work.core.R;
import com.cloud.work.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：订单控制层
 *
 * @ClassName OrderController
 * @Author 徐旭
 * @Date 2020-05-25 16:50
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 基于@Transactional和Hystrix实现的事务一致性
     *
     * @return
     * @throws Exception
     */
    @GetMapping("insert")
    public R insert() throws Exception {
        return orderService.insert();
    }

    /**
     * 基于seata实现的事务一致
     *
     * @return
     */
    @GetMapping("insertBySeaTa")
    public R insertBySeaTa() {
        return orderService.insertBySeaTa();
    }
}
