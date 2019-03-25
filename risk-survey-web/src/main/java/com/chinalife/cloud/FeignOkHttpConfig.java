package com.chinalife.cloud;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import okhttp3.ConnectionPool;

/**
 * okhttp configure
 *
 */
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOkHttpConfig {

    /**
     * readTimeout seconds
     */
    @Value("${feign.okhttp.readTimeout}")
    private Integer readTimeout;

    /**
     * connectTimeout seconds
     */
    @Value("${feign.okhttp.connectTimeout}")
    private Integer connectTimeout;

    /**
     * writeTimeout seconds
     */
    @Value("${feign.okhttp.writeTimeout}")
    private Integer writeTimeout;

    /**
     * okHttpClient instance
     * 
     * @return OkHttpClient
     */
    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new okhttp3.OkHttpClient.Builder().readTimeout(readTimeout, TimeUnit.SECONDS)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS).writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool()).build();
    }

    /**
     * request options
     * 
     * @return options
     */
    @Bean
    public Request.Options feignOptions() {
        return new Request.Options(connectTimeout * 1000, readTimeout * 1000);
    }

    /**
     * retryer
     * 
     * @return never retry
     */
    @Bean
    public Retryer feignRetryer() {
        return Retryer.NEVER_RETRY;
    }

    /**
     * logger level
     * 
     * @return level
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
