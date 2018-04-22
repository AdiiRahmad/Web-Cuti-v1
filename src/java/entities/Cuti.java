/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Siti Khusnul Azifah
 */
@Entity
@Table(name = "CUTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuti.findAll", query = "SELECT c FROM Cuti c")
    , @NamedQuery(name = "Cuti.findByIdCuti", query = "SELECT c FROM Cuti c WHERE c.idCuti = :idCuti")
    , @NamedQuery(name = "Cuti.findByJenisCuti", query = "SELECT c FROM Cuti c WHERE c.jenisCuti = :jenisCuti")
    , @NamedQuery(name = "Cuti.findByDurasi", query = "SELECT c FROM Cuti c WHERE c.durasi = :durasi")
    , @NamedQuery(name = "Cuti.findByKeterangan", query = "SELECT c FROM Cuti c WHERE c.keterangan = :keterangan")})
public class Cuti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CUTI")
    private String idCuti;
    @Column(name = "JENIS_CUTI")
    private String jenisCuti;
    @Column(name = "DURASI")
    private Integer durasi;
    @Column(name = "KETERANGAN")
    private String keterangan;
    @OneToMany(mappedBy = "idCuti", fetch = FetchType.LAZY)
    private List<DetailCuti> detailCutiList;

    public Cuti() {
    }

    public Cuti(String idCuti) {
        this.idCuti = idCuti;
    }

    public String getIdCuti() {
        return idCuti;
    }

    public void setIdCuti(String idCuti) {
        this.idCuti = idCuti;
    }

    public String getJenisCuti() {
        return jenisCuti;
    }

    public void setJenisCuti(String jenisCuti) {
        this.jenisCuti = jenisCuti;
    }

    public Integer getDurasi() {
        return durasi;
    }

    public void setDurasi(Integer durasi) {
        this.durasi = durasi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @XmlTransient
    public List<DetailCuti> getDetailCutiList() {
        return detailCutiList;
    }

    public void setDetailCutiList(List<DetailCuti> detailCutiList) {
        this.detailCutiList = detailCutiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuti != null ? idCuti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuti)) {
            return false;
        }
        Cuti other = (Cuti) object;
        if ((this.idCuti == null && other.idCuti != null) || (this.idCuti != null && !this.idCuti.equals(other.idCuti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idCuti + "";
    }
    
}
