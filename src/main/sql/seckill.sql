-- 执行秒杀的存储过程
# ;转换为$$
DELIMITER $$
# --定义存储过程
# --ROW_COUNT () :修改类型的影响行数  0：未修改 大于0的表示修改的行数 小于0：执行错误或者未执行sql
CREATE PROCEDURE `seckill`.`execute_seckill`
  (in v_seckill_id bigint,in v_phone bigint,in v_kill_time TIMESTAMP ,out r_result int)
  BEGIN
    DECLARE insert_count int DEFAULT 0;
    START TRANSACTION ;
    INSERT ignore into success_killed
      (seckill_id,user_phone,create_time)
    VALUES
      (v_seckill_id,v_phone,v_kill_time);
    SELECT  ROW_COUNT () INTO  insert_count;
    IF (insert_count=0) THEN
      ROLLBACK ;
      SET r_result = -1 ;
    ELSEIF(insert_count<0) THEN
      ROLLBACK ;
      SET r_result = -2;
    ELSE
      UPDATE seckill SET number =number -1 WHERE seckill_id = v_seckill_id
        AND end_time > v_kill_time
        AND start_time < v_kill_time
        AND number > 0;
      SELECT  ROW_COUNT () INTO  insert_count;
        IF (insert_count=0) THEN
            ROLLBACK ;
            SET r_result = 0 ;
        ELSEIF(insert_count<0) THEN
            ROLLBACK ;
            SET r_result = -2;
        ELSE
          COMMIT ;
          SET r_result = 1;
        END IF;
    END IF;
  END
$$
# --存储过程定义结束


DELIMITER ;
SET @r_result=-3;
# --执行存储过程
call execute_seckill(1003,13500008888,now(),@r_result);

# --获取结果
SELECT @r_result;

# 存储过程
# 1 存储过程优化：事务行锁持有时间
# 2 不要过度依赖存储过程
# 3 简单的逻辑可以应用存储过程