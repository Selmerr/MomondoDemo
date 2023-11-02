package dat3.momondodemo.app.api;

import dat3.momondodemo.app.dto.NameResponse;
import dat3.momondodemo.app.service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MomondoController {

    ApiService apiService;

    public MomondoController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping()
    public NameResponse getInfoFromName(@RequestParam String name) {
        NameResponse nameResponse = apiService.getInfo(name);
        return nameResponse;
    }
}
