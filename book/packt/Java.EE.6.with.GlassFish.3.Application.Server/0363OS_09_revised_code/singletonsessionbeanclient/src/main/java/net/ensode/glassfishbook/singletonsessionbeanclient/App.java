package net.ensode.glassfishbook.singletonsessionbeanclient;

import java.util.List;
import javax.ejb.EJB;
import net.ensode.glassfishbook.entity.UsStates;
import net.ensode.glassfishbook.singletonsession.SingletonSessionBeanRemote;

public class App {

    @EJB
    private static SingletonSessionBeanRemote singletonSessionBeanRemote;

    public void printStateList() {
        List<UsStates> stateList = singletonSessionBeanRemote.getStateList();

        for (UsStates usState : stateList) {
            System.out.println(usState.getUsStateNm());
        }
    }

    public static void main(String[] args) {
        new App().printStateList();
    }
}
