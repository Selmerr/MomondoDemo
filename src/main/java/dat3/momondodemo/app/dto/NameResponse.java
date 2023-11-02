package dat3.momondodemo.app.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NameResponse {
    String name;
    String gender;
    double genderProbability;

    int age;

    int ageCount;

    String country;

    double countryProbability;

    public NameResponse(Age age, Gender gender, Nation nation) {
        this.name = name;
        this.age = age.getAge();
        this.ageCount = age.getCount();
        this.gender = gender.getGender();
        this.country = nation.getCountry().get(0).getCountry_id();
        this.countryProbability = nation.getCountry().get(0).getProbability();
        this.genderProbability = gender.getProbability();
    }

    @Override
    public String toString() {
        return "NameResponse{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", genderProbability=" + genderProbability +
                ", age=" + age +
                ", ageCount=" + ageCount +
                ", country='" + country + '\'' +
                ", countryProbability=" + countryProbability +
                '}';
    }
}
