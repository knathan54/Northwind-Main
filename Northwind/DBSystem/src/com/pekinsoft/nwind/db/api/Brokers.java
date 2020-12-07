/*
 * Copyright (C) 2020 PekinSOFT Systems
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * *****************************************************************************
 * Project    :   NorthwindDBLibrary
 * Class      :   Brokers.java
 * Author     :   Sean Carrick <sean at pekinsoft dot com>
 * Created    :   Dec 5, 2020 @ 2:38:49 PM
 * Modified   :   Dec 5, 2020
 *  
 * Purpose:
 * 	
 * Revision History:
 *  
 * WHEN          BY                  REASON
 * ----------    ------------------- -------------------------------------------
 * Dec 5, 2020    Sean Carrick             Initial creation.
 * *****************************************************************************
 */

package com.pekinsoft.nwind.db.api;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sean Carrick &lt;sean at pekinsoft dot com&gt;
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
@Entity
@Table(name = "BROKERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brokers.findAll", query = "SELECT b FROM Brokers b"),
    @NamedQuery(name = "Brokers.findById", query = "SELECT b FROM Brokers b WHERE b.id = :id"),
    @NamedQuery(name = "Brokers.findByCompany", query = "SELECT b FROM Brokers b WHERE b.company = :company"),
    @NamedQuery(name = "Brokers.findByStreet", query = "SELECT b FROM Brokers b WHERE b.street = :street"),
    @NamedQuery(name = "Brokers.findBySuite", query = "SELECT b FROM Brokers b WHERE b.suite = :suite"),
    @NamedQuery(name = "Brokers.findByCity", query = "SELECT b FROM Brokers b WHERE b.city = :city"),
    @NamedQuery(name = "Brokers.findByStateOrProvince", query = "SELECT b FROM Brokers b WHERE b.stateOrProvince = :stateOrProvince"),
    @NamedQuery(name = "Brokers.findByPostalCode", query = "SELECT b FROM Brokers b WHERE b.postalCode = :postalCode"),
    @NamedQuery(name = "Brokers.findByContact", query = "SELECT b FROM Brokers b WHERE b.contact = :contact"),
    @NamedQuery(name = "Brokers.findByPhone", query = "SELECT b FROM Brokers b WHERE b.phone = :phone"),
    @NamedQuery(name = "Brokers.findByEmail", query = "SELECT b FROM Brokers b WHERE b.email = :email")})
public class Brokers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "COMPANY")
    private String company;
    @Basic(optional = false)
    @Column(name = "STREET")
    private String street;
    @Column(name = "SUITE")
    private String suite;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "STATE_OR_PROVINCE")
    private String stateOrProvince;
    @Basic(optional = false)
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Basic(optional = false)
    @Column(name = "CONTACT")
    private String contact;
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "NOTES")
    private String notes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brokerId")
    private Collection<Loads> loadsCollection;
    // Public Static Constants
    
    
    // Private Static Constants
    
    
    // Private Member Fields
    
    
    // Constructor(s)
    /**
     * Creates a default instance of the Brokers class.
     */
    public Brokers () {
        
    }

    public Brokers(Long id) {
        this.id = id;
    }

    public Brokers(Long id, String company, String street, String city, String stateOrProvince, String postalCode, String contact, String phone, String email, String notes) {
        this.id = id;
        this.company = company;
        this.street = street;
        this.city = city;
        this.stateOrProvince = stateOrProvince;
        this.postalCode = postalCode;
        this.contact = contact;
        this.phone = phone;
        this.email = email;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @XmlTransient
    public Collection<Loads> getLoadsCollection() {
        return loadsCollection;
    }

    public void setLoadsCollection(Collection<Loads> loadsCollection) {
        this.loadsCollection = loadsCollection;
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
        if (!(object instanceof Brokers)) {
            return false;
        }
        Brokers other = (Brokers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pekinsoft.nwind.db.lib.Brokers[ id=" + id + " ]";
    }

}
