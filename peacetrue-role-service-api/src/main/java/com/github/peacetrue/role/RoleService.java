package com.github.peacetrue.role;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;

/**
 * 角色服务接口
 *
 * @author xiayx
 */
public interface RoleService {

    /** 新增 */
    Mono<RoleVO> add(RoleAdd params);

    /** 分页查询 */
    Mono<Page<RoleVO>> query(@Nullable RoleQuery params, @Nullable Pageable pageable, String... projection);

    /** 全量查询 */
    Flux<RoleVO> query(RoleQuery params, @Nullable Sort sort, String... projection);

    /** 全量查询 */
    default Flux<RoleVO> query(RoleQuery params, String... projection) {
        return this.query(params, (Sort) null, projection);
    }

    /** 获取 */
    Mono<RoleVO> get(RoleGet params, String... projection);

    /** 修改 */
    Mono<Integer> modify(RoleModify params);

    /** 删除 */
    Mono<Integer> delete(RoleDelete params);

}
