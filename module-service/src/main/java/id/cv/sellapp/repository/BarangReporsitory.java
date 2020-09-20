package id.cv.sellapp.repository;

import id.cv.sellapp.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangReporsitory extends JpaRepository<Barang, Long> {
}
