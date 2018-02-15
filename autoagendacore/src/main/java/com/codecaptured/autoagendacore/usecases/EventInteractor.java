package com.codecaptured.autoagendacore.usecases;

import com.codecaptured.autoagendacore.entities.Event;
import com.codecaptured.autoagendacore.entities.TimeBlock;

import java.util.UUID;
import java.util.Date;

/**
 * This is used when interacting (creating, modifying, removing) events. Also controls the interface
 * needed for talking to this class
 */
public class EventInteractor
{
	// TODO: Should also return some sort of message to indicate if it was scheduled properly or not.
	public static void addEvent(UserEvent newEvent)
	{
		// Create a new ID
		UUID id = UUID.randomUUID();

		// Add ID to UserEvent
		newEvent.setId(id);

		// Make the event
		Event event = new Event(newEvent.getId(), newEvent.getTitle(), newEvent.getDescription(),
						newEvent.getEventTime(), newEvent.getPriorityLevel(), newEvent.getTags());

		// Add to scheduler to decide where to put it in the schedule
		Scheduler.addEvent(event);
	}

	public static void modifyEvent(UserEvent originalEvent, UserEvent newEvent)
	{
		// Make the IDs the same
		newEvent.setId(originalEvent.getId());

		// Remove the old event
		Scheduler.removeEvent(originalEvent.getId());

		// Make the event
		Event event = new Event(newEvent.getId(), newEvent.getTitle(), newEvent.getDescription(),
						newEvent.getEventTime(), newEvent.getPriorityLevel(), newEvent.getTags());

		// Add to scheduler to decide where to put it in the schedule
		Scheduler.addEvent(event);
	}

	public static void removeEvent(UserEvent oldEvent)
	{
		// Delete old event
		Scheduler.removeEvent(oldEvent.getId());
	}

	public interface UserEvent
	{
		// Default values
		String DEFAULT_TITLE = "";
		String DEFAULT_DESCRIPTION = "";
		TimeBlock DEFAULT_EVENT_TIME = new TimeBlock(new Date(0), 0);
		int DEFAULT_PRIORITY_LEVEL = 5;
		String[] DEFAULT_TAGS = {""};

		// Getters and setters
		// Values set by user
		String getTitle();
		void setTitle(String title);
		String getDescription();
		void setDescription(String description);
		TimeBlock getEventTime();
		void setEventTime(TimeBlock timeBlocks);
		int getPriorityLevel();
		void setPriorityLevel(int priorityLevel);
		String[] getTags();
		void setTags(String[] tags);

		// Set by software
		UUID getId();
		void setId(UUID id);
	}



}
