package id.cv.sellapp.service;

import id.cv.sellapp.entity.Pengguna;
import id.cv.sellapp.request.LoginDTO;
import id.cv.sellapp.request.PenggunaDTO;
import id.cv.sellapp.response.LoginResponseDTO;


public interface PenggunaService {

    LoginResponseDTO loginPengguna(LoginDTO loginDTO);
    Pengguna simpanPengguna(PenggunaDTO penggunaDTO);
}
