package me.susautw.rin_psiutils.exception;

import org.jetbrains.annotations.NotNull;

public class NotImplementedException extends Exception {
    public NotImplementedException(@NotNull String method) {
        super("Method " + method + " was not implemented.");
    }
}
