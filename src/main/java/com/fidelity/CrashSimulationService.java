package com.fidelity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CrashSimulationService {

    private static final Logger log = LoggerFactory.getLogger(CrashSimulationService.class);

    @Value("${crash.probability:0.02}")
    private volatile double probability;

    public void runCrash(){
        if (ThreadLocalRandom.current().nextDouble() < probability){
            log.warn("Crashing service");
            System.exit(0);
        }
    }

}

