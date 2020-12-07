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
 * Class      :   MaintenanceJournal.java
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
@Table(name = "MAINTENANCE_JOURNAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaintenanceJournal.findAll", query = "SELECT m FROM MaintenanceJournal m"),
    @NamedQuery(name = "MaintenanceJournal.findById", query = "SELECT m FROM MaintenanceJournal m WHERE m.id = :id"),
    @NamedQuery(name = "MaintenanceJournal.findByTxDate", query = "SELECT m FROM MaintenanceJournal m WHERE m.txDate = :txDate"),
    @NamedQuery(name = "MaintenanceJournal.findByOdometer", query = "SELECT m FROM MaintenanceJournal m WHERE m.odometer = :odometer"),
    @NamedQuery(name = "MaintenanceJournal.findByLocation", query = "SELECT m FROM MaintenanceJournal m WHERE m.location = :location"),
    @NamedQuery(name = "MaintenanceJournal.findByAmount", query = "SELECT m FROM MaintenanceJournal m WHERE m.amount = :amount"),
    @NamedQuery(name = "MaintenanceJournal.findByPosted", query = "SELECT m FROM MaintenanceJournal m WHERE m.posted = :posted"),
    @NamedQuery(name = "MaintenanceJournal.findByBalanced", query = "SELECT m FROM MaintenanceJournal m WHERE m.balanced = :balanced")})
public class MaintenanceJournal implements Serializable {

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
    @Lob
    private String cause;
    @Basic(optional = false)
    @Lob
    @Column(name = "WORK_PERFORMED")
    private String workPerformed;
    @Basic(optional = false)
    private double amount;
    @Basic(optional = false)
    private Boolean posted;
    @Basic(optional = false)
    private Boolean balanced;
    @JoinColumn(name = "FROM_ACCT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Accounts fromAcct;
    @JoinColumn(name = "MAINT_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private MaintenanceTypes maintTypeId;
    // Public Static Constants
    
    
    // Private Static Constants
    
    
    // Private Member Fields
    
    
    // Constructor(s)
    /**
     * Creates a default instance of the MaintenanceJournal class.
     */
    public MaintenanceJournal () {
        
    }

    public MaintenanceJournal(Long id) {
        this.id = id;
    }

    public MaintenanceJournal(Long id, Date txDate, long odometer, String location, String cause, String workPerformed, double amount, Boolean posted, Boolean balanced) {
        this.id = id;
        this.txDate = txDate;
        this.odometer = odometer;
        this.location = location;
        this.cause = cause;
        this.workPerformed = workPerformed;
        this.amount = amount;
        this.posted = posted;
        this.balanced = balanced;
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

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getWorkPerformed() {
        return workPerformed;
    }

    public void setWorkPerformed(String workPerformed) {
        this.workPerformed = workPerformed;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Boolean getPosted() {
        return posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    public Boolean getBalanced() {
        return balanced;
    }

    public void setBalanced(Boolean balanced) {
        this.balanced = balanced;
    }

    public Accounts getFromAcct() {
        return fromAcct;
    }

    public void setFromAcct(Accounts fromAcct) {
        this.fromAcct = fromAcct;
    }

    public MaintenanceTypes getMaintTypeId() {
        return maintTypeId;
    }

    public void setMaintTypeId(MaintenanceTypes maintTypeId) {
        this.maintTypeId = maintTypeId;
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
        if (!(object instanceof MaintenanceJournal)) {
            return false;
        }
        MaintenanceJournal other = (MaintenanceJournal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pekinsoft.nwind.db.lib.MaintenanceJournal[ id=" + id + " ]";
    }

}
