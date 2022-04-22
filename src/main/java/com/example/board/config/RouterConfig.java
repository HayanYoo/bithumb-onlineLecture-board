package com.example.board.config;

import com.example.board.component.PostHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> getRoute(PostHandler postHandler) {
        return RouterFunctions.route()
                .path("/board", builder -> builder
                        .GET("/{id}", accept(APPLICATION_JSON), postHandler::getBoard)
                        .POST("", accept(APPLICATION_JSON), postHandler::writeBoard)
                        .POST("/{id}/reply", accept(APPLICATION_JSON), postHandler::writeReply)
                        .PATCH("/{id}", accept(APPLICATION_JSON), postHandler::hideBoard)
                        .PATCH("/{id}/reply/{id}", accept(APPLICATION_JSON), postHandler::hideReply)

                )
                .build();
    }


}
