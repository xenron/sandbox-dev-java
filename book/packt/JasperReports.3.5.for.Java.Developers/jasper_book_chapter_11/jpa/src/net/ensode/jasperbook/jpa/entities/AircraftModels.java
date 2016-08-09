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
@Table(name = "aircraft_models")
@NamedQueries({@NamedQuery(name = "AircraftModels.findAll", query = "SELECT a FROM AircraftModels a"), @NamedQuery(name = "AircraftModels.findByAircraftModelCode", query = "SELECT a FROM AircraftModels a WHERE a.aircraftModelCode = :aircraftModelCode"), @NamedQuery(name = "AircraftModels.findByManufacturer", query = "SELECT a FROM AircraftModels a WHERE a.manufacturer = :manufacturer"), @NamedQuery(name = "AircraftModels.findByModel", query = "SELECT a FROM AircraftModels a WHERE a.model = :model"), @NamedQuery(name = "AircraftModels.findByAircraftTypeId", query = "SELECT a FROM AircraftModels a WHERE a.aircraftTypeId = :aircraftTypeId"), @NamedQuery(name = "AircraftModels.findByAircraftEngineTypeId", query = "SELECT a FROM AircraftModels a WHERE a.aircraftEngineTypeId = :aircraftEngineTypeId"), @NamedQuery(name = "AircraftModels.findByAircraftCategoryId", query = "SELECT a FROM AircraftModels a WHERE a.aircraftCategoryId = :aircraftCategoryId"), @NamedQuery(name = "AircraftModels.findByAmateur", query = "SELECT a FROM AircraftModels a WHERE a.amateur = :amateur"), @NamedQuery(name = "AircraftModels.findByEngines", query = "SELECT a FROM AircraftModels a WHERE a.engines = :engines"), @NamedQuery(name = "AircraftModels.findBySeats", query = "SELECT a FROM AircraftModels a WHERE a.seats = :seats"), @NamedQuery(name = "AircraftModels.findByWeight", query = "SELECT a FROM AircraftModels a WHERE a.weight = :weight"), @NamedQuery(name = "AircraftModels.findBySpeed", query = "SELECT a FROM AircraftModels a WHERE a.speed = :speed")})
public class AircraftModels implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "aircraft_model_code")
    private String aircraftModelCode;
    @Basic(optional = false)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Basic(optional = false)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @Column(name = "aircraft_type_id")
    private short aircraftTypeId;
    @Basic(optional = false)
    @Column(name = "aircraft_engine_type_id")
    private short aircraftEngineTypeId;
    @Basic(optional = false)
    @Column(name = "aircraft_category_id")
    private short aircraftCategoryId;
    @Basic(optional = false)
    @Column(name = "amateur")
    private short amateur;
    @Basic(optional = false)
    @Column(name = "engines")
    private short engines;
    @Basic(optional = false)
    @Column(name = "seats")
    private short seats;
    @Basic(optional = false)
    @Column(name = "weight")
    private int weight;
    @Basic(optional = false)
    @Column(name = "speed")
    private short speed;

    public AircraftModels() {
    }

    public AircraftModels(String aircraftModelCode) {
        this.aircraftModelCode = aircraftModelCode;
    }

    public AircraftModels(String aircraftModelCode, String manufacturer, String model, short aircraftTypeId, short aircraftEngineTypeId, short aircraftCategoryId, short amateur, short engines, short seats, int weight, short speed) {
        this.aircraftModelCode = aircraftModelCode;
        this.manufacturer = manufacturer;
        this.model = model;
        this.aircraftTypeId = aircraftTypeId;
        this.aircraftEngineTypeId = aircraftEngineTypeId;
        this.aircraftCategoryId = aircraftCategoryId;
        this.amateur = amateur;
        this.engines = engines;
        this.seats = seats;
        this.weight = weight;
        this.speed = speed;
    }

    public String getAircraftModelCode() {
        return aircraftModelCode;
    }

    public void setAircraftModelCode(String aircraftModelCode) {
        this.aircraftModelCode = aircraftModelCode;
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

    public short getAircraftTypeId() {
        return aircraftTypeId;
    }

    public void setAircraftTypeId(short aircraftTypeId) {
        this.aircraftTypeId = aircraftTypeId;
    }

    public short getAircraftEngineTypeId() {
        return aircraftEngineTypeId;
    }

    public void setAircraftEngineTypeId(short aircraftEngineTypeId) {
        this.aircraftEngineTypeId = aircraftEngineTypeId;
    }

    public short getAircraftCategoryId() {
        return aircraftCategoryId;
    }

    public void setAircraftCategoryId(short aircraftCategoryId) {
        this.aircraftCategoryId = aircraftCategoryId;
    }

    public short getAmateur() {
        return amateur;
    }

    public void setAmateur(short amateur) {
        this.amateur = amateur;
    }

    public short getEngines() {
        return engines;
    }

    public void setEngines(short engines) {
        this.engines = engines;
    }

    public short getSeats() {
        return seats;
    }

    public void setSeats(short seats) {
        this.seats = seats;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public short getSpeed() {
        return speed;
    }

    public void setSpeed(short speed) {
        this.speed = speed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aircraftModelCode != null ? aircraftModelCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AircraftModels)) {
            return false;
        }
        AircraftModels other = (AircraftModels) object;
        if ((this.aircraftModelCode == null && other.aircraftModelCode != null) || (this.aircraftModelCode != null && !this.aircraftModelCode.equals(other.aircraftModelCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.ensode.jasperbook.jpa.AircraftModels[aircraftModelCode=" + aircraftModelCode + "]";
    }

}
