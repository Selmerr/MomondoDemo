package dat3.momondodemo.app.service;

import dat3.momondodemo.app.dto.Age;
import dat3.momondodemo.app.dto.Gender;
import dat3.momondodemo.app.dto.NameResponse;
import dat3.momondodemo.app.dto.Nation;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiService {

    public NameResponse getInfo(String name) {
        long start = System.currentTimeMillis();
        Mono<Gender> gender = callEndpointGender(name);
        Mono<Age> age = callEndpointAge(name);
        Mono<Nation> nation = callEndpointNation(name);

        var rs = Mono.zip(age,gender,nation).map(t-> {
            NameResponse response = new NameResponse(t.getT1(),t.getT2(),t.getT3());
            response.setName(name);
            return response;
        });
        NameResponse response = rs.block();
        return response;
    }

    private Mono<Age> callEndpointAge(String name) {
        Mono<Age> age = WebClient.create()
                .get()
                .uri("https://api.agify.io?name="+name)
                .retrieve()
                .bodyToMono(Age.class);
        return age;

    }

    private Mono<Gender> callEndpointGender(String name) {
        Mono<Gender> gender = WebClient.create()
                .get()
                .uri("https://api.genderize.io?name="+name)
                .retrieve()
                .bodyToMono(Gender.class);
        return gender;
    }

    private Mono<Nation> callEndpointNation(String name) {
        Mono<Nation> nation = WebClient.create()
                .get()
                .uri("https://api.nationalize.io?name="+name)
                .retrieve()
                .bodyToMono(Nation.class);
        return nation;
    }
}
