package com.staroot.collector;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public class MenuResult {

    private Long id;

    private String name;

    private int listOrder;

    private List<MenuResult> children;

    public MenuResult(final Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.listOrder = menu.getListOrder();
        this.children = menu.getChildren().stream().map(MenuResult::new).collect(Collectors.toList());
    }

}