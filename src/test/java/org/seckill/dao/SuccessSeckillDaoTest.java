package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessSeckilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by wyj on 2017/5/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessSeckillDaoTest {
    @Resource
    private SuccessSeckillDao successSeckillDao;

    @Test
    public void insertSuccessSeckilled() throws Exception {
        long id = 1001L;
        long phone = 15576256422L;
        int insertCount = successSeckillDao.insertSuccessSeckilled(id,phone);
        System.out.println("insertCount =:"+insertCount);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long id = 1001L;
        long phone = 15576256422L;
        SuccessSeckilled successSeckilled = successSeckillDao.queryByIdWithSeckill(id,phone);
        System.out.println(successSeckilled);
        System.out.println(successSeckilled.getSeckill());
    }

}