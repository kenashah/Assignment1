/*
 * DecrementCurrentValue
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


/**
 * Decrements current value.
 *
 * @author Kena Shah
 * @version 1.0
 */
public class DecrementCurrentValue {
    private Integer current_value;
    private Counter current_counter;
    private Integer newCurrentValue;

    public DecrementCurrentValue() {
        current_value = current_counter.getCurrent_value();
        newCurrentValue = current_value--;
        current_counter.setCurrent_value(newCurrentValue);
    }
}
