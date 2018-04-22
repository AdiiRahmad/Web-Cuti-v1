/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Siti Khusnul Azifah
 */
@Entity
@Table(name = "KARYAWAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karyawan.findAll", query = "SELECT k FROM Karyawan k")
    , @NamedQuery(name = "Karyawan.findByNik", query = "SELECT k FROM Karyawan k WHERE k.nik = :nik")
    , @NamedQuery(name = "Karyawan.findByNama", query = "SELECT k FROM Karyawan k WHERE k.nama = :nama")
    , @NamedQuery(name = "Karyawan.findByAlamat", query = "SELECT k FROM Karyawan k WHERE k.alamat = :alamat")
    , @NamedQuery(name = "Karyawan.findByAgama", query = "SELECT k FROM Karyawan k WHERE k.agama = :agama")
    , @NamedQuery(name = "Karyawan.findByJenisKelamin", query = "SELECT k FROM Karyawan k WHERE k.jenisKelamin = :jenisKelamin")
    , @NamedQuery(name = "Karyawan.findByTanggalLahir", query = "SELECT k FROM Karyawan k WHERE k.tanggalLahir = :tanggalLahir")
    , @NamedQuery(name = "Karyawan.findByTglMulaiKerja", query = "SELECT k FROM Karyawan k WHERE k.tglMulaiKerja = :tglMulaiKerja")
    , @NamedQuery(name = "Karyawan.findBySisa", query = "SELECT k FROM Karyawan k WHERE k.sisa = :sisa")})
public class Karyawan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIK")
    private String nik;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "ALAMAT")
    private String alamat;
    @Column(name = "AGAMA")
    private String agama;
    @Column(name = "JENIS_KELAMIN")
    private String jenisKelamin;
    @Column(name = "TANGGAL_LAHIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalLahir;
    @Column(name = "TGL_MULAI_KERJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglMulaiKerja;
//    @Column(name = "SISA_CUTI")
    @Column(name = "SISA")
    private Short sisa;
    @OneToMany(mappedBy = "nik", fetch = FetchType.LAZY)
    private List<DetailCuti> detailCutiList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "karyawan", fetch = FetchType.LAZY)
    private DetailKaryawan detailKaryawan;

    public Karyawan() {
    }

    public Karyawan(String nik) {
        this.nik = nik;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Date getTglMulaiKerja() {
        return tglMulaiKerja;
    }

    public void setTglMulaiKerja(Date tglMulaiKerja) {
        this.tglMulaiKerja = tglMulaiKerja;
    }

    public Short getSisa() {
        return sisa;
    }

    public void setSisa(Short sisa) {
        this.sisa = sisa;
    }

    @XmlTransient
    public List<DetailCuti> getDetailCutiList() {
        return detailCutiList;
    }

    public void setDetailCutiList(List<DetailCuti> detailCutiList) {
        this.detailCutiList = detailCutiList;
    }

    public DetailKaryawan getDetailKaryawan() {
        return detailKaryawan;
    }

    public void setDetailKaryawan(DetailKaryawan detailKaryawan) {
        this.detailKaryawan = detailKaryawan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nik != null ? nik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.nik == null && other.nik != null) || (this.nik != null && !this.nik.equals(other.nik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + nik + "";
    }
    
}
