package com.github.peacetrue.role;

import com.github.peacetrue.core.OperatorCapableImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author xiayx
 */
@Getter
@Setter
@ToString
public class RoleAdd extends OperatorCapableImpl<Long> {

    private static final long serialVersionUID = 0L;

    /** 编码 */
    @NotNull
    @Size(min = 1, max = 32)
    private String code;
    /** 名称 */
    @NotNull
    @Size(min = 1, max = 32)
    private String name;
    /** 备注 */
    @NotNull
    @Size(min = 1, max = 255)
    private String remark;

}
