package com.project.first.bitcoin.model.dto;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Items {

    private List<Data> item;
}
