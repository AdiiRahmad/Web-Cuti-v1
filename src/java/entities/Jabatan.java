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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "JABATAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jabatan.findAll", query = "SELECT j FROM Jabatan j")
    , @NamedQuery(name = "Jabatan.findByIdJabatan", query = "SELECT j FROM Jabatan j WHERE j.idJabatan = :idJabatan")
    , @NamedQuery(name = "Jabatan.findByJabatan", query = "SELECT j FROM Jabatan j WHERE j.jabatan = :jabatan")})
public class Jabatan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_JABATAN")
    private String idJabatan;
    @Column(name = "JABATAN")
    private String jabatan;
    @OneToMany(mappedBy = "idPimpinan", fetch = FetchType.LAZY)
    private List<Jabatan> jabatanList;
    @JoinColumn(name = "ID_PIMPINAN", referencedColumnName = "ID_JABATAN")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jabatan idPimpinan;
    @OneToMany(mappedBy = "idJabatan", fetch = FetchType.LAZY)
    private List<SetujuCuti> setujuCutiList;
    @OneToMany(mappedBy = "idJabatan", fetch = FetchType.LAZY)
    private List<DetailKaryawan> detailKaryawanList;

    public Jabatan() {
    }

    public Jabatan(String idJabatan) {
        this.idJabatan = idJabatan;
    }

    public String getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(String idJabatan) {
        this.idJabatan = idJabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @XmlTransient
    public List<Jabatan> getJabatanList() {
        return jabatanList;
    }

    public void setJabatanList(List<Jabatan> jabatanList) {
        this.jabatanList = jabatanList;
    }

    public Jabatan getIdPimpinan() {
        return idPimpinan;
    }

    public void setIdPimpinan(Jabatan idPimpinan) {
        this.idPimpinan = idPimpinan;
    }

    @XmlTransient
    public List<SetujuCuti> getSetujuCutiList() {
        return setujuCutiList;
    }

    public void setSetujuCutiList(List<SetujuCuti> setujuCutiList) {
        this.setujuCutiList = setujuCutiList;
    }

    @XmlTransient
    public List<DetailKaryawan> getDetailKaryawanList() {
        return detailKaryawanList;
    }

    public void setDetailKaryawanList(List<DetailKaryawan> detailKaryawanList) {
        this.detailKaryawanList = detailKaryawanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJabatan != null ? idJabatan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jabatan)) {
            return false;
        }
        Jabatan other = (Jabatan) object;
        if ((this.idJabatan == null && other.idJabatan != null) || (this.idJabatan != null && !this.idJabatan.equals(other.idJabatan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idJabatan + "";
    }
    
}
