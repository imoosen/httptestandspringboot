package com.imoosen.test.controller;


import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 * Created by Administrator on 2017/6/25.
 */
@Configuration
@EnableScheduling
public class SchedulingQuart {
    private final Logger log = org.slf4j.LoggerFactory.getLogger(SchedulingQuart.class);
    @Scheduled(cron="0/3 * * * * ?")
   public void show(){
      log.info("<<<<<媳妇我爱你>>>>>"+ new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒" ).format(new Date()));
    }
}
