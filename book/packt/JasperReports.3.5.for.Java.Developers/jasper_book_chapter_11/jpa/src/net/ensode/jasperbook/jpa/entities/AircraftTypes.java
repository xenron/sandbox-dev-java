package net.ensode.jasperbook.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author heffel
 */
@Entity
@Table(name = "aircraft_types")
@NamedQueries({@NamedQuery(name = "AircraftTypes.findAll", query = "SELECT a FROM AircraftTypes a"), @NamedQuery(name = "AircraftTypes.findByAircraftTypeId", query = "SELECT a FROM AircraftTypes a WHERE a.aircraftTypeId = :aircraftTypeId"), @NamedQuery(name = "AircraftTypes.findByDescription", query = "SELECT a FROM AircraftTypes a WHERE a.description = :description")})
public class AircraftTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "aircraft_type_id")
    private Short aircraftTypeId;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;

    public AircraftTypes() {
    }

    public AircraftTypes(Short aircraftTypeId) {
        this.aircraftTypeId = aircraftTypeId;
    }

    public AircraftTypes(Short aircraftTypeId, String description) {
        this.aircraftTypeId = aircraftTypeId;
        this.description = description;
    }

    public Short getAircraftTypeId() {
        return aircraftTypeId;
    }

    public void setAircraftTypeId(Short aircraftTypeId) {
        this.aircraftTypeId = aircraftTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aircraftTypeId != null ? aircraftTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AircraftTypes)) {
            return false;
        }
        AircraftTypes other = (AircraftTypes) object;
        if ((this.aircraftTypeId == null && other.aircraftTypeId != null) || (this.aircraftTypeId != null && !this.aircraftTypeId.equals(other.aircraftTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.ensode.jasperbook.jpa.AircraftTypes[aircraftTypeId=" + aircraftTypeId + "]";
    }

}
