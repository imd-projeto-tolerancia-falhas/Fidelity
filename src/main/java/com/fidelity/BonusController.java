package com.fidelity;

import com.fidelity.dto.BonusRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bonus")
public class BonusController {
    private final BonusService bonusService;

    public BonusController(BonusService bonusService) {
        this.bonusService = bonusService;
    }

    @PostMapping
    public ResponseEntity<Integer> addBonus(@RequestBody BonusRequest request) {
        var bonus = bonusService.addBonus(request);
        if (bonus == null) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(bonus);
    }
}
