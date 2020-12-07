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
 * Class      :   Stops.java
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
import java.util.Date;
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
@Table(name = "STOPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stops.findAll", query = "SELECT s FROM Stops s"),
    @NamedQuery(name = "Stops.findById", query = "SELECT s FROM Stops s WHERE s.id = :id"),
    @NamedQuery(name = "Stops.findByEarlyDate", query = "SELECT s FROM Stops s WHERE s.earlyDate = :earlyDate"),
    @NamedQuery(name = "Stops.findByEarlyTime", query = "SELECT s FROM Stops s WHERE s.earlyTime = :earlyTime"),
    @NamedQuery(name = "Stops.findByLateDate", query = "SELECT s FROM Stops s WHERE s.lateDate = :lateDate"),
    @NamedQuery(name = "Stops.findByLateTime", query = "SELECT s FROM Stops s WHERE s.lateTime = :lateTime"),
    @NamedQuery(name = "Stops.findByArrivalDate", query = "SELECT s FROM Stops s WHERE s.arrivalDate = :arrivalDate"),
    @NamedQuery(name = "Stops.findByArrivalTime", query = "SELECT s FROM Stops s WHERE s.arrivalTime = :arrivalTime"),
    @NamedQuery(name = "Stops.findByDepartureDate", query = "SELECT s FROM Stops s WHERE s.departureDate = :departureDate"),
    @NamedQuery(name = "Stops.findByDepartureTime", query = "SELECT s FROM Stops s WHERE s.departureTime = :departureTime")})
public class Stops implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "EARLY_DATE")
    @Temporal(TemporalType.DATE)
    private Date earlyDate;
    @Basic(optional = false)
    @Column(name = "EARLY_TIME")
    @Temporal(TemporalType.TIME)
    private Date earlyTime;
    @Basic(optional = false)
    @Column(name = "LATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date lateDate;
    @Basic(optional = false)
    @Column(name = "LATE_TIME")
    @Temporal(TemporalType.TIME)
    private Date lateTime;
    @Column(name = "ARRIVAL_DATE")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Column(name = "ARRIVAL_TIME")
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;
    @Column(name = "DEPARTURE_DATE")
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Column(name = "DEPARTURE_TIME")
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Customers customerId;
    @JoinColumn(name = "TRIP_NUMBER", referencedColumnName = "TRIP_NUMBER")
    @ManyToOne(optional = false)
    private Loads tripNumber;
    // Public Static Constants
    
    
    // Private Static Constants
    
    
    // Private Member Fields
    
    
    // Constructor(s)
    /**
     * Creates a default instance of the Stops class.
     */
    public Stops () {
        
    }

    public Stops(Long id) {
        this.id = id;
    }

    public Stops(Long id, Date earlyDate, Date earlyTime, Date lateDate, Date lateTime) {
        this.id = id;
        this.earlyDate = earlyDate;
        this.earlyTime = earlyTime;
        this.lateDate = lateDate;
        this.lateTime = lateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEarlyDate() {
        return earlyDate;
    }

    public void setEarlyDate(Date earlyDate) {
        this.earlyDate = earlyDate;
    }

    public Date getEarlyTime() {
        return earlyTime;
    }

    public void setEarlyTime(Date earlyTime) {
        this.earlyTime = earlyTime;
    }

    public Date getLateDate() {
        return lateDate;
    }

    public void setLateDate(Date lateDate) {
        this.lateDate = lateDate;
    }

    public Date getLateTime() {
        return lateTime;
    }

    public void setLateTime(Date lateTime) {
        this.lateTime = lateTime;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    public Loads getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(Loads tripNumber) {
        this.tripNumber = tripNumber;
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
        if (!(object instanceof Stops)) {
            return false;
        }
        Stops other = (Stops) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pekinsoft.nwind.db.lib.Stops[ id=" + id + " ]";
    }

}
