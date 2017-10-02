/*
 * ResetCurrentValue
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
 * Resets current values.
 *
 * @author Kena Shah
 * @version 1.0
 */
public class ResetCurrentValue {
    private Counter current_counter;
    private Integer initial_value;

    public ResetCurrentValue() {
        initial_value = current_counter.getInitial_value();
        current_counter.setCurrent_value(initial_value);
    }

}
