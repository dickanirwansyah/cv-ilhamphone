package id.cv.sellapp.repository;

import id.cv.sellapp.entity.Pengguna;
import id.cv.sellapp.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    //cari token ketika login user
    @Query(value = "select t from Token t where t.token=:token and t.pengguna=:pengguna")
    Optional<Token> findByTokenAndPengguna(@Param("token")String token,
                                           @Param("pengguna")Pengguna pengguna);

}
