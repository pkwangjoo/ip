package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDateTime start;
    private LocalDateTime end;
    public Event(String taskDescription, LocalDateTime start, LocalDateTime end) {
        super(taskDescription);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toStorageFormatString() {
        return "E|" + (isDone? "1" : "0") + "|" +
                this.taskDescription + "|" +
                this.start.format(DateTimeFormatter.ofPattern("d/M/yyyy HHmm")) + "|" + this.end.format(DateTimeFormatter.ofPattern("d/M/yyyy HHmm"));
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM d yyyy HHmm");
        return "[E]" + super.toString() + " (from: " + start.format(dateTimeFormatter) + " to: " + end.format(dateTimeFormatter) +")";
    }

}