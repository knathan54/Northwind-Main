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
 * Class      :   Loads.java
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
 * @author Sean Carrick &lt;sean at pekinsoft dot com&gt;
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
@Entity
@Table(name = "LOADS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loads.findAll", query = "SELECT l FROM Loads l"),
    @NamedQuery(name = "Loads.findByTripNumber", query = "SELECT l FROM Loads l WHERE l.tripNumber = :tripNumber"),
    @NamedQuery(name = "Loads.findByOrderNumber", query = "SELECT l FROM Loads l WHERE l.orderNumber = :orderNumber"),
    @NamedQuery(name = "Loads.findByMiles", query = "SELECT l FROM Loads l WHERE l.miles = :miles"),
    @NamedQuery(name = "Loads.findByRevenue", query = "SELECT l FROM Loads l WHERE l.revenue = :revenue"),
    @NamedQuery(name = "Loads.findByCommodity", query = "SELECT l FROM Loads l WHERE l.commodity = :commodity"),
    @NamedQuery(name = "Loads.findByPickupNumber", query = "SELECT l FROM Loads l WHERE l.pickupNumber = :pickupNumber"),
    @NamedQuery(name = "Loads.findByReferenceNumber", query = "SELECT l FROM Loads l WHERE l.referenceNumber = :referenceNumber"),
    @NamedQuery(name = "Loads.findByBol", query = "SELECT l FROM Loads l WHERE l.bol = :bol"),
    @NamedQuery(name = "Loads.findByPieces", query = "SELECT l FROM Loads l WHERE l.pieces = :pieces"),
    @NamedQuery(name = "Loads.findByWeight", query = "SELECT l FROM Loads l WHERE l.weight = :weight"),
    @NamedQuery(name = "Loads.findByTarped", query = "SELECT l FROM Loads l WHERE l.tarped = :tarped"),
    @NamedQuery(name = "Loads.findByTarpHeight", query = "SELECT l FROM Loads l WHERE l.tarpHeight = :tarpHeight"),
    @NamedQuery(name = "Loads.findByHazmat", query = "SELECT l FROM Loads l WHERE l.hazmat = :hazmat"),
    @NamedQuery(name = "Loads.findByLtl", query = "SELECT l FROM Loads l WHERE l.ltl = :ltl"),
    @NamedQuery(name = "Loads.findByTeam", query = "SELECT l FROM Loads l WHERE l.team = :team"),
    @NamedQuery(name = "Loads.findByTwic", query = "SELECT l FROM Loads l WHERE l.twic = :twic"),
    @NamedQuery(name = "Loads.findByTopCustomer", query = "SELECT l FROM Loads l WHERE l.topCustomer = :topCustomer"),
    @NamedQuery(name = "Loads.findByCbd", query = "SELECT l FROM Loads l WHERE l.cbd = :cbd"),
    @NamedQuery(name = "Loads.findByRamps", query = "SELECT l FROM Loads l WHERE l.ramps = :ramps"),
    @NamedQuery(name = "Loads.findByAssignedUnit", query = "SELECT l FROM Loads l WHERE l.assignedUnit = :assignedUnit")})
