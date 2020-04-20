/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.boby0003.presentation;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pat
 */
@Entity
@Table(name = "WIDGETBOBY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WidgetBoby.findAll", query = "SELECT c FROM WidgetBoby c"),
    @NamedQuery(name = "WidgetBoby.findById", query = "SELECT c FROM WidgetBoby c WHERE c.id = :id"),
    @NamedQuery(name = "WidgetBoby.findByName706", query = "SELECT c FROM WidgetBoby c WHERE c.name706 = :name706"),
    @NamedQuery(name = "WidgetBoby.findByQunatity706", query = "SELECT c FROM WidgetBoby c WHERE c.quantity706 = :quantity706")})
public class WidgetBoby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 255)
    @Column(name = "NAME706")
    private String name706;
    @Column(name = "QUANTITY706")
    private int quantity706;

    public WidgetBoby() {
    }

    public WidgetBoby(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName706() {
        return name706;
    }

    public void setName706(String name706) {
        this.name706 = name706;
    }

    public int getQuantity706() {
        return quantity706;
    }

    public void setQuantity706(int quantity706) {
        this.quantity706 = quantity706;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WidgetBoby)) {
            return false;
        }
        WidgetBoby other = (WidgetBoby) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.widgetpatrick.Contact[ id=" + id + " ]";
    }
    
}
