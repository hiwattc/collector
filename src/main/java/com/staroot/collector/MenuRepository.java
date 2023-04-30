package com.staroot.collector;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findAllByParentIsNull();

    List<Menu> findAllByParentIsNull(Sort sort);

    @Query("select parentMenu from Menu parentMenu" +
            " left join parentMenu.children child " +
            " where parentMenu.parent is null" +
            " order by parentMenu.listOrder asc, child.listOrder asc")
    List<Menu> findAllWithJpql();
}
