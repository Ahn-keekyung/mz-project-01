package com.project.first.bitcoin.model.dto;

import io.swagger.annotations.Api;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Data {

    private String dateKind;
    private String dateName;
    private String isHoliday;
    private Long locdate;
    private Long seq;

}
