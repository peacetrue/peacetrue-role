package com.github.peacetrue.role;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 角色控制器
 *
 * @author xiayx
 */
@Slf4j
@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Mono<RoleVO> addByForm(RoleAdd params) {
        log.info("新增角色信息(请求方法+表单参数)[{}]", params);
        return roleService.add(params);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<RoleVO> addByJson(@RequestBody RoleAdd params) {
        log.info("新增角色信息(请求方法+JSON参数)[{}]", params);
        return roleService.add(params);
    }

    @GetMapping(params = "page")
    public Mono<Page<RoleVO>> query(RoleQuery params, Pageable pageable, String... projection) {
        log.info("分页查询角色信息(请求方法+参数变量)[{}]", params);
        return roleService.query(params, pageable, projection);
    }

    @GetMapping
    public Flux<RoleVO> query(RoleQuery params, Sort sort, String... projection) {
        log.info("全量查询角色信息(请求方法+参数变量)[{}]", params);
        return roleService.query(params, sort, projection);
    }

    @GetMapping("/{id}")
    public Mono<RoleVO> getByUrlPathVariable(@PathVariable Long id, String... projection) {
        log.info("获取角色信息(请求方法+路径变量)详情[{}]", id);
        return roleService.get(new RoleGet(id), projection);
    }

    @RequestMapping("/get")
    public Mono<RoleVO> getByPath(RoleGet params, String... projection) {
        log.info("获取角色信息(请求路径+参数变量)详情[{}]", params);
        return roleService.get(params, projection);
    }

    @PutMapping(value = {"", "/*"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Mono<Integer> modifyByForm(RoleModify params) {
        log.info("修改角色信息(请求方法+表单参数)[{}]", params);
        return roleService.modify(params);
    }

    @PutMapping(value = {"", "/*"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Integer> modifyByJson(@RequestBody RoleModify params) {
        log.info("修改角色信息(请求方法+JSON参数)[{}]", params);
        return roleService.modify(params);
    }

    @DeleteMapping("/{id}")
    public Mono<Integer> deleteByUrlPathVariable(@PathVariable Long id) {
        log.info("删除角色信息(请求方法+URL路径变量)[{}]", id);
        return roleService.delete(new RoleDelete(id));
    }

    @DeleteMapping(params = "id")
    public Mono<Integer> deleteByUrlParamVariable(RoleDelete params) {
        log.info("删除角色信息(请求方法+URL参数变量)[{}]", params);
        return roleService.delete(params);
    }

    @RequestMapping(path = "/delete")
    public Mono<Integer> deleteByPath(RoleDelete params) {
        log.info("删除角色信息(请求路径+URL参数变量)[{}]", params);
        return roleService.delete(params);
    }


}
