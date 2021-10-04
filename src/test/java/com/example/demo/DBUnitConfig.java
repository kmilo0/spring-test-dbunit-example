package com.example.demo;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBUnitConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection(){
        DatabaseConfigBean dbConfigBean = new DatabaseConfigBean();
        dbConfigBean.setAllowEmptyFields(true);

        DatabaseDataSourceConnectionFactoryBean dbDataSourceConnectionFactoryBean =
                new DatabaseDataSourceConnectionFactoryBean(dataSource);
        dbDataSourceConnectionFactoryBean.setDatabaseConfig(dbConfigBean);
        return dbDataSourceConnectionFactoryBean;
    }

}
