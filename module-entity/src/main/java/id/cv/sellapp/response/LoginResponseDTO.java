package id.cv.sellapp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO implements Serializable {

    private Object pengguna;
    private String token;
    private Date expiredToken;

}
