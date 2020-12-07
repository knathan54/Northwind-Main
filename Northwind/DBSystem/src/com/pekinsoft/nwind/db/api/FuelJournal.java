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
 * Class      :   FuelJournal.java
 * Author     :   Sean Carrick <sean at pekinsoft dot com>
 * Created    :   Dec 5, 2020 @ 1:39:00 PM
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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sean Carrick &lt;sean at pekinsoft dot com&gt;
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
@Entity
@Table(name = "FUEL_JOURNAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuelJournal.findAll", query = "SELECT f FROM FuelJournal f"),
    @NamedQuery(name = "FuelJournal.findById", query = "SELECT f FROM FuelJournal f WHERE f.id = :id"),
    @NamedQuery(name = "FuelJournal.findByTxDate", query = "SELECT f FROM FuelJournal f WHERE f.txDate = :txDate"),
    @NamedQuery(name = "FuelJournal.findByOdometer", query = "SELECT f FROM FuelJournal f WHERE f.odometer = :odometer"),
    @NamedQuery(name = "FuelJournal.findByLocation", query = "SELECT f FROM FuelJournal f WHERE f.location = :location"),
    @NamedQuery(name = "FuelJournal.findByDieselGallons", query = "SELECT f FROM FuelJournal f WHERE f.dieselGallons = :dieselGallons"),
    @NamedQuery(name = "FuelJournal.findByDieselPrice", query = "SELECT f FROM FuelJournal f WHERE f.dieselPrice = :dieselPrice"),
    @NamedQuery(name = "FuelJournal.findByDefPurchased", query = "SELECT f FROM FuelJournal f WHERE f.defPurchased = :defPurchased"),
    @NamedQuery(name = "FuelJournal.findByDefGallons", query = "SELECT f FROM FuelJournal f WHERE f.defGallons = :defGallons"),
    @NamedQuery(name = "FuelJournal.findByDefPrice", query = "SELECT f FROM FuelJournal f WHERE f.defPrice = :defPrice")})
public class FuelJournal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "TX_DATE")
    @Temporal(TemporalType.DATE)
    private Date txDate;
    @Basic(optional = false)
    private long odometer;
    @Basic(optional = false)
    private String location;
    @Basic(optional = false)
    @Column(name = "DIESEL_GALLONS")
    private double dieselGallons;
    @Basic(optional = false)
    @Column(name = "DIESEL_PRICE")
    private double dieselPrice;
    @Basic(optional = false)
    @Column(name = "DEF_PURCHASED")
    private Boolean defPurchased;
    @Basic(optional = false)
    @Column(name = "DEF_GALLONS")
    private double defGallons;
    @Basic(optional = false)
    @Column(name = "DEF_PRICE")
    private double defPrice;
    @Basic(optional = false)
    @Lob
    private String notes;
    @JoinColumn(name = "FROM_ACCT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Accounts fromAcct;
    // Public Static Constants
    
    
    // Private Static Constants
    
    
    // Private Member Fields
    
    
    // Constructor(s)
    /**
     * Creates a default instance of the FuelJournal class.
     */
    public FuelJournal () {
        
    }

    public FuelJournal(Long id) {
        this.id = id;
    }

    public FuelJournal(Long id, Date txDate, long odometer, String location, double dieselGallons, double dieselPrice, Boolean defPurchased, double defGallons, double defPrice, String notes) {
        this.id = id;
        this.txDate = txDate;
        this.odometer = odometer;
        this.location = location;
        this.dieselGallons = dieselGallons;
        this.dieselPrice = dieselPrice;
        this.defPurchased = defPurchased;
        this.defGallons = defGallons;
        this.defPrice = defPrice;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public long getOdometer() {
        return odometer;
    }

    public void setOdometer(long odometer) {
        this.odometer = odometer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getDieselGallons() {
        return dieselGallons;
    }

    public void setDieselGallons(double dieselGallons) {
        this.dieselGallons = dieselGallons;
    }

    public double getDieselPrice() {
        return dieselPrice;
    }

    public void setDieselPrice(double dieselPrice) {
        this.dieselPrice = dieselPrice;
    }

    public Boolean getDefPurchased() {
        return defPurchased;
    }

    public void setDefPurchased(Boolean defPurchased) {
        this.defPurchased = defPurchased;
    }

    public double getDefGallons() {
        return defGallons;
    }

    public void setDefGallons(double defGallons) {
        this.defGallons = defGallons;
    }

    public double getDefPrice() {
        return defPrice;
    }

    public void setDefPrice(double defPrice) {
        this.defPrice = defPrice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Accounts getFromAcct() {
        return fromAcct;
    }

    public void setFromAcct(Accounts fromAcct) {
        this.fromAcct = fromAcct;
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
        if (!(object instanceof FuelJournal)) {
            return false;
        }
        FuelJournal other = (FuelJournal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pekinsoft.nwind.db.lib.FuelJournal[ id=" + id + " ]";
    }

}
