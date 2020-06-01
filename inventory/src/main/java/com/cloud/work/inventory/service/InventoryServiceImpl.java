package com.cloud.work.inventory.service;

import com.cloud.work.inventory.entity.InventoryEntity;
import com.cloud.work.inventory.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述：库存实现类
 *
 * @ClassName InventoryHystrix
 * @Author 徐旭
 * @Date 2020-05-26 09:36
 * @Version 1.0
 */
@Service
public class InventoryServiceImpl {

    @Autowired
    private InventoryMapper mapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void insert() throws Exception {
        InventoryEntity entity = new InventoryEntity();
        mapper.insert(entity);
        insert2();
        throw new Exception();
    }

    /**
     * 测试@Transactional的传播属性
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void insert2() {
        InventoryEntity entity = new InventoryEntity().setId(2L).setCount(100L);
        mapper.insert(entity);
    }
}
