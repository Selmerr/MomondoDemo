package dat3.momondodemo.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Nation {
    private List<Country> country;

    @Getter
    @Setter
    public static class Country {
        private String country_id;
        private double probability;
    }
}