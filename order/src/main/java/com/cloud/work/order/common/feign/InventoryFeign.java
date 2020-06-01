package com.cloud.work.order.common.feign;

import com.cloud.work.core.R;
import com.cloud.work.order.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 描述：调用库存的feignClient
 *
 * @ClassName InventoryFeign
 * @Author 徐旭
 * @Date 2020-05-25 17:31
 * @Version 1.0
 */
@FeignClient(name = "inventory", configuration = FeignConfiguration.class)
@Repository
public interface InventoryFeign {

    @GetMapping("/inventory/insert")
    R insert();
}
