package com.baselogic.chapter02;

import java.io.Serializable;

import javax.persistence.*;

/**
 * [Title]
 *
 * @author Mick Knutson (<a href="http://www.baselogic.com">http://www.baselogic.com</a>)
 * @since 2011
 */
@Entity
public class AuditField implements Serializable {

    private static final long serialVersionUID = 1234567890L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String fieldName;

    @Lob
    private String fieldValue;

    @ManyToOne
    @JoinColumn(name = Constants.AUDIT_ENTRY_ID)
    private AuditEntry auditEntry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public AuditEntry getAuditEntry() {
        return auditEntry;
    }

    public void setAuditEntry(AuditEntry auditEntry) {
        this.auditEntry = auditEntry;
    }
}
