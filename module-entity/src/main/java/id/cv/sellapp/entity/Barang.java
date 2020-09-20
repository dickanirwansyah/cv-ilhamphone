package id.cv.sellapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "barang")
@Entity
public class Barang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "barang_id")
    private String barangId;

    @Column(name = "nama")
    private String nama;

    @Enumerated(EnumType.STRING)
    @Column(name = "kategori")
    private Kategori kategori;

    @Column(name = "jumlah")
    private Integer jumlah;

    @Column(name = "harga")
    private BigDecimal harga;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "deleted")
    private boolean deleted;
}
