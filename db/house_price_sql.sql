CREATE TABLE `community` (
  `id` int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` int(5) DEFAULT NULL COMMENT '年',
  `month` int(3) DEFAULT NULL COMMENT '月',
  `city` varchar(5) DEFAULT NULL COMMENT '城市',
  `district` varchar(15) DEFAULT NULL COMMENT '区县',
  `area` varchar(15) DEFAULT NULL COMMENT '板块',
  `name` varchar(100) DEFAULT NULL COMMENT '小区名称',
  `price` varchar(15) DEFAULT NULL COMMENT '小区均价',
  `on_sale` varchar(15) DEFAULT NULL COMMENT '在售套数',
  UNIQUE (`year`, `month`, `name`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

insert into community(year, month, city, district, area, name, price, on_sale)
values (2019, 8, 'cq', 'yubei', 'zhaomushan', 'testname', '18000', '888套');

select * from community;

select count(*) from community;

ALTER TABLE community MODIFY name varchar(100);

ALTER TABLE community ADD UNIQUE (name, year, month);

insert ignore into community(year, month, city, district, area, name, price, on_sale)
values (2019, 7, 'cq', 'yubei', 'zhaomushan', 'testname', '17000', '222套');
