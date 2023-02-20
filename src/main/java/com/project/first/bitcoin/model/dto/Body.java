package com.project.first.bitcoin.model.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Body {

    private Items items;
    private Long numOfRows;
    private Long pageNo;
    private Long totalCount;
}
