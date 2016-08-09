package com.packtpub.java7.concurrency.chapter1.recipe7.task;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

import com.packtpub.java7.concurrency.chapter1.recipe7.event.Event;

/**
 * Runnable class that generates and event every second
 *
 */
public class WriterTask implements Runnable {

	/**
	 * Data structure to stores the events
	 */
	Deque<Event> deque;
	
	/**
	 * Constructor of the class
	 * @param deque data structure that stores the event
	 */
	public WriterTask (Deque<Event> deque){
		this.deque=deque;
	}
	
	/**
	 * Main class of the Runnable
	 */
	@Override
	public void run() {
		
		// Writes 100 events
		for (int i=1; i<100; i++) {
			// Creates and initializes the Event objects 
			Event event=new Event();
			event.setDate(new Date());
			event.setEvent(String.format("The thread %s has generated an event",Thread.currentThread().getId()));
			
			// Add to the data structure
			deque.addFirst(event);
			try {
				// Sleeps during one second
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
