package com.example.kena_countbook;

import java.util.Date;

/**
 * Created by kenajshah on 2017-09-25.
 */

public class Counter {
    private String name;
    private Integer current_value;
    private Integer initial_value;
    private Date date;
    private String comment;

    public Counter(String name, Integer initial_value, Integer current_value,
                   Date date, String comment) {
        this.name = name;
        this.current_value = current_value;
        this.initial_value = initial_value;
        this.date = date;
        this.comment = comment;
    }
}