public class Loads implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TRIP_NUMBER")
    private String tripNumber;
    @Basic(optional = false)
    @Column(name = "ORDER_NUMBER")
    private String orderNumber;
    @Basic(optional = false)
    @Column(name = "MILES")
    private long miles;
    @Basic(optional = false)
    @Column(name = "REVENUE")
    private double revenue;
    @Basic(optional = false)
    @Column(name = "COMMODITY")
    private String commodity;
    @Basic(optional = false)
    @Column(name = "PICKUP_NUMBER")
    private String pickupNumber;
    @Basic(optional = false)
    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;
    @Basic(optional = false)
    @Column(name = "BOL")
    private String bol;
    @Basic(optional = false)
    @Column(name = "PIECES")
    private int pieces;
    @Basic(optional = false)
    @Column(name = "WEIGHT")
    private int weight;
    @Basic(optional = false)
    @Column(name = "TARPED")
    private Boolean tarped;
    @Basic(optional = false)
    @Column(name = "TARP_HEIGHT")
    private int tarpHeight;
    @Basic(optional = false)
    @Column(name = "HAZMAT")
    private Boolean hazmat;
    @Basic(optional = false)
    @Column(name = "LTL")
    private Boolean ltl;
    @Basic(optional = false)
    @Column(name = "TEAM")
    private Boolean team;
    @Basic(optional = false)
    @Column(name = "TWIC")
    private Boolean twic;
    @Basic(optional = false)
    @Column(name = "TOP_CUSTOMER")
    private Boolean topCustomer;
    @Basic(optional = false)
    @Column(name = "CBD")
    private Boolean cbd;
    @Basic(optional = false)
    @Column(name = "RAMPS")
    private Boolean ramps;
    @Basic(optional = false)
    @Column(name = "ASSIGNED_UNIT")
    private String assignedUnit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripNumber")
    private Collection<Stops> stopsCollection;
    @JoinColumn(name = "BROKER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Brokers brokerId;
    // Public Static Constants
    
    
    // Private Static Constants
    
    
    // Private Member Fields
    
    
    // Constructor(s)
    /**
     * Creates a default instance of the Loads class.
     */
    public Loads () {
        
    }

    public Loads(String tripNumber) {
        this.tripNumber = tripNumber;
    }

    public Loads(String tripNumber, String orderNumber, long miles, double revenue, String commodity, String pickupNumber, String referenceNumber, String bol, int pieces, int weight, Boolean tarped, int tarpHeight, Boolean hazmat, Boolean ltl, Boolean team, Boolean twic, Boolean topCustomer, Boolean cbd, Boolean ramps, String assignedUnit) {
        this.tripNumber = tripNumber;
        this.orderNumber = orderNumber;
        this.miles = miles;
        this.revenue = revenue;
        this.commodity = commodity;
        this.pickupNumber = pickupNumber;
        this.referenceNumber = referenceNumber;
        this.bol = bol;
        this.pieces = pieces;
        this.weight = weight;
        this.tarped = tarped;
        this.tarpHeight = tarpHeight;
        this.hazmat = hazmat;
        this.ltl = ltl;
        this.team = team;
        this.twic = twic;
        this.topCustomer = topCustomer;
        this.cbd = cbd;
        this.ramps = ramps;
        this.assignedUnit = assignedUnit;
    }

    public String getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(String tripNumber) {
        this.tripNumber = tripNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getMiles() {
        return miles;
    }

    public void setMiles(long miles) {
        this.miles = miles;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getPickupNumber() {
        return pickupNumber;
    }

    public void setPickupNumber(String pickupNumber) {
        this.pickupNumber = pickupNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getBol() {
        return bol;
    }

    public void setBol(String bol) {
        this.bol = bol;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Boolean getTarped() {
        return tarped;
    }

    public void setTarped(Boolean tarped) {
        this.tarped = tarped;
    }

    public int getTarpHeight() {
        return tarpHeight;
    }

    public void setTarpHeight(int tarpHeight) {
        this.tarpHeight = tarpHeight;
    }

    public Boolean getHazmat() {
        return hazmat;
    }

    public void setHazmat(Boolean hazmat) {
        this.hazmat = hazmat;
    }

    public Boolean getLtl() {
        return ltl;
    }

    public void setLtl(Boolean ltl) {
        this.ltl = ltl;
    }

    public Boolean getTeam() {
        return team;
    }

    public void setTeam(Boolean team) {
        this.team = team;
    }

    public Boolean getTwic() {
        return twic;
    }

    public void setTwic(Boolean twic) {
        this.twic = twic;
    }

    public Boolean getTopCustomer() {
        return topCustomer;
    }

    public void setTopCustomer(Boolean topCustomer) {
        this.topCustomer = topCustomer;
    }

    public Boolean getCbd() {
        return cbd;
    }

    public void setCbd(Boolean cbd) {
        this.cbd = cbd;
    }

    public Boolean getRamps() {
        return ramps;
    }

    public void setRamps(Boolean ramps) {
        this.ramps = ramps;
    }

    public String getAssignedUnit() {
        return assignedUnit;
    }

    public void setAssignedUnit(String assignedUnit) {
        this.assignedUnit = assignedUnit;
    }

    @XmlTransient
    public Collection<Stops> getStopsCollection() {
        return stopsCollection;
    }

    public void setStopsCollection(Collection<Stops> stopsCollection) {
        this.stopsCollection = stopsCollection;
    }

    public Brokers getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Brokers brokerId) {
        this.brokerId = brokerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tripNumber != null ? tripNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loads)) {
            return false;
        }
        Loads other = (Loads) object;
        if ((this.tripNumber == null && other.tripNumber != null) || (this.tripNumber != null && !this.tripNumber.equals(other.tripNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pekinsoft.nwind.db.lib.Loads[ tripNumber=" + tripNumber + " ]";
    }

}
