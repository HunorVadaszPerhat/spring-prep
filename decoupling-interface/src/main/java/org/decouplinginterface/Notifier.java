package org.decouplinginterface;

/**
 * Step 1 — extract the contract.
 * The Notifier interface is the contract that other services (like OrderService)
 * will depend on. It defines *what* can be done, not *how*.
 */
public interface Notifier {
    void send(Order order);
}
