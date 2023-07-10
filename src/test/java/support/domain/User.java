package support.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    @Builder.Default
    private int id = 10;
    @Builder.Default
    private String username = "biancag";
    @Builder.Default
    private String firstName = "Bianca";
    @Builder.Default
    private String lastName = "Gabur";
    @Builder.Default
    private String email = "bianca@email.com";
    @Builder.Default
    private String password = "pass123";
    @Builder.Default
    private String phone = "54321";
    @Builder.Default
    private int userStatus = 1;
}
