package com.project.first.bitcoin.service;

import com.project.first.bitcoin.model.dto.Coin;
import com.project.first.bitcoin.model.dto.CoinInfo;
import com.project.first.bitcoin.model.dto.ResponseFirstData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class APIService {

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    public List<Coin> getCoinInfo() {
        URI uri = UriComponentsBuilder
                .fromUriString("https://api.upbit.com")
                .path("/v1/market/all")
                .encode()
                .build()
                .toUri();

        final var data =
                restTemplate.exchange(
                        uri,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Coin>>() {
                        });

        return data.getBody();
    }

    public List<CoinInfo> getCoinDetailInfo(String coinName) {
        URI uri = UriComponentsBuilder
                .fromUriString("https://api.upbit.com")
                .path("/v1/ticker")
                .queryParam("markets", coinName)
                .encode()
                .build()
                .toUri();

        final var data =
                restTemplate.exchange(
                        uri,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<CoinInfo>>() {
                        });

        return data.getBody();
    }

    public Flux<Coin> getCoinInfoWithFlux() {
        return webClient.get()
                .uri("/v1/market/all")
                .retrieve()
                .bodyToFlux(Coin.class);
    }

    public Mono<Coin[]> getCoinInfoWithMono() {
        return webClient.get()
                .uri("/v1/market/all")
                .retrieve()
                .bodyToMono(Coin[].class);
    }

    public Flux<CoinInfo> getCoinDetailInfoWithFlux(String coinName) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                                .path("/v1/ticker")
                                .queryParam("markets",coinName)
                                .build()
                        )
                .retrieve()
                .bodyToFlux(CoinInfo.class);
    }

    public Mono<CoinInfo[]> getCoinDetailInfoWithMono(String coinName) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                                .path("/v1/ticker")
                                .queryParam("markets",coinName)
                                .build()
                        )
                .retrieve()
                .bodyToMono(CoinInfo[].class);
    }

    public Mono<ResponseFirstData> getHolidayInfoWhitMono(){
        final var data = webClient.mutate()
                .baseUrl("http://apis.data.go.kr")
                .build();
        
        return data.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/B090041/openapi/service/SpcdeInfoService/getHoliDeInfo")
                        .queryParam("solYear","2023")
                        .queryParam("solMonth","01")
                        .queryParam("ServiceKey","yX5hqo3LJ1iOprsd9HDRR7rfT8xTL5zRwZXzE7aQE34vtPAzGgyzXr8o7KFeLljivyQ9ilchKNZc/fMgsDlVMQ==")
                        .queryParam("_type","json")
                        .queryParam("numOfRows","10")
                        .build()
                )
                .retrieve()
                .bodyToMono(ResponseFirstData.class);
    }
}
