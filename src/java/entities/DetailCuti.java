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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "DETAIL_CUTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailCuti.findAll", query = "SELECT d FROM DetailCuti d")
    , @NamedQuery(name = "DetailCuti.findByIdDetailCuti", query = "SELECT d FROM DetailCuti d WHERE d.idDetailCuti = :idDetailCuti")
    , @NamedQuery(name = "DetailCuti.findByKeterangan", query = "SELECT d FROM DetailCuti d WHERE d.keterangan = :keterangan")
    , @NamedQuery(name = "DetailCuti.findByTanggalMulai", query = "SELECT d FROM DetailCuti d WHERE d.tanggalMulai = :tanggalMulai")
    , @NamedQuery(name = "DetailCuti.findByTanggalSelesai", query = "SELECT d FROM DetailCuti d WHERE d.tanggalSelesai = :tanggalSelesai")
    , @NamedQuery(name = "DetailCuti.findByLamaCuti", query = "SELECT d FROM DetailCuti d WHERE d.lamaCuti = :lamaCuti")})
public class DetailCuti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETAIL_CUTI")
    private String idDetailCuti;
    @Column(name = "KETERANGAN")
    private String keterangan;
    @Column(name = "TANGGAL_MULAI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalMulai;
    @Column(name = "TANGGAL_SELESAI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalSelesai;
    @Column(name = "LAMA_CUTI")
    private Short lamaCuti;
    @OneToMany(mappedBy = "idDetailCuti", fetch = FetchType.LAZY)
    private List<SetujuCuti> setujuCutiList;
    @JoinColumn(name = "ID_CUTI", referencedColumnName = "ID_CUTI")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cuti idCuti;
    @JoinColumn(name = "NIK", referencedColumnName = "NIK")
    @ManyToOne(fetch = FetchType.LAZY)
    private Karyawan nik;

    public DetailCuti() {
    }

    public DetailCuti(String idDetailCuti) {
        this.idDetailCuti = idDetailCuti;
    }

    public String getIdDetailCuti() {
        return idDetailCuti;
    }

    public void setIdDetailCuti(String idDetailCuti) {
        this.idDetailCuti = idDetailCuti;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public Short getLamaCuti() {
        return lamaCuti;
    }

    public void setLamaCuti(Short lamaCuti) {
        this.lamaCuti = lamaCuti;
    }

    @XmlTransient
    public List<SetujuCuti> getSetujuCutiList() {
        return setujuCutiList;
    }

    public void setSetujuCutiList(List<SetujuCuti> setujuCutiList) {
        this.setujuCutiList = setujuCutiList;
    }

    public Cuti getIdCuti() {
        return idCuti;
    }

    public void setIdCuti(Cuti idCuti) {
        this.idCuti = idCuti;
    }

    public Karyawan getNik() {
        return nik;
    }

    public void setNik(Karyawan nik) {
        this.nik = nik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetailCuti != null ? idDetailCuti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailCuti)) {
            return false;
        }
        DetailCuti other = (DetailCuti) object;
        if ((this.idDetailCuti == null && other.idDetailCuti != null) || (this.idDetailCuti != null && !this.idDetailCuti.equals(other.idDetailCuti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idDetailCuti + "";
    }
    
}
