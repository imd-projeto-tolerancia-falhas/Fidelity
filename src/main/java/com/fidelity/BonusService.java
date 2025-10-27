package com.fidelity;

import com.fidelity.dto.BonusRequest;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BonusService {

    private final Map<String, Integer> bonusMap = new ConcurrentHashMap<>();

    public Integer addBonus(BonusRequest request) {
        Integer currentBonus = bonusMap.getOrDefault(request.user(), 0);
        Integer newTotalBonus = currentBonus + request.bonus();
        bonusMap.put(request.user(), newTotalBonus);
        return newTotalBonus;
    }
}
