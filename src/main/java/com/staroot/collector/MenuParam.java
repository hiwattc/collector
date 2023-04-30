package com.staroot.collector;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MenuParam {

    private String name;

    private String ip;

    private Long userId;

    private Long parentId;

    private PriorityType priority;
}
