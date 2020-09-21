package id.cv.sellapp.repository;

import id.cv.sellapp.entity.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PenggunaRepository extends JpaRepository<Pengguna, Long> {

    Optional<Pengguna> findByUsernameAndPassword(String username, String password);
}
