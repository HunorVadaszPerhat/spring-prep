package org.springprep.decouplingpayoff;

/**
 * The contract that other services (like OrderService)
 * will depend on. It defines *what* can be done, not *how*.
 */
public interface Notifier {
    void send(Order order);
}
