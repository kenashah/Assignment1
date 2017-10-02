/*
 * Counter
 *
 * Version 1.0
 *
 * October 1, 2017
 *
 * Copyright (c) 2017 Kena Shah, CMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the
 * Code of Student Behavior at the University of Alberta.
 * You can find a copy of the license of this project. Otherwise please contact contact@abc.ca.
 */

package com.example.kena_countbook;

import java.util.Date;


/**
 * Represents the Counter class.
 *
 * @author Kena Shah
 * @version 1.0
 * @since 1.0
 */
public class Counter {
    private String name;
    private Integer current_value;
    private Integer initial_value;
    private Date date;
    private String comment;

    /**
     * Called when the class is used.
     *
     * @param name              Name of counter.
     * @param initial_value     Initial value of counter.
     * @param current_value     Current value of counter.
     * @param date              Date the counter was created.
     * @param comment           Counter comment.
     */
    public Counter(String name, Integer initial_value, Integer current_value,
                   Date date, String comment) {
        this.name = name;
        this.current_value = current_value;
        this.initial_value = initial_value;
        this.date = date;
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrent_value(Integer current_value) {
        this.current_value = current_value;
    }

    public void setInitial_value(Integer initial_value) {
        this.initial_value = initial_value;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public Integer getCurrent_value() {
        return current_value;
    }

    public Integer getInitial_value() {
        return initial_value;
    }

    public Date getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

}
