package com.baselogic.chapter02;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public aspect Audit {
    declare parents: @Entity * implements AuditedEntity;

    public abstract class AuditedEntity {}

    @PrePersist
    public void Audit.AuditedEntity.prePersistAuditing() {
       //... auditing logic
    }

    @PreUpdate
    public void Audit.AuditedEntity.preUpdateAuditing() {
       //... auditing logic
    }

    //... similar code for @PreUpdate
}
