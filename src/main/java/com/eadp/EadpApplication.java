package com.eadp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.slyak.spring.jpa.FreemarkerSqlTemplates;
import com.slyak.spring.jpa.GenericJpaRepositoryFactoryBean;
import com.slyak.spring.jpa.GenericJpaRepositoryImpl;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.cache.annotation.EnableCaching;

/**
 * = EadpApplication
 *
 * TODO Auto-generated class documentation
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.eadp", repositoryBaseClass = GenericJpaRepositoryImpl.class, repositoryFactoryBeanClass = GenericJpaRepositoryFactoryBean.class)
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
