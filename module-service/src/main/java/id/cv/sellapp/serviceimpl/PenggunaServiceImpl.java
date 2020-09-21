package id.cv.sellapp.serviceimpl;

import id.cv.sellapp.entity.Pengguna;
import id.cv.sellapp.entity.Token;
import id.cv.sellapp.repository.PenggunaRepository;
import id.cv.sellapp.repository.TokenRepository;
import id.cv.sellapp.request.LoginDTO;
import id.cv.sellapp.request.PenggunaDTO;
import id.cv.sellapp.response.LoginResponseDTO;
import id.cv.sellapp.service.PenggunaService;
import id.cv.sellapp.util.CryptoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class PenggunaServiceImpl implements PenggunaService {

    private static final Logger log = LoggerFactory.getLogger(PenggunaServiceImpl.class);
    private static final String IV = "0123456789123456";
    private static final String secretKey = "secretKey@bc";

    @Autowired
    private PenggunaRepository penggunaRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public LoginResponseDTO loginPengguna(LoginDTO loginDTO) {
        try{
            if (log.isInfoEnabled()){
                log.debug("{\"payload\" : \" "+loginDTO.toString()+" \"}");
            }
            //encrypted password
            LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
            CryptoUtil cryptoUtil = new CryptoUtil();
            String encryptedPassword = cryptoUtil.encrypted(loginDTO.getPassword(), IV, secretKey);
            Optional<Pengguna> findPengguna = penggunaRepository.findByUsernameAndPassword(loginDTO.getUsername(), encryptedPassword);
            if (!findPengguna.isPresent()){
                if (log.isInfoEnabled()){
                    log.debug("{\"message_error\" : \"maaf pengguna tidak ditemukan !\"}");
                }
                return null;
            }

            //generate token
            Token saveToken = new Token();
            saveToken.setToken(UUID.randomUUID().toString());
            saveToken.setPengguna(findPengguna.get());
            Token responseToken = tokenRepository.save(saveToken);

            if (responseToken == null){
                if (log.isInfoEnabled()){
                    log.debug("{\"message_error\" : \"maaf gagal generate token !\"}");
                }
            }

            loginResponseDTO.setPengguna(findPengguna.get());
            loginResponseDTO.setToken(responseToken.getToken());
            return loginResponseDTO;
        }catch (Exception e){
            throw new RuntimeException("error : "+e.getMessage());
        }
    }

    @Override
    public Pengguna simpanPengguna(PenggunaDTO penggunaDTO) {
        try{
            Pengguna pengguna = new Pengguna();
            BeanUtils.copyProperties(penggunaDTO, pengguna);
            //encrypted password
            CryptoUtil cryptoUtil = new CryptoUtil();
            pengguna.setPassword(cryptoUtil.encrypted(penggunaDTO.getPassword(), IV, secretKey));
            Pengguna responseSavePengguna = penggunaRepository.save(pengguna);
            if (responseSavePengguna == null){
                if (log.isInfoEnabled()){
                    log.debug("{\"message_error\" : \"maaf response save pengguna gagal save !\"}");
                }
                return null;
            }
            return responseSavePengguna;
        }catch (Exception e){
            throw new RuntimeException("error : "+e.getMessage());
        }
    }
}
