package com.flyou.controller;

import com.flyou.bean.SSBean;
import com.flyou.bean.SSRespository;
import com.flyou.model.SSAccountModel;
import com.flyou.model.SSAccountModelImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ScheduledTasks {
    @Autowired
    private SSRespository ssRespository;
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    SSAccountModel ssAccountModel;

    @Scheduled(cron = "0 0/15 0,6,12,18 * * *" )
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        ssAccountModel = new SSAccountModelImpl();
        List<SSBean> ssAccount = ssAccountModel.getSSAccount();
        if (ssAccount == null || ssAccount.size() == 0) {
            log.info("爬取得信息：{}", "爬取失败");
        } else {
            log.info("爬取得信息：{}", ssAccount.toString());
            ssRespository.deleteAll();
            ssRespository.save(ssAccount);
        }


    }


}