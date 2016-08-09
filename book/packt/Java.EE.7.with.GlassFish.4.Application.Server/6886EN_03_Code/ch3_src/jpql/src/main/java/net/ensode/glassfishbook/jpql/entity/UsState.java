package net.ensode.glassfishbook.jpql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="US_STATES")
public class UsState
{
  @Column(name="US_STATE_ID")
  @Id
  private Long usStateId;
  
  @Column(name="US_STATE_CD")
  private String usStateCd;
  
  @Column(name="US_STATE_NM")
  private String usStateNm;

  public String getUsStateCd()
  {
    return usStateCd;
  }

  public void setUsStateCd(String usStateCd)
  {
    this.usStateCd = usStateCd;
  }

  public Long getUsStateId()
  {
    return usStateId;
  }

  public void setUsStateId(Long usStateId)
  {
    this.usStateId = usStateId;
  }

  public String getUsStateNm()
  {
    return usStateNm;
  }

  public void setUsStateNm(String usStateNm)
  {
    this.usStateNm = usStateNm;
  }
}
