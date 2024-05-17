package br.com.danieloliveira.apiuser.suppler;

import java.util.Arrays;
import java.util.List;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Flux;

public final class DemoServiceInstanceListSuppler implements ServiceInstanceListSupplier {
    private static final String LOCALHOST = "localhost";
    private final String serviceId;

    public DemoServiceInstanceListSuppler(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        return Flux.just(Arrays.asList(
                new DefaultServiceInstance(serviceId + "1", serviceId, LOCALHOST, 8191, false),
                new DefaultServiceInstance(serviceId + "2", serviceId, LOCALHOST, 8192, false),
                new DefaultServiceInstance(serviceId + "3", serviceId, LOCALHOST, 8193, false)));
    }
}