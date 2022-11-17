package com.msdn.orm.hresh.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.msdn.orm.hresh.common.entity.PageSortInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubUserQueryPageDTO {

    @JsonUnwrapped
    private PageSortInfo pageSortInfo;
}
