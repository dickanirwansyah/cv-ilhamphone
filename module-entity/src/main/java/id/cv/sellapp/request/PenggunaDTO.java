package id.cv.sellapp.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PenggunaDTO implements Serializable {

    @NotBlank(message = "username tidak boleh kosong")
    private String username;

    @NotBlank(message = "password tidak boleh kosong")
    private String password;
}
