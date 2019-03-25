package com.chinalife.cloud;

import org.activiti.spring.boot.JpaProcessEngineAutoConfiguration;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.autoconfigure.EndpointWebMvcAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.TraceWebFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.couchbase.CouchbaseDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.ldap.LdapDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.jest.JestAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.autoconfigure.RefreshEndpointAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.HystrixAutoConfiguration;
import org.springframework.cloud.netflix.metrics.spectator.SpectatorMetricsAutoConfiguration;
import org.springframework.cloud.netflix.rx.RxJavaAutoConfiguration;
import org.springframework.cloud.sleuth.annotation.SleuthAnnotationAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.messaging.TraceSpanMessagingAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.messaging.TraceSpringIntegrationAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.messaging.websocket.TraceWebSocketAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.scheduling.TraceSchedulingAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.web.client.TraceWebAsyncClientAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.web.client.TraceWebClientAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.zuul.TraceZuulAutoConfiguration;
import org.springframework.cloud.sleuth.metric.TraceMetricsAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springcloud webapplication initializer
 */
@SpringBootApplication(exclude = {JpaProcessEngineAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class, ActiveMQAutoConfiguration.class, CassandraAutoConfiguration.class,
        CassandraDataAutoConfiguration.class, CouchbaseDataAutoConfiguration.class, DataSourceAutoConfiguration.class,
        ElasticsearchAutoConfiguration.class, JestAutoConfiguration.class, JmsAutoConfiguration.class,
        LdapDataAutoConfiguration.class, MailSenderAutoConfiguration.class, MongoAutoConfiguration.class,
        MongoDataAutoConfiguration.class, RabbitAutoConfiguration.class, RedisAutoConfiguration.class,
        SolrAutoConfiguration.class, SessionAutoConfiguration.class, FreeMarkerAutoConfiguration.class,
        AopAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class,
        ElasticsearchDataAutoConfiguration.class, ElasticsearchRepositoriesAutoConfiguration.class,
        WebMvcAutoConfiguration.class, ErrorMvcAutoConfiguration.class, EndpointWebMvcAutoConfiguration.class,
        GroovyTemplateAutoConfiguration.class, GsonAutoConfiguration.class, HystrixAutoConfiguration.class,
        JacksonAutoConfiguration.class, JdbcTemplateAutoConfiguration.class, JmxAutoConfiguration.class,
        RefreshEndpointAutoConfiguration.class, RxJavaAutoConfiguration.class, SecurityAutoConfiguration.class,
        SecurityFilterAutoConfiguration.class, SleuthAnnotationAutoConfiguration.class,
        //SleuthHystrixAutoConfiguration.class, 
        SpectatorMetricsAutoConfiguration.class, ThymeleafAutoConfiguration.class,
        SpringDataWebAutoConfiguration.class, TransactionAutoConfiguration.class,
        DispatcherServletAutoConfiguration.class,
        ManagementWebSecurityAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class,
        WebSocketAutoConfiguration.class, WebClientAutoConfiguration.class,
        TraceZuulAutoConfiguration.class, TraceWebSocketAutoConfiguration.class, TraceWebFilterAutoConfiguration.class,
        TraceWebClientAutoConfiguration.class, //TraceWebAutoConfiguration.class,
        TraceWebAsyncClientAutoConfiguration.class, TraceSpringIntegrationAutoConfiguration.class,
        TraceSpanMessagingAutoConfiguration.class, TraceSchedulingAutoConfiguration.class,
        TraceMetricsAutoConfiguration.class, //TraceHttpAutoConfiguration.class,
        EmbeddedServletContainerAutoConfiguration.class, //TraceFeignClientAutoConfiguration.class,
        LoadBalancerAutoConfiguration.class})
@EnableDiscoveryClient
@Configuration
@ImportResource(locations = {"classpath:web-application-context.xml"})
@RestController
@RequestMapping(value = "/webappinit")
@EnableFeignClients(basePackages = {"com.chinalife.cloud",
        "com.chinalife.contract.interf.cloudclient",
        "com.chinalife.rbac.service",
        "com.chinalife.basecode.service"})
public class WebAppInitializer extends SpringBootServletInitializer implements WebApplicationInitializer {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);

    /**
     * config
     *
     * @param builder a builder for the application context
     * @return the application builder
     */
    // @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        if (logger.isInfoEnabled()) {
            logger.info("listenServerPort=" + System.getenv("listenServerPort"));
            logger.info("registryCenterUrl=" + System.getenv("registryCenterUrl"));
        }
        return builder;
    }

    /**
     * showRegistryCenterUrl
     *
     * @return showRegistryCenterUrl
     */
    @RequestMapping(value = "/showRegistryCenterUrl")
    public String showRegistryCenterUrl() {
        return System.getenv("registryCenterUrl");
    }
}
