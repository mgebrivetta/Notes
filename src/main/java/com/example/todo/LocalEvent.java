/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo;

import javafx.scene.control.Alert;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class LocalEvent implements Serializable  {

    private static final long serialVersionUID = 1L;

    private LocalDate date;

    private String description;
    private String strEvent;

    //makes event
    public LocalEvent(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }

    // this makes LocalEvents dispaly nicely in GUI
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLL yyyy");
        String formattedString = date.format(formatter);
        if (description.startsWith(" ")||description.equals("")||description.startsWith("<")||description.startsWith("(")
                ||description.startsWith("[")||description.startsWith("{")||description.startsWith("^")||description.startsWith("-")
                ||description.startsWith("+")||description.startsWith("=")||description.startsWith("$")||description.startsWith("!")
                ||description.startsWith("|")||description.startsWith("]")||description.startsWith("}")||description.startsWith(")")
                ||description.startsWith("?")||description.startsWith("&")||description.startsWith("*")||description.startsWith(":")
                ||description.startsWith(".")||description.startsWith(";")||description.startsWith("'")||description.startsWith(">"))
        {
            strEvent = "ОШИБКА";
        } else{
            strEvent = formattedString + ": " + description;
        }
        return strEvent;
    }

}
