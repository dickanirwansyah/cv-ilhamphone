package id.cv.sellapp.controller.api;

import id.cv.sellapp.entity.Pengguna;
import id.cv.sellapp.request.LoginDTO;
import id.cv.sellapp.request.PenggunaDTO;
import id.cv.sellapp.response.LoginResponseDTO;
import id.cv.sellapp.response.ResponseApi;
import id.cv.sellapp.service.PenggunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api/pengguna")
public class PenggunaController {

    @Autowired
    private PenggunaService penggunaService;

    @PostMapping(value = "/login")
    public ResponseEntity<ResponseApi> login(@RequestBody @Valid LoginDTO loginDTO,
                                             BindingResult bindingResult){

        ResponseApi responseApi = null;
        List<LoginResponseDTO> loginResponseDTOS = new ArrayList<>();

        if (bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                responseApi = ResponseApi.responseApi(400, fieldError.getDefaultMessage(),null, 0);
                return ResponseEntity.badRequest().body(responseApi);
            }
        }

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO = penggunaService.loginPengguna(loginDTO);
        if (loginResponseDTO == null){
            responseApi = ResponseApi
                    .responseApi(400, "username & password salah.", null, 0);
            return ResponseEntity.badRequest().body(responseApi);
        }
        loginResponseDTOS.add(loginResponseDTO);
        responseApi = ResponseApi.responseApi(200, "success",loginResponseDTO, loginResponseDTOS.size());
        return ResponseEntity.ok(responseApi);
    }

    @PostMapping(value = "/create-pengguna")
    public ResponseEntity<ResponseApi> createPengguna(@RequestBody @Valid PenggunaDTO penggunaDTO,
                                                      BindingResult bindingResult){

        ResponseApi responseApi = null;
        List<Pengguna> penggunas = new ArrayList<>();
        if (bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                responseApi = ResponseApi.responseApi(400, fieldError.getDefaultMessage(), null, 0);
                return ResponseEntity.badRequest().body(responseApi);
            }
        }

        Pengguna pengguna = new Pengguna();
        pengguna = penggunaService.simpanPengguna(penggunaDTO);
        penggunas.add(pengguna);
        responseApi = ResponseApi.responseApi(200, "success",pengguna, penggunas.size());
        return ResponseEntity.ok(responseApi);
    }
}
