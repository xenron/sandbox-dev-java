package net.ensode.glassfishbook;

import javax.ejb.Remote;

@Remote
public interface SimpleSession {
    public String getMessage();
}
