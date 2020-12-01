package com.github.peacetrue.role;

import com.github.peacetrue.core.OperatorCapableImpl;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author xiayx
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleDelete extends OperatorCapableImpl<Long> {

    private static final long serialVersionUID = 0L;

    @NotNull
    @Min(1)
    private Long id;

}
