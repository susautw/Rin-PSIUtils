package me.susautw.rin_psiutils.exception;

public class TeleportationFailedException extends Exception{
    public TeleportationFailedException(Throwable throwable){
        super("teleportation has failed", throwable);
    }
}
