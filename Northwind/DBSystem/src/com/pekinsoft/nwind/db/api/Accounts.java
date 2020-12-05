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
 * Class      :   Accounts.java
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
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
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
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findById", query = "SELECT a FROM Accounts a WHERE a.id = :id"),
    @NamedQuery(name = "Accounts.findByAcctName", query = "SELECT a FROM Accounts a WHERE a.acctName = :acctName")})
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "ACCT_NAME")
    private String acctName;
    @Lob
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<PhysicalsJournal> physicalsJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<ReservesJournal> reservesJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<InsuranceJournal> insuranceJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<WagesJournal> wagesJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<RentJournal> rentJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<FuelJournal> fuelJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<TaxJournal> taxJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<CommunicationJournal> communicationJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<InterestJournal> interestJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<MaintenanceJournal> maintenanceJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<CheckingJournal> checkingJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<TollsJournal> tollsJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<UniformsJournal> uniformsJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<AccountingJournal> accountingJournalCollection;
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AccountTypes typeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toAcct")
    private Collection<Gl> glCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<Gl> glCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<OfficeJournal> officeJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<SavingsJournal> savingsJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<FuelCardJournal> fuelCardJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<LoadingJournal> loadingJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<ScalesJournal> scalesJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<SuppliesJournal> suppliesJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<FeesJournal> feesJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<TravelJournal> travelJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromAcct")
    private Collection<CreditCardJournal> creditCardJournalCollection;
    // Public Static Constants
    
    
    // Private Static Constants
    
    
    // Private Member Fields
    
    
    // Constructor(s)
    /**
     * Creates a default instance of the Accounts class.
     */
    public Accounts () {
        
    }

    public Accounts(Long id) {
        this.id = id;
    }

    public Accounts(Long id, String acctName) {
        this.id = id;
        this.acctName = acctName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<PhysicalsJournal> getPhysicalsJournalCollection() {
        return physicalsJournalCollection;
    }

    public void setPhysicalsJournalCollection(Collection<PhysicalsJournal> physicalsJournalCollection) {
        this.physicalsJournalCollection = physicalsJournalCollection;
    }

    @XmlTransient
    public Collection<ReservesJournal> getReservesJournalCollection() {
        return reservesJournalCollection;
    }

    public void setReservesJournalCollection(Collection<ReservesJournal> reservesJournalCollection) {
        this.reservesJournalCollection = reservesJournalCollection;
    }

    @XmlTransient
    public Collection<InsuranceJournal> getInsuranceJournalCollection() {
        return insuranceJournalCollection;
    }

    public void setInsuranceJournalCollection(Collection<InsuranceJournal> insuranceJournalCollection) {
        this.insuranceJournalCollection = insuranceJournalCollection;
    }

    @XmlTransient
    public Collection<WagesJournal> getWagesJournalCollection() {
        return wagesJournalCollection;
    }

    public void setWagesJournalCollection(Collection<WagesJournal> wagesJournalCollection) {
        this.wagesJournalCollection = wagesJournalCollection;
    }

    @XmlTransient
    public Collection<RentJournal> getRentJournalCollection() {
        return rentJournalCollection;
    }

    public void setRentJournalCollection(Collection<RentJournal> rentJournalCollection) {
        this.rentJournalCollection = rentJournalCollection;
    }

    @XmlTransient
    public Collection<FuelJournal> getFuelJournalCollection() {
        return fuelJournalCollection;
    }

    public void setFuelJournalCollection(Collection<FuelJournal> fuelJournalCollection) {
        this.fuelJournalCollection = fuelJournalCollection;
    }

    @XmlTransient
    public Collection<TaxJournal> getTaxJournalCollection() {
        return taxJournalCollection;
    }

    public void setTaxJournalCollection(Collection<TaxJournal> taxJournalCollection) {
        this.taxJournalCollection = taxJournalCollection;
    }

    @XmlTransient
    public Collection<CommunicationJournal> getCommunicationJournalCollection() {
        return communicationJournalCollection;
    }

    public void setCommunicationJournalCollection(Collection<CommunicationJournal> communicationJournalCollection) {
        this.communicationJournalCollection = communicationJournalCollection;
    }

    @XmlTransient
    public Collection<InterestJournal> getInterestJournalCollection() {
        return interestJournalCollection;
    }

    public void setInterestJournalCollection(Collection<InterestJournal> interestJournalCollection) {
        this.interestJournalCollection = interestJournalCollection;
    }

    @XmlTransient
    public Collection<MaintenanceJournal> getMaintenanceJournalCollection() {
        return maintenanceJournalCollection;
    }

    public void setMaintenanceJournalCollection(Collection<MaintenanceJournal> maintenanceJournalCollection) {
        this.maintenanceJournalCollection = maintenanceJournalCollection;
    }

    @XmlTransient
    public Collection<CheckingJournal> getCheckingJournalCollection() {
        return checkingJournalCollection;
    }

    public void setCheckingJournalCollection(Collection<CheckingJournal> checkingJournalCollection) {
        this.checkingJournalCollection = checkingJournalCollection;
    }

    @XmlTransient
    public Collection<TollsJournal> getTollsJournalCollection() {
        return tollsJournalCollection;
    }

    public void setTollsJournalCollection(Collection<TollsJournal> tollsJournalCollection) {
        this.tollsJournalCollection = tollsJournalCollection;
    }

    @XmlTransient
    public Collection<UniformsJournal> getUniformsJournalCollection() {
        return uniformsJournalCollection;
    }

    public void setUniformsJournalCollection(Collection<UniformsJournal> uniformsJournalCollection) {
        this.uniformsJournalCollection = uniformsJournalCollection;
    }

    @XmlTransient
    public Collection<AccountingJournal> getAccountingJournalCollection() {
        return accountingJournalCollection;
    }

    public void setAccountingJournalCollection(Collection<AccountingJournal> accountingJournalCollection) {
        this.accountingJournalCollection = accountingJournalCollection;
    }

    public AccountTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(AccountTypes typeId) {
        this.typeId = typeId;
    }

    @XmlTransient
    public Collection<Gl> getGlCollection() {
        return glCollection;
    }

    public void setGlCollection(Collection<Gl> glCollection) {
        this.glCollection = glCollection;
    }

    @XmlTransient
    public Collection<Gl> getGlCollection1() {
        return glCollection1;
    }

    public void setGlCollection1(Collection<Gl> glCollection1) {
        this.glCollection1 = glCollection1;
    }

    @XmlTransient
    public Collection<OfficeJournal> getOfficeJournalCollection() {
        return officeJournalCollection;
    }

    public void setOfficeJournalCollection(Collection<OfficeJournal> officeJournalCollection) {
        this.officeJournalCollection = officeJournalCollection;
    }

    @XmlTransient
    public Collection<SavingsJournal> getSavingsJournalCollection() {
        return savingsJournalCollection;
    }

    public void setSavingsJournalCollection(Collection<SavingsJournal> savingsJournalCollection) {
        this.savingsJournalCollection = savingsJournalCollection;
    }

    @XmlTransient
    public Collection<FuelCardJournal> getFuelCardJournalCollection() {
        return fuelCardJournalCollection;
    }

    public void setFuelCardJournalCollection(Collection<FuelCardJournal> fuelCardJournalCollection) {
        this.fuelCardJournalCollection = fuelCardJournalCollection;
    }

    @XmlTransient
    public Collection<LoadingJournal> getLoadingJournalCollection() {
        return loadingJournalCollection;
    }

    public void setLoadingJournalCollection(Collection<LoadingJournal> loadingJournalCollection) {
        this.loadingJournalCollection = loadingJournalCollection;
    }

    @XmlTransient
    public Collection<ScalesJournal> getScalesJournalCollection() {
        return scalesJournalCollection;
    }

    public void setScalesJournalCollection(Collection<ScalesJournal> scalesJournalCollection) {
        this.scalesJournalCollection = scalesJournalCollection;
    }

    @XmlTransient
    public Collection<SuppliesJournal> getSuppliesJournalCollection() {
        return suppliesJournalCollection;
    }

    public void setSuppliesJournalCollection(Collection<SuppliesJournal> suppliesJournalCollection) {
        this.suppliesJournalCollection = suppliesJournalCollection;
    }

    @XmlTransient
    public Collection<FeesJournal> getFeesJournalCollection() {
        return feesJournalCollection;
    }

    public void setFeesJournalCollection(Collection<FeesJournal> feesJournalCollection) {
        this.feesJournalCollection = feesJournalCollection;
    }

    @XmlTransient
    public Collection<TravelJournal> getTravelJournalCollection() {
        return travelJournalCollection;
    }

    public void setTravelJournalCollection(Collection<TravelJournal> travelJournalCollection) {
        this.travelJournalCollection = travelJournalCollection;
    }

    @XmlTransient
    public Collection<CreditCardJournal> getCreditCardJournalCollection() {
        return creditCardJournalCollection;
    }

    public void setCreditCardJournalCollection(Collection<CreditCardJournal> creditCardJournalCollection) {
        this.creditCardJournalCollection = creditCardJournalCollection;
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
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pekinsoft.nwind.db.lib.Accounts[ id=" + id + " ]";
    }

}
