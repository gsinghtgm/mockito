/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.verification;

import org.mockito.internal.invocation.PrintSettings;
import org.mockito.internal.invocation.PrintingFriendlyInocation;

/**
 * Makes sure both wanted and actual are printed consistently (single line or multiline)
 * <p>
 * Makes arguments printed with types if necessary
 */
public class SmartPrinter {

    private final String wanted;
    private final String actual;

    public SmartPrinter(PrintingFriendlyInocation wanted, PrintingFriendlyInocation actual) {
        PrintSettings printSettings = new PrintSettings();
        printSettings.setMultiline(wanted.toString().contains("\n") || actual.toString().contains("\n"));
        printSettings.setVerboseArguments(wanted.toString().equals(actual.toString()));
        
        this.wanted = wanted.toString(printSettings);
        this.actual = actual.toString(printSettings);
    }

    public String getWanted() {
        return wanted;
    }

    public String getActual() {
        return actual;
    }
}