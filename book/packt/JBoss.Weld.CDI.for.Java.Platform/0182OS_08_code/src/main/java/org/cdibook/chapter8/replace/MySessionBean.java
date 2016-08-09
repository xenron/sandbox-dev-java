package org.cdibook.chapter8.replace;

import java.io.Serializable;

@PojoDoc(value = "userSession", scope = ScopeEnum.SESSION)
public class MySessionBean implements Serializable {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
