package net.ensode.jasperbook.jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "aircraft_engines")
@NamedQueries({@NamedQuery(name = "AircraftEngines.findAll", query = "SELECT a FROM AircraftEngines a"), @NamedQuery(name = "AircraftEngines.findByAircraftEngineCode", query = "SELECT a FROM AircraftEngines a WHERE a.aircraftEngineCode = :aircraftEngineCode"), @NamedQuery(name = "AircraftEngines.findByManufacturer", query = "SELECT a FROM AircraftEngines a WHERE a.manufacturer = :manufacturer"), @NamedQuery(name = "AircraftEngines.findByModel", query = "SELECT a FROM AircraftEngines a WHERE a.model = :model"), @NamedQuery(name = "AircraftEngines.findByAircraftEngineTypeId", query = "SELECT a FROM AircraftEngines a WHERE a.aircraftEngineTypeId = :aircraftEngineTypeId"), @NamedQuery(name = "AircraftEngines.findByHorsepower", query = "SELECT a FROM AircraftEngines a WHERE a.horsepower = :horsepower"), @NamedQuery(name = "AircraftEngines.findByThrust", query = "SELECT a FROM AircraftEngines a WHERE a.thrust = :thrust"), @NamedQuery(name = "AircraftEngines.findByFuelConsumed", query = "SELECT a FROM AircraftEngines a WHERE a.fuelConsumed = :fuelConsumed")})
public class AircraftEngines implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "aircraft_engine_code")
    private String aircraftEngineCode;
    @Basic(optional = false)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Basic(optional = false)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @Column(name = "aircraft_engine_type_id")
    private short aircraftEngineTypeId;
    @Basic(optional = false)
    @Column(name = "horsepower")
    private int horsepower;
    @Basic(optional = false)
    @Column(name = "thrust")
    private int thrust;
    @Basic(optional = false)
    @Column(name = "fuel_consumed")
    private BigDecimal fuelConsumed;

    public AircraftEngines() {
    }

    public AircraftEngines(String aircraftEngineCode) {
        this.aircraftEngineCode = aircraftEngineCode;
    }

    public AircraftEngines(String aircraftEngineCode, String manufacturer, String model, short aircraftEngineTypeId, int horsepower, int thrust, BigDecimal fuelConsumed) {
        this.aircraftEngineCode = aircraftEngineCode;
        this.manufacturer = manufacturer;
        this.model = model;
        this.aircraftEngineTypeId = aircraftEngineTypeId;
        this.horsepower = horsepower;
        this.thrust = thrust;
        this.fuelConsumed = fuelConsumed;
    }

    public String getAircraftEngineCode() {
        return aircraftEngineCode;
    }

    public void setAircraftEngineCode(String aircraftEngineCode) {
        this.aircraftEngineCode = aircraftEngineCode;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public short getAircraftEngineTypeId() {
        return aircraftEngineTypeId;
    }

    public void setAircraftEngineTypeId(short aircraftEngineTypeId) {
        this.aircraftEngineTypeId = aircraftEngineTypeId;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getThrust() {
        return thrust;
    }

    public void setThrust(int thrust) {
        this.thrust = thrust;
    }

    public BigDecimal getFuelConsumed() {
        return fuelConsumed;
    }

    public void setFuelConsumed(BigDecimal fuelConsumed) {
        this.fuelConsumed = fuelConsumed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aircraftEngineCode != null ? aircraftEngineCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AircraftEngines)) {
            return false;
        }
        AircraftEngines other = (AircraftEngines) object;
        if ((this.aircraftEngineCode == null && other.aircraftEngineCode != null) || (this.aircraftEngineCode != null && !this.aircraftEngineCode.equals(other.aircraftEngineCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.ensode.jasperbook.jpa.AircraftEngines[aircraftEngineCode=" + aircraftEngineCode + "]";
    }

}
