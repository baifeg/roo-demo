package com.eadp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.eadp.config.MyJpaRepositoryImpl;
import com.slyak.spring.jpa.FreemarkerSqlTemplates;
import com.slyak.spring.jpa.GenericJpaRepositoryFactoryBean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * = EadpApplication
 *
 * TODO Auto-generated class documentation
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.eadp", repositoryBaseClass = MyJpaRepositoryImpl.class, repositoryFactoryBeanClass = GenericJpaRepositoryFactoryBean.class)
@EnableSwagger2
@EnableCaching
public class EadpApplication {

    /**
     * TODO Auto-generated method documentation
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EadpApplication.class, args);
    }

	@Bean
	public FreemarkerSqlTemplates freemarkerSqlTemplates() {
		FreemarkerSqlTemplates templates = new FreemarkerSqlTemplates();
		templates.setSuffix(".sftl");
		return templates;
	}
}
