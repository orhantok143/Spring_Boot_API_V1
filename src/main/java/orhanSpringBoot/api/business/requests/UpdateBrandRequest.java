package orhanSpringBoot.api.business.requests;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor

public class UpdateBrandRequest {
    private String name;
  
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
