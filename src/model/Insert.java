package model;

import java.util.Date;

public class Insert extends Todo{
    public Insert(int id, String title, String description, Date deadline, int priority, boolean done) {
        super(id, title, description, deadline, priority, done);
    }

}
