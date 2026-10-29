package uz.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;

public class SayHelloConfiguration {
    @Bean
    @Primary
    ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new DemoServiceInstanceListSuppler("say-hello");
    }
}