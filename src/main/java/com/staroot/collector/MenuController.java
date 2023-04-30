package com.staroot.collector;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/v1/menus")
    public ResponseEntity<List<MenuResult>> getV1Menus() {
        final List<MenuResult> menus = menuService.getV1Menus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/v2/menus")
    public ResponseEntity<List<MenuResult>> getV2Menus() {
        final List<MenuResult> menus = menuService.getV2Menus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/v3/menus")
    public ResponseEntity<List<MenuResult>> getV3Menus() {
        final List<MenuResult> menus = menuService.getV3Menus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/v4/menus")
    public ResponseEntity<List<MenuResult>> getV4Menus() {
        final List<MenuResult> menus = menuService.getV4Menus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/v5/menus")
    public ResponseEntity<List<MenuResult>> getV5Menus() {
        final List<MenuResult> menus = menuService.getV5Menus();
        return ResponseEntity.ok(menus);
    }


    @PostMapping("/menu")
    public ResponseEntity<Map<String, Long>> addMenu(@RequestBody MenuParam param) {
        Long id = menuService.addMenu(param);
        return ResponseEntity.ok().body(Map.of("id", id));
    }
}
