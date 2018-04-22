/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Siti Khusnul Azifah
 */
@Entity
@Table(name = "SETUJU_CUTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SetujuCuti.findAll", query = "SELECT s FROM SetujuCuti s")
    , @NamedQuery(name = "SetujuCuti.findByIdSetujuCuti", query = "SELECT s FROM SetujuCuti s WHERE s.idSetujuCuti = :idSetujuCuti")
    , @NamedQuery(name = "SetujuCuti.findByStatus", query = "SELECT s FROM SetujuCuti s WHERE s.status = :status")})
public class SetujuCuti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SETUJU_CUTI")
    private String idSetujuCuti;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "ID_DETAIL_CUTI", referencedColumnName = "ID_DETAIL_CUTI")
    @ManyToOne(fetch = FetchType.LAZY)
    private DetailCuti idDetailCuti;
    @JoinColumn(name = "ID_JABATAN", referencedColumnName = "ID_JABATAN")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jabatan idJabatan;

    public SetujuCuti() {
    }

    public SetujuCuti(String idSetujuCuti) {
        this.idSetujuCuti = idSetujuCuti;
    }

    public String getIdSetujuCuti() {
        return idSetujuCuti;
    }

    public void setIdSetujuCuti(String idSetujuCuti) {
        this.idSetujuCuti = idSetujuCuti;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DetailCuti getIdDetailCuti() {
        return idDetailCuti;
    }

    public void setIdDetailCuti(DetailCuti idDetailCuti) {
        this.idDetailCuti = idDetailCuti;
    }

    public Jabatan getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(Jabatan idJabatan) {
        this.idJabatan = idJabatan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSetujuCuti != null ? idSetujuCuti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SetujuCuti)) {
            return false;
        }
        SetujuCuti other = (SetujuCuti) object;
        if ((this.idSetujuCuti == null && other.idSetujuCuti != null) || (this.idSetujuCuti != null && !this.idSetujuCuti.equals(other.idSetujuCuti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idSetujuCuti + "";
    }
    
}
