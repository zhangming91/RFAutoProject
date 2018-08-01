package com.bankhui;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.github.pagehelper.PageHelper;


@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = { "com.bankhui" })
@MapperScan({"com.bankhui.sys.dao"})
@ServletComponentScan(basePackages ={"com.bankhui" })
public class Application extends SpringBootServletInitializer {

	
	// DataSource配置
		@Bean
		@ConfigurationProperties(prefix = "spring.datasource")
		public DataSource dataSource() {
			return new com.alibaba.druid.pool.DruidDataSource();
		}

		// 提供SqlSeesion
		@Bean
		public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {

			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource);

			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

			sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis/**/*.xml"));
			 //PageHelper 分页插件
	        PageHelper pageHelper = new PageHelper();
	        Properties properties = new Properties();
	        properties.setProperty("reasonable", "true");
	        properties.setProperty("supportMethodsArguments", "true");
	        properties.setProperty("returnPageInfo", "check");
	        properties.setProperty("params", "count=countSql");
	        pageHelper.setProperties(properties);
	        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper });
			return sqlSessionFactoryBean.getObject();
		}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
