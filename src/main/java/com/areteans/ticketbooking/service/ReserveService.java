package com.areteans.ticketbooking.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReserveService implements Runnable {
    private Integer available_berth = 1;
    private Integer wanted_berth;
    public int i;

    public ReserveService() {
        wanted_berth=i;
    }
    @Override
    public void run() {
        synchronized (this) {
            log.error("Available Berths= " + available_berth);
            if (available_berth >= wanted_berth) {
                String name = Thread.currentThread().getName();
                log.error(wanted_berth + "Berth is reserved for " + name);
                try {
                    Thread.sleep(1500);
                    available_berth = available_berth - wanted_berth;
                } catch (InterruptedException ie) {
                }
            } else
                log.error("Sorry, no berths available");
        }

    }
}


