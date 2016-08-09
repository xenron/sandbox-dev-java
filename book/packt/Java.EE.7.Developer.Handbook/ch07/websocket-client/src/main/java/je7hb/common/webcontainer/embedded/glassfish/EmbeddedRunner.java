/*******************************************************************************
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013,2014 by Peter Pilgrim, Addiscombe, Surrey, XeNoNiQUe UK
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU GPL v3.0
 * which accompanies this distribution, and is available at:
 * http://www.gnu.org/licenses/gpl-3.0.txt
 *
 * Developers:
 * Peter Pilgrim -- design, development and implementation
 *               -- Blog: http://www.xenonique.co.uk/blog/
 *               -- Twitter: @peter_pilgrim
 *
 * Contributors:
 *
 *******************************************************************************/

package je7hb.common.webcontainer.embedded.glassfish;

import java.util.Scanner;

/**
 * The type EmbeddedRunner
 *
 * @author Peter Pilgrim
 */
public class EmbeddedRunner extends AbstractEmbeddedRunner {

    public EmbeddedRunner(int port) {
        super(port);
    }

    public static void main(String args[]) throws Exception {
        EmbeddedRunner runner = (EmbeddedRunner) new EmbeddedRunner(8080).init().start();

        runner.deployWithRename("build/libs/ch07-websockets-client-1.0.war", "mywebapp");
        Thread.sleep(1000);
        System.out.printf("**** Press the ENTER key to stop the server ****\n");
        Scanner sc = new Scanner(System.in);
        while(!sc.nextLine().equals(""));
        runner.stop();
    }
}
