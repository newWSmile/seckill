package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在使用者角度设计接口
 * 三个方面：
 * 1 方法定义粒度
 * 2 参数  越简便越好
 * 3 返回类型 类型要友好
 * Created by wyj on 2017/5/21
 */
public interface SeckillService {
    /**
     * c查询所有的秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启式时输出秒杀接口的地址，
     * 否则输出系统时间和秒杀时间
     * @param seckillId
     */
    Exposer exporttSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws  SeckillException,SeckillCloseException,RepeatKillException;
}
