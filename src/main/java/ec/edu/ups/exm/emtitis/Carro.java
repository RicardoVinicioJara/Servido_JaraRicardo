/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.exm.emtitis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vinicio
 */
@Entity
@Table(name = "carro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c"),
    @NamedQuery(name = "Carro.findByIdCarro", query = "SELECT c FROM Carro c WHERE c.idCarro = :idCarro"),
    @NamedQuery(name = "Carro.findByPrecio", query = "SELECT c FROM Carro c WHERE c.precio = :precio"),
    @NamedQuery(name = "Carro.findByCodigocompra", query = "SELECT c FROM Carro c WHERE c.codigocompra = :codigocompra")})
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarro")
    private Integer idCarro;
    @Column(name = "precio")
    private String precio;
    @Column(name = "codigocompra")
    private String codigocompra;
    @JoinColumn(name = "producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto producto;

    public Carro() {
    }

    public Carro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCodigocompra() {
        return codigocompra;
    }

    public void setCodigocompra(String codigocompra) {
        this.codigocompra = codigocompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarro != null ? idCarro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.idCarro == null && other.idCarro != null) || (this.idCarro != null && !this.idCarro.equals(other.idCarro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.exm.emtitis.Carro[ idCarro=" + idCarro + " ]";
    }
    
}
