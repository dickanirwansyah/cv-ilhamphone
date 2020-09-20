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
@Table(name = "transaksi_detail")
@Entity
public class TransaksiDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kategori_transaksi")
    @Enumerated(EnumType.STRING)
    private Kategori kategoriTransaksi;

    @ManyToOne
    @JoinColumn(name = "barang_id", nullable = true)
    private Barang barang;

    @ManyToOne
    @JoinColumn(name = "pelanggan_id", nullable = true)
    private Pelanggan pelanggan;

    @Column(name = "jumlah_beli")
    private Integer jumlahBeli;

    @Column(name = "harga_unit")
    private BigDecimal hargaUnit;

    @Column(name = "total_harga")
    private BigDecimal totalHarga;
}
