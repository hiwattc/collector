package com.staroot.collector;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    private final UsersRepository userRepository;

    public List<MenuResult> getV1Menus() {
        final List<Menu> all = menuRepository.findAll();
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }

    public List<MenuResult> getV2Menus() {
        final List<Menu> all = menuRepository.findAllByParentIsNull();
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }

    public List<MenuResult> getV3Menus() {
        final List<Menu> all = menuRepository.findAll(Sort.by(Sort.Direction.ASC, "listOrder"));
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }

    public List<MenuResult> getV4Menus() {
        final List<Menu> all = menuRepository.findAllByParentIsNull(Sort.by(Sort.Direction.ASC, "listOrder"));
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }

    public List<MenuResult> getV5Menus() {
        final List<Menu> all = menuRepository.findAllWithJpql();
        return all.stream().map(MenuResult::new).collect(Collectors.toList());
    }


    @Transactional
    public Long addMenu(final MenuParam param) {
        final Users user = userRepository.findById(param.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 User 입니다."));

        final Menu parent = menuRepository.findById(param.getParentId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Menu 입니다."));

        final Menu menu = Menu.builder()
                .name(param.getName())
                .ipAddress(param.getIp())
                .parent(parent)
                .user(user)
                .priorityType(param.getPriority())
                .build();
        final Menu savedMenu = menuRepository.save(menu);
        return savedMenu.getId();
    }

}
