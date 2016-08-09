package net.ensode.jasperbook.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author heffel
 */
@Entity
@Table(name = "aircraft")
@NamedQueries({@NamedQuery(name = "Aircraft.findAll", query = "SELECT a FROM Aircraft a"), @NamedQuery(name = "Aircraft.findByTailNum", query = "SELECT a FROM Aircraft a WHERE a.tailNum = :tailNum"), @NamedQuery(name = "Aircraft.findByAircraftSerial", query = "SELECT a FROM Aircraft a WHERE a.aircraftSerial = :aircraftSerial"), @NamedQuery(name = "Aircraft.findByAircraftModelCode", query = "SELECT a FROM Aircraft a WHERE a.aircraftModelCode = :aircraftModelCode"), @NamedQuery(name = "Aircraft.findByAircraftEngineCode", query = "SELECT a FROM Aircraft a WHERE a.aircraftEngineCode = :aircraftEngineCode"), @NamedQuery(name = "Aircraft.findByYearBuilt", query = "SELECT a FROM Aircraft a WHERE a.yearBuilt = :yearBuilt"), @NamedQuery(name = "Aircraft.findByAircraftTypeId", query = "SELECT a FROM Aircraft a WHERE a.aircraftTypeId = :aircraftTypeId"), @NamedQuery(name = "Aircraft.findByAircraftEngineTypeId", query = "SELECT a FROM Aircraft a WHERE a.aircraftEngineTypeId = :aircraftEngineTypeId"), @NamedQuery(name = "Aircraft.findByRegistrantTypeId", query = "SELECT a FROM Aircraft a WHERE a.registrantTypeId = :registrantTypeId"), @NamedQuery(name = "Aircraft.findByName", query = "SELECT a FROM Aircraft a WHERE a.name = :name"), @NamedQuery(name = "Aircraft.findByAddress1", query = "SELECT a FROM Aircraft a WHERE a.address1 = :address1"), @NamedQuery(name = "Aircraft.findByAddress2", query = "SELECT a FROM Aircraft a WHERE a.address2 = :address2"), @NamedQuery(name = "Aircraft.findByCity", query = "SELECT a FROM Aircraft a WHERE a.city = :city"), @NamedQuery(name = "Aircraft.findByState", query = "SELECT a FROM Aircraft a WHERE a.state = :state"), @NamedQuery(name = "Aircraft.findByZip", query = "SELECT a FROM Aircraft a WHERE a.zip = :zip"), @NamedQuery(name = "Aircraft.findByRegion", query = "SELECT a FROM Aircraft a WHERE a.region = :region"), @NamedQuery(name = "Aircraft.findByCounty", query = "SELECT a FROM Aircraft a WHERE a.county = :county"), @NamedQuery(name = "Aircraft.findByCountry", query = "SELECT a FROM Aircraft a WHERE a.country = :country"), @NamedQuery(name = "Aircraft.findByCertification", query = "SELECT a FROM Aircraft a WHERE a.certification = :certification"), @NamedQuery(name = "Aircraft.findByStatusCode", query = "SELECT a FROM Aircraft a WHERE a.statusCode = :statusCode"), @NamedQuery(name = "Aircraft.findByModeSCode", query = "SELECT a FROM Aircraft a WHERE a.modeSCode = :modeSCode"), @NamedQuery(name = "Aircraft.findByFractOwner", query = "SELECT a FROM Aircraft a WHERE a.fractOwner = :fractOwner"), @NamedQuery(name = "Aircraft.findByLastActionDate", query = "SELECT a FROM Aircraft a WHERE a.lastActionDate = :lastActionDate"), @NamedQuery(name = "Aircraft.findByCertIssueDate", query = "SELECT a FROM Aircraft a WHERE a.certIssueDate = :certIssueDate"), @NamedQuery(name = "Aircraft.findByAirWorthDate", query = "SELECT a FROM Aircraft a WHERE a.airWorthDate = :airWorthDate")})
public class Aircraft implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "tail_num")
  private String tailNum;
  @Basic(optional = false)
  @Column(name = "aircraft_serial")
  private String aircraftSerial;
  @Basic(optional = false)
  @Column(name = "aircraft_model_code")
  private String aircraftModelCode;
  @Basic(optional = false)
  @Column(name = "aircraft_engine_code")
  private String aircraftEngineCode;
  @Basic(optional = false)
  @Column(name = "year_built")
  @Temporal(TemporalType.DATE)
  private Date yearBuilt;
  @Basic(optional = false)
  @Column(name = "aircraft_type_id")
  private short aircraftTypeId;
  @Basic(optional = false)
  @Column(name = "aircraft_engine_type_id")
  private short aircraftEngineTypeId;
  @Basic(optional = false)
  @Column(name = "registrant_type_id")
  private short registrantTypeId;
  @Basic(optional = false)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @Column(name = "address1")
  private String address1;
  @Basic(optional = false)
  @Column(name = "address2")
  private String address2;
  @Basic(optional = false)
  @Column(name = "city")
  private String city;
  @Basic(optional = false)
  @Column(name = "state")
  private String state;
  @Basic(optional = false)
  @Column(name = "zip")
  private String zip;
  @Basic(optional = false)
  @Column(name = "region")
  private char region;
  @Basic(optional = false)
  @Column(name = "county")
  private String county;
  @Basic(optional = false)
  @Column(name = "country")
  private String country;
  @Basic(optional = false)
  @Column(name = "certification")
  private String certification;
  @Basic(optional = false)
  @Column(name = "status_code")
  private char statusCode;
  @Basic(optional = false)
  @Column(name = "mode_s_code")
  private String modeSCode;
  @Basic(optional = false)
  @Column(name = "fract_owner")
  private char fractOwner;
  @Basic(optional = false)
  @Column(name = "last_action_date")
  @Temporal(TemporalType.DATE)
  private Date lastActionDate;
  @Basic(optional = false)
  @Column(name = "cert_issue_date")
  @Temporal(TemporalType.DATE)
  private Date certIssueDate;
  @Basic(optional = false)
  @Column(name = "air_worth_date")
  @Temporal(TemporalType.DATE)
  private Date airWorthDate;

  public Aircraft() {
  }

  public Aircraft(String tailNum) {
    this.tailNum = tailNum;
  }

  public Aircraft(String tailNum, String aircraftSerial, String aircraftModelCode, String aircraftEngineCode, Date yearBuilt, short aircraftTypeId, short aircraftEngineTypeId, short registrantTypeId, String name, String address1, String address2, String city, String state, String zip, char region, String county, String country, String certification, char statusCode, String modeSCode, char fractOwner, Date lastActionDate, Date certIssueDate, Date airWorthDate) {
    this.tailNum = tailNum;
    this.aircraftSerial = aircraftSerial;
    this.aircraftModelCode = aircraftModelCode;
    this.aircraftEngineCode = aircraftEngineCode;
    this.yearBuilt = yearBuilt;
    this.aircraftTypeId = aircraftTypeId;
    this.aircraftEngineTypeId = aircraftEngineTypeId;
    this.registrantTypeId = registrantTypeId;
    this.name = name;
    this.address1 = address1;
    this.address2 = address2;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.region = region;
    this.county = county;
    this.country = country;
    this.certification = certification;
    this.statusCode = statusCode;
    this.modeSCode = modeSCode;
    this.fractOwner = fractOwner;
    this.lastActionDate = lastActionDate;
    this.certIssueDate = certIssueDate;
    this.airWorthDate = airWorthDate;
  }

  public String getTailNum() {
    return tailNum;
  }

  public void setTailNum(String tailNum) {
    this.tailNum = tailNum;
  }

  public String getAircraftSerial() {
    return aircraftSerial;
  }

  public void setAircraftSerial(String aircraftSerial) {
    this.aircraftSerial = aircraftSerial;
  }

  public String getAircraftModelCode() {
    return aircraftModelCode;
  }

  public void setAircraftModelCode(String aircraftModelCode) {
    this.aircraftModelCode = aircraftModelCode;
  }

  public String getAircraftEngineCode() {
    return aircraftEngineCode;
  }

  public void setAircraftEngineCode(String aircraftEngineCode) {
    this.aircraftEngineCode = aircraftEngineCode;
  }

  public Date getYearBuilt() {
    return yearBuilt;
  }

  public void setYearBuilt(Date yearBuilt) {
    this.yearBuilt = yearBuilt;
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

  public short getRegistrantTypeId() {
    return registrantTypeId;
  }

  public void setRegistrantTypeId(short registrantTypeId) {
    this.registrantTypeId = registrantTypeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public char getRegion() {
    return region;
  }

  public void setRegion(char region) {
    this.region = region;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCertification() {
    return certification;
  }

  public void setCertification(String certification) {
    this.certification = certification;
  }

  public char getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(char statusCode) {
    this.statusCode = statusCode;
  }

  public String getModeSCode() {
    return modeSCode;
  }

  public void setModeSCode(String modeSCode) {
    this.modeSCode = modeSCode;
  }

  public char getFractOwner() {
    return fractOwner;
  }

  public void setFractOwner(char fractOwner) {
    this.fractOwner = fractOwner;
  }

  public Date getLastActionDate() {
    return lastActionDate;
  }

  public void setLastActionDate(Date lastActionDate) {
    this.lastActionDate = lastActionDate;
  }

  public Date getCertIssueDate() {
    return certIssueDate;
  }

  public void setCertIssueDate(Date certIssueDate) {
    this.certIssueDate = certIssueDate;
  }

  public Date getAirWorthDate() {
    return airWorthDate;
  }

  public void setAirWorthDate(Date airWorthDate) {
    this.airWorthDate = airWorthDate;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (tailNum != null ? tailNum.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Aircraft)) {
      return false;
    }
    Aircraft other = (Aircraft) object;
    if ((this.tailNum == null && other.tailNum != null) || (this.tailNum != null && !this.tailNum.equals(other.tailNum))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "net.ensode.jasperbook.jpa.Aircraft[tailNum=" + tailNum + "]";
  }
}
