package com.packtpub.java7.concurrency.chapter3.recipe6.task;

import java.util.concurrent.Phaser;

/**
 * Implements a subclass of the Phaser class. Overrides the onAdvance method to control
 * the change of phase 
 *
 */
public class MyPhaser extends Phaser {

	/**
	 * This method is called when the last register thread calls one of the advance methods
	 * in the actual phase
	 * @param phase Actual phase
	 * @param registeredParties Number of registered threads
	 * @return false to advance the phase, true to finish
	 */
	@Override
	protected boolean onAdvance(int phase, int registeredParties) {
		switch (phase) {
		case 0:
			return studentsArrived();
		case 1:
			return finishFirstExercise();
		case 2:
			return finishSecondExercise();
		case 3:
			return finishExam();
		default:
			return true;
		}
	}

	/**
	 * This method is called in the change from phase 0 to phase 1
	 * @return false to continue with the execution
	 */
	private boolean studentsArrived() {
		System.out.printf("Phaser: The exam are going to start. The students are ready.\n");
		System.out.printf("Phaser: We have %d students.\n",getRegisteredParties());
		return false;
	}

	/**
	 * This method is called in the change from phase 1 to phase 2
	 * @return false to continue with the execution
	 */
	private boolean finishFirstExercise() {
		System.out.printf("Phaser: All the students has finished the first exercise.\n");
		System.out.printf("Phaser: It's turn for the second one.\n");
		return false;
	}

	/**
	 * This method is called in the change form phase 2 to phase 3
	 * @return false to continue with the execution
	 */
	private boolean finishSecondExercise() {
		System.out.printf("Phaser: All the students has finished the second exercise.\n");
		System.out.printf("Phaser: It's turn for the third one.\n");
		return false;
	}

	/**
	 * This method is called in the change from phase 3 to phase 4
	 * @return true. There are no more phases
	 */
	private boolean finishExam() {
		System.out.printf("Phaser: All the students has finished the exam.\n");
		System.out.printf("Phaser: Thank you for your time.\n");
		return true;
	}

}
