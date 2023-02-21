package com.project.first.bitcoin.controller;

import com.project.first.bitcoin.model.dto.Coin;
import com.project.first.bitcoin.model.dto.CoinInfo;
import com.project.first.bitcoin.model.dto.ResponseFirstData;
import com.project.first.bitcoin.service.APIService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "스터디")
public class BitcoinController {

    private final APIService bitcoinService;

    @ApiOperation(value = "[RestTemplate] 코인 리스트 정보1")
    @GetMapping(value = "/rest/coinList")
    public List<Coin> coinInfo(){
        return bitcoinService.getCoinInfo();
    }

    @ApiOperation(value = "[RestTemplate] 코인 상세 정보")
    @ApiImplicitParam(name = "coinName", value = "상세검색할 코인 이름", defaultValue = "KRW-BTC")
    @GetMapping(value = "/rest/coinDetailInfo")
    public List<CoinInfo> coinDetailInfo(
            @RequestParam("coinName")
            String coinName){
        return bitcoinService.getCoinDetailInfo(coinName);
    }

    @ApiOperation(value = "[WebClient-Flux] 플럭스 코인 리스트 정보")
    @GetMapping(value = "/webclient/flux/coinList")
    public Flux<Coin> coinInfoWhitFlux(){
        return bitcoinService.getCoinInfoWithFlux();
    }

    @ApiOperation(value = "[WebClient-Mono] 모노 코인 리스트 정보")
    @GetMapping(value = "/webclient/mono/coinList")
    public Mono<Coin[]> coinInfoWhitMono(){
        return bitcoinService.getCoinInfoWithMono();
    }

    @ApiOperation(value = "[WebClient-Flux] 플럭스 코인 상세 정보")
    @ApiImplicitParam(name = "coinName", value = "상세검색할 코인 이름", defaultValue = "KRW-BTC")
    @GetMapping(value = "/webclient/flux/coinDetailInfo")
    public Flux<CoinInfo> coinDetailInfoWhitFlux(
            @RequestParam("coinName")
            String coinName){
        return bitcoinService.getCoinDetailInfoWithFlux(coinName);
    }

    @ApiOperation(value = "[WebClient-Mono] 모노 코인 상세 정보")
    @ApiImplicitParam(name = "coinName", value = "상세검색할 코인 이름", defaultValue = "KRW-BTC")
    @GetMapping(value = "/webclient/mono/coinDetailInfo")
    public Mono<CoinInfo[]> coinDetailInfofoWhitMono(
            @RequestParam("coinName")
            String coinName){
        return bitcoinService.getCoinDetailInfoWithMono(coinName);
    }

    @ApiOperation(value = "[WebClient-Mono] 공휴일 상세 정보")
    @GetMapping(value = "/webclient/mono/holiday")
    public Mono<ResponseFirstData> getHolidayInfoWhitMono(){
        return bitcoinService.getHolidayInfoWhitMono();
    }

}
