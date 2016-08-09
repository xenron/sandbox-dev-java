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
@Table(name = "aircraft_engine_types")
@NamedQueries({@NamedQuery(name = "AircraftEngineTypes.findAll", query = "SELECT a FROM AircraftEngineTypes a"), @NamedQuery(name = "AircraftEngineTypes.findByAircraftEngineTypeId", query = "SELECT a FROM AircraftEngineTypes a WHERE a.aircraftEngineTypeId = :aircraftEngineTypeId"), @NamedQuery(name = "AircraftEngineTypes.findByDescription", query = "SELECT a FROM AircraftEngineTypes a WHERE a.description = :description")})
public class AircraftEngineTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "aircraft_engine_type_id")
    private Short aircraftEngineTypeId;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;

    public AircraftEngineTypes() {
    }

    public AircraftEngineTypes(Short aircraftEngineTypeId) {
        this.aircraftEngineTypeId = aircraftEngineTypeId;
    }

    public AircraftEngineTypes(Short aircraftEngineTypeId, String description) {
        this.aircraftEngineTypeId = aircraftEngineTypeId;
        this.description = description;
    }

    public Short getAircraftEngineTypeId() {
        return aircraftEngineTypeId;
    }

    public void setAircraftEngineTypeId(Short aircraftEngineTypeId) {
        this.aircraftEngineTypeId = aircraftEngineTypeId;
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
        hash += (aircraftEngineTypeId != null ? aircraftEngineTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AircraftEngineTypes)) {
            return false;
        }
        AircraftEngineTypes other = (AircraftEngineTypes) object;
        if ((this.aircraftEngineTypeId == null && other.aircraftEngineTypeId != null) || (this.aircraftEngineTypeId != null && !this.aircraftEngineTypeId.equals(other.aircraftEngineTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.ensode.jasperbook.jpa.AircraftEngineTypes[aircraftEngineTypeId=" + aircraftEngineTypeId + "]";
    }

}
