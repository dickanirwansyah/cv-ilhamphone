package id.cv.sellapp.repository;

import id.cv.sellapp.entity.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {
}
