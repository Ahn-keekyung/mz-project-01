package com.project.first.bitcoin.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(value = "상세 코인 시세 정보 CoinInfo")
public class CoinInfo {
    @ApiModelProperty(value = "종목 구분 코드")
    private String market;

    @ApiModelProperty(value = "최근 거래 일자(UTC)\n" + "포맷: yyyyMMdd")
    private String trade_date;

    @ApiModelProperty(value = "최근 거래 시각(UTC)\n" + "포맷: HHmmss")
    private String trade_time;

    @ApiModelProperty(value = "최근 거래 일자(KST)\n" + "포맷: yyyyMMdd")
    private String trade_date_kst;

    @ApiModelProperty(value = "최근 거래 시각(KST)\n" + "포맷: HHmmss")
    private String trade_time_kst;

    @ApiModelProperty(value = "최근 거래 일시(UTC)\n" + "포맷: Unix Timestamp")
    private Long trade_timestamp;

    @ApiModelProperty(value = "시가")
    private Double opening_price;

    @ApiModelProperty(value = "고가")
    private Double high_price;

    @ApiModelProperty(value = "저가")
    private Double low_price;

    @ApiModelProperty(value = "종가(현재가)")
    private Double trade_price;

    @ApiModelProperty(value = "전일 종가(UTC 0시 기준)")
    private Double prev_closing_price;

    @ApiModelProperty(value = "EVEN : 보합\n" + "RISE : 상승\n" + "FALL : 하락")
    private String change;

    @ApiModelProperty(value = "변화액의 절대값")
    private Double change_price;

    @ApiModelProperty(value = "변화율의 절대값")
    private Double change_rate;

    @ApiModelProperty(value = "부호가 있는 변화액")
    private Double signed_change_price;

    @ApiModelProperty(value = "부호가 있는 변화율")
    private Double signed_change_rate;

    @ApiModelProperty(value = "가장 최근 거래량")
    private Double trade_volume;

    @ApiModelProperty(value = "누적 거래대금(UTC 0시 기준)")
    private Double acc_trade_price;

    @ApiModelProperty(value = "24시간 누적 거래대금")
    private Double acc_trade_price_24h;

    @ApiModelProperty(value = "누적 거래량(UTC 0시 기준)")
    private Double acc_trade_volume;

    @ApiModelProperty(value = "24시간 누적 거래량")
    private Double acc_trade_volume_24h;

    @ApiModelProperty(value = "52주 신고가")
    private Double highest_52_week_price;

    @ApiModelProperty(value = "52주 신고가 달성일\n" + "포맷: yyyy-MM-dd")
    private String highest_52_week_date;

    @ApiModelProperty(value = "52주 신저가")
    private Double lowest_52_week_price;

    @ApiModelProperty(value = "52주 신저가 달성일\n" + "포맷: yyyy-MM-dd")
    private String lowest_52_week_date;

    @ApiModelProperty(value = "타임스탬프")
    private Long timestamp;

}
