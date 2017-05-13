package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static javafx.scene.input.KeyCode.L;
import static org.junit.Assert.*;

/**
 * Created by wyj on 2017/5/10.
 * 配置spring和junit整合,junit启动时加载spring ioc容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    //注入dao实现类
    @Resource
    private SeckillDao seckillDao;


    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> sckills = seckillDao.queryAll(0,100);
        for (Seckill seckill : sckills){
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() throws Exception {
        long seckillId = 1000L;
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(seckillId,killTime);
        System.out.println("updateCount="+updateCount);
    }

}