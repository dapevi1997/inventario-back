package com.sofka.inventario.routers;

import com.sofka.inventario.collections.Bike;
import com.sofka.inventario.model.BikeDTO;
import com.sofka.inventario.usecases.CreateUseCase;
import com.sofka.inventario.usecases.DeleteUseCase;
import com.sofka.inventario.usecases.ListUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BikeRouter {
    @RouterOperation(
            path = "/createBike",
            produces ={
                    MediaType.APPLICATION_JSON_VALUE
            },
            method = RequestMethod.POST,
            beanClass = BikeRouter.class,
            beanMethod = "createBike",
            operation = @Operation(
                    operationId = "createBike",
                    responses = {
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "successful operation",
                                    content = @Content(schema = @Schema(
                                            implementation = Bike.class
                                    ))
                            )
                    },
                    requestBody = @RequestBody(
                            content = @Content(schema = @Schema(
                                    implementation = BikeDTO.class
                            ))
                    )
            )
    )
    @Bean
    public RouterFunction<ServerResponse> createBike(CreateUseCase createUseCase){
        Function<BikeDTO, Mono<ServerResponse>> executor = bikeDTO -> createUseCase.saveBike(bikeDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));


        return route(
                POST("/createBike").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BikeDTO.class).flatMap(executor)
        );
    }

    @RouterOperation(
            path = "/pagination/{page}",
            produces ={
                    MediaType.APPLICATION_JSON_VALUE
            },
            method = RequestMethod.GET,
            beanClass = BikeRouter.class,
            beanMethod = "listBikePage",
            operation = @Operation(
                    operationId = "listBikePage",
                    responses = {
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "successful operation",
                                    content = @Content(schema = @Schema(
                                            implementation = Bike.class
                                    ))
                            )
                    },
                    parameters = {
                            @Parameter(in = ParameterIn.PATH, name = "page")
                    }
            )
    )
    @Bean
    public RouterFunction<ServerResponse> listBikePage(ListUseCase listUseCase){
        return route(GET("/pagination/{page}"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(listUseCase.listByPage(Integer.parseInt(request.pathVariable("page"))), Bike.class))
        );
    }

    @RouterOperation(
            path = "/deleteBike/{id}",
            produces ={
                    MediaType.APPLICATION_JSON_VALUE
            },
            method = RequestMethod.DELETE,
            beanClass = BikeRouter.class,
            beanMethod = "deleteBike",
            operation = @Operation(
                    operationId = "deleteBike",
                    responses = {
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "successful operation",
                                    content = @Content(schema = @Schema(
                                    ))
                            )
                    },
                    parameters = {
                            @Parameter(in = ParameterIn.PATH, name = "id")
                    }
            )
    )
    @Bean
    public RouterFunction<ServerResponse> deleteBike(DeleteUseCase deleteUseCase){
        return route(
                DELETE("/deleteBike/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(deleteUseCase.apply(request.pathVariable("id")), Void.class))
        );
    }
}
