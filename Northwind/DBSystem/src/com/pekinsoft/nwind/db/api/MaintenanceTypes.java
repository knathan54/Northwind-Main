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
 * Class      :   MaintenanceTypes.java
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
@Table(name = "MAINTENANCE_TYPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaintenanceTypes.findAll", query = "SELECT m FROM MaintenanceTypes m"),
    @NamedQuery(name = "MaintenanceTypes.findById", query = "SELECT m FROM MaintenanceTypes m WHERE m.id = :id"),
    @NamedQuery(name = "MaintenanceTypes.findByTypeName", query = "SELECT m FROM MaintenanceTypes m WHERE m.typeName = :typeName"),
    @NamedQuery(name = "MaintenanceTypes.findByDescription", query = "SELECT m FROM MaintenanceTypes m WHERE m.description = :description")})
public class MaintenanceTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "TYPE_NAME")
    private String typeName;
    @Basic(optional = false)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maintTypeId")
    private Collection<MaintenanceJournal> maintenanceJournalCollection;
    // Public Static Constants
    
    
    // Private Static Constants
    
    
    // Private Member Fields
    
    
    // Constructor(s)
    /**
     * Creates a default instance of the MaintenanceTypes class.
     */
    public MaintenanceTypes () {
        
    }

    public MaintenanceTypes(Long id) {
        this.id = id;
    }

    public MaintenanceTypes(Long id, String typeName, String description) {
        this.id = id;
        this.typeName = typeName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<MaintenanceJournal> getMaintenanceJournalCollection() {
        return maintenanceJournalCollection;
    }

    public void setMaintenanceJournalCollection(Collection<MaintenanceJournal> maintenanceJournalCollection) {
        this.maintenanceJournalCollection = maintenanceJournalCollection;
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
        if (!(object instanceof MaintenanceTypes)) {
            return false;
        }
        MaintenanceTypes other = (MaintenanceTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pekinsoft.nwind.db.lib.MaintenanceTypes[ id=" + id + " ]";
    }

}
