package com.project.first.bitcoin.model.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response {

    private Header header;
    private Body body;
}
