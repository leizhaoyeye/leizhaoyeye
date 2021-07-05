package com.example.zhaolei.util;

//import com.dbappsecurity.web.BusinessException;
import lombok.extern.slf4j.Slf4j;
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @ClassName: AuthKrb5
 * @Description: authKrb5认证工具
 * @author: xingliang.hou
 * @date: 2020/6/5 18:30
 * @Copyright: 2019 www.dbappsecurity.com.cn. All rights reserved.
 */
@Slf4j
public class AuthKrb5Util {

    private static final String HIVE_DRIVER = "org.apache.hive.jdbc.HiveDriver";
    private static final String URL = "jdbc:hive2://24.1.11.2:10000/anheng_hive;principal=hive/host@DC1.FH.COM;hive.server2.proxy.user=anheng?mapred.job.queue.name=root.ah.anheng";

   /* public static void authKrb5() {
        log.debug("authKrb5认证开始");
        //设置jvm启动时krb5的读取路径参数
        System.setProperty("java.security.krb5.conf", "/usr/local/app/conf/krb5.conf");
        //配置kerberos认证
        Configuration conf = new Configuration();
        conf.setBoolean("hadoop.security.authorization", true);
        conf.set("hadoop.security.authentication", "Kerberos");
        UserGroupInformation.setConfiguration(conf);
        try {
            UserGroupInformation
                    .loginUserFromKeytab("anheng@DC1.FH.COM", "/usr/local/app/conf/anheng.keytab");
        } catch (IOException e) {
            log.error("authKrb5认证失败!", e);
            throw new BusinessException("authKrb5认证失败");
        }
    }

    public static Connection getConnection() throws Exception{
        com.dbappsecurity.economy.util.AuthKrb5Util.authKrb5();
        Class.forName(HIVE_DRIVER);
        Connection connection = DriverManager.getConnection(URL);
        return connection;
    }*/



}
