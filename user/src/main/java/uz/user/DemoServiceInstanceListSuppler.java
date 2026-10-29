package uz.user;

import java.util.List;
import java.util.Arrays;
import reactor.core.publisher.Flux;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;

public class DemoServiceInstanceListSuppler implements ServiceInstanceListSupplier {
    private final String serviceId;

    public DemoServiceInstanceListSuppler(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        return Flux.just(Arrays.asList(
                new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8090, false),
                new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 9092, false),
                new DefaultServiceInstance(serviceId + "3", serviceId, "localhost", 9999, false)
        ));
    }

    @Override
    public String getServiceId() {
        return serviceId;

    }
}