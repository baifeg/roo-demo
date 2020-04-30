package com.eadp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import com.slyak.spring.jpa.FreemarkerSqlTemplates;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.slyak.spring.jpa.GenericJpaRepositoryFactoryBean;
import com.eadp.config.MyJpaRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;
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
public class EadpApplication {

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(Arrays.asList("Location"));
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }

    @Bean
    public FreemarkerSqlTemplates freemarkerSqlTemplates() {
        FreemarkerSqlTemplates templates = new FreemarkerSqlTemplates();
        templates.setSuffix(".sftl");
        return templates;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EadpApplication.class, args);
    }
}
