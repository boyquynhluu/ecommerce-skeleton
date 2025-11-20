package com.example.catalog.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import reactor.core.publisher.Mono;

@Configuration
public class PingRouter {
    @Bean
    public RouterFunction<ServerResponse> pingRoute() {
        return route(GET("/ping"), req -> ServerResponse.ok().body(Mono.just("catalog ok"), String.class));
    }
}
