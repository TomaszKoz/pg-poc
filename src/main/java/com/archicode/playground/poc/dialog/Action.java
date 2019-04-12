package com.archicode.playground.poc.dialog;

/**
 * Functional interface used to handle dialog buttons actions.
 * @author Tomasz Kozlowski (created on 12.04.2019)
 */
@FunctionalInterface
public interface Action {

    /** Runs given action associated with dialog button */
    void run();

}
