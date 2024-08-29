package orhanSpringBoot.api.business.respones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllUser {
  
    private int id;
    private String name;
    private String username;
    private String email;
    
}
