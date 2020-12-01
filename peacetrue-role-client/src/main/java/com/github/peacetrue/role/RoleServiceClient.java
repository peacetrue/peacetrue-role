package com.github.peacetrue.role;

import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;

/**
 * 角色客户端
 *
 * @author xiayx
 */
@ReactiveFeignClient(name = "peacetrue-role", url = "${peacetrue.Role.url:${peacetrue.server.url:}}")
public interface RoleServiceClient {

    @PostMapping(value = "/roles")
    Mono<RoleVO> add(RoleAdd params);

    @GetMapping(value = "/roles", params = "page")
    Mono<Page<RoleVO>> query(@Nullable @SpringQueryMap RoleQuery params, @Nullable Pageable pageable, @SpringQueryMap String... projection);

    @GetMapping(value = "/roles", params = "sort")
    Flux<RoleVO> query(@SpringQueryMap RoleQuery params, Sort sort, @SpringQueryMap String... projection);

    @GetMapping(value = "/roles")
    Flux<RoleVO> query(@SpringQueryMap RoleQuery params, @SpringQueryMap String... projection);

    @GetMapping(value = "/roles/get")
    Mono<RoleVO> get(@SpringQueryMap RoleGet params, @SpringQueryMap String... projection);

    @PutMapping(value = "/roles")
    Mono<Integer> modify(RoleModify params);

    @DeleteMapping(value = "/roles/delete")
    Mono<Integer> delete(@SpringQueryMap RoleDelete params);

}
