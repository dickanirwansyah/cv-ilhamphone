package id.cv.sellapp.repository;

import id.cv.sellapp.entity.TransaksiDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiDetailRepository extends JpaRepository<TransaksiDetail, Long> {
}
