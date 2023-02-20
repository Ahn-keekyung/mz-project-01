package com.project.first.bitcoin.model.dto;

import io.swagger.annotations.Api;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Header {

    private String resultCode;
    private String resultMsg;
}
