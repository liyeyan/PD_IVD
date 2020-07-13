package com.flf.task;

import com.flf.entity.Email;
import com.flf.service.RuleService;
import com.flf.service.WarnService;
import com.flf.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Properties;

@Component("TaskJob")
public class RuleTask {

    @Autowired
    private RuleService ruleService;
    @Autowired
    private WarnService warnService;

    @Scheduled(cron = "*/1 * * * * ?")
    public void show() throws Exception {
        //System.err.println("================定时任务执行 "+new Date()+"==========");

        /*Properties props = new Properties();
        props= PropertiesLoaderUtils.loadAllProperties("config.properties");
        Email email = new Email("408441203@qq.com","【测试】","上机芯片数据与中间表数量不符");
        email.setHost( props.getProperty("sftp.host"));
        email.setPort(props.getProperty("sftp.port"));
        email.setUsername(props.getProperty("sftp.username"));
        email.setPassword(props.getProperty("sftp.password"));
        EmailUtils.sendEmail(email);//没问题*/
    }

}
