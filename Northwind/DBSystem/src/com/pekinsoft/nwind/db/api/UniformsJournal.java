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
 * Class      :   UniformsJournal.java
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
@Table(name = "UNIFORMS_JOURNAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniformsJournal.findAll", query = "SELECT u FROM UniformsJournal u"),
    @NamedQuery(name = "UniformsJournal.findById", query = "SELECT u FROM UniformsJournal u WHERE u.id = :id"),
    @NamedQuery(name = "UniformsJournal.findByTxDate", query = "SELECT u FROM UniformsJournal u WHERE u.txDate = :txDate"),
    @NamedQuery(name = "UniformsJournal.findByDescription", query = "SELECT u FROM UniformsJournal u WHERE u.description = :description"),
    @NamedQuery(name = "UniformsJournal.findByAmount", query = "SELECT u FROM UniformsJournal u WHERE u.amount = :amount"),
    @NamedQuery(name = "UniformsJournal.findByPosted", query = "SELECT u FROM UniformsJournal u WHERE u.posted = :posted"),
    @NamedQuery(name = "UniformsJournal.findByBalanced", query = "SELECT u FROM UniformsJournal u WHERE u.balanced = :balanced")})
public class UniformsJournal implements Serializable {

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
    private String description;
    @Basic(optional = false)
    private double amount;
    @Basic(optional = false)
    private Boolean posted;
    @Basic(optional = false)
    private Boolean balanced;
    @JoinColumn(name = "FROM_ACCT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Accounts fromAcct;
    // Public Static Constants
    
    
    // Private Static Constants
    
    
    // Private Member Fields
    
    
    // Constructor(s)
    /**
     * Creates a default instance of the UniformsJournal class.
     */
    public UniformsJournal () {
        
    }

    public UniformsJournal(Long id) {
        this.id = id;
    }

    public UniformsJournal(Long id, Date txDate, String description, double amount, Boolean posted, Boolean balanced) {
        this.id = id;
        this.txDate = txDate;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UniformsJournal)) {
            return false;
        }
        UniformsJournal other = (UniformsJournal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pekinsoft.nwind.db.lib.UniformsJournal[ id=" + id + " ]";
    }

}
