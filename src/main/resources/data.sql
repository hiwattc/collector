insert into menu(id, parent_id, name, list_order) values(1, null, '1. 메뉴', 1);
insert into menu(id, parent_id, name, list_order) values(2, null, '2. 메뉴', 2);
insert into menu(id, parent_id, name, list_order) values(3, null, '3. 메뉴', 3);
insert into menu(id, parent_id, name, list_order) values(4, 1, '1-1. 하위 메뉴', 1);
insert into menu(id, parent_id, name, list_order) values(5, 1, '1-2. 하위 메뉴', 2);
insert into menu(id, parent_id, name, list_order) values(6, 2, '2-1. 하위 메뉴', 1);

update menu set list_order=3 where id=1;
update menu set list_order=1 where id=3;
update menu set list_order=2 where id=4;
update menu set list_order=1 where id=5;


INSERT INTO Products (prod_name, prod_price) values ('롤휴지', 2700);
INSERT INTO Products (prod_name, prod_price) values ('슬리퍼', 3500);
INSERT INTO Products (prod_name, prod_price) values ('양말', 3000);
INSERT INTO Products (prod_name, prod_price) values ('우산', 8500);

INSERT 
	INTO MB_MBR 
    	(MBR_NM, MBR_CP_NO, REG_DT) 
        VALUES
        ('이서진', '010-6666-6555', now())
        , ('이수린', '010-3232-3444', now())
        , ('박한민', '010-3232-3444', now())
        , ('박진환', '010-3232-3444', now())
        , ('강서준', '010-3232-3444', now())
        , ('이세진', '010-3232-3444', now());


