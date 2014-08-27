insert into d_receive_address values(1, 6,'Java','sun.cn','10000800','12345','67890');
insert into d_receive_address values(2, 6,'JavaJavaJava','ibm.cn','10000600','12345','67890');


INSERT INTO d_category VALUES (1,1,'Book','图书',NULL,0,null, '1');
INSERT INTO d_category VALUES (2,1,'Novel','小说',NULL,1, null,'1.2');
INSERT INTO d_category VALUES (3,2,'Youth','青春',NULL,1, null,'1.3');
INSERT INTO d_category VALUES (4,3,'Humanity And Social Science','人文社科',NULL,1, null,'1.4');
INSERT INTO d_category VALUES (5,4,'Management','管理',NULL,1, null,'1.5');
INSERT INTO d_category VALUES (6,5,'Children','少儿',NULL,1, null,'1.6');
INSERT INTO d_category VALUES (7,6,'Foreign Language','外语',NULL,1, null,'1.7');
INSERT INTO d_category VALUES (8,7,'Computer','计算机',NULL,1, null,'1.8');
INSERT INTO d_category VALUES (9,1,'Chinese Contemporary Novel','当代小说',NULL,2, null,'1.2.9');
INSERT INTO d_category VALUES (10,2,'Chinese Modern Novel','近现代小说',NULL,2, null,'1.2.10');
INSERT INTO d_category VALUES (11,3,'Chinese Classical  Novel','古典小说',NULL,2, null,'1.2.11');
INSERT INTO d_category VALUES (12,4,'Four Classic Novels','四大名著',NULL,2, null,'1.2.12');
INSERT INTO d_category VALUES (13,5,'Translated Works','世界名著',NULL,2, null,'1.2.13');
INSERT INTO d_category VALUES (14,1,'School','校园',NULL,3, null,'1.3.14');
INSERT INTO d_category VALUES (15,2,'Love','爱情/情感',NULL,3, null,'1.3.15');
INSERT INTO d_category VALUES (16,3,'Grow Up','叛逆/成长',NULL,3, null,'1.3.16');
INSERT INTO d_category VALUES (17,4,'Fantasy','玄幻',NULL,3, null,'1.3.17');
INSERT INTO d_category VALUES (18,5,'Original','原创',NULL,3, null,'1.3.18');
INSERT INTO d_category VALUES (19,1,'Political','政治',NULL,4, null,'1.4.19');
INSERT INTO d_category VALUES (20,2,'Economic','经济',NULL,4, null,'1.4.20');
INSERT INTO d_category VALUES (21,3,'Law','法律',NULL,4, null,'1.4.21');
INSERT INTO d_category VALUES (22,4,'Philosophy','哲学',NULL,4, null,'1.4.22');
INSERT INTO d_category VALUES (23,5,'History','历史',NULL,4, null,'1.4.23');
INSERT INTO d_category VALUES (24,1,'Commen Management','管理学',NULL,5, null,'1.5.24');
INSERT INTO d_category VALUES (25,2,'Strategic Management','战略管理',NULL,5, null,'1.5.25');
INSERT INTO d_category VALUES (26,3,'Marketing','市场营销',NULL,5, null,'1.5.26');
INSERT INTO d_category VALUES (27,4,'Business History','商业史传',NULL,5, null,'1.5.27');
INSERT INTO d_category VALUES (28,5,'E-Business','电子商务',NULL,5, null,'1.5.28');
INSERT INTO d_category VALUES (29,1,'0-2','0-2岁',NULL,6, null,'1.6.29');
INSERT INTO d_category VALUES (30,2,'3-6','3-6岁',NULL,6, null,'1.6.30');
INSERT INTO d_category VALUES (31,3,'7-10','7-10岁',NULL,6, null,'1.6.31');
INSERT INTO d_category VALUES (32,4,'11-14','11-14岁',NULL,6, null,'1.6.32');
INSERT INTO d_category VALUES (33,5,'Child Literature','儿童文学',NULL,6, null,'1.6.33');
INSERT INTO d_category VALUES (34,1,'English','英语',NULL,7, null,'1.7.34');
INSERT INTO d_category VALUES (35,2,'Japanese','日语',NULL,7, null,'1.7.35');
INSERT INTO d_category VALUES (36,3,'Korean','韩语',NULL,7, null,'1.7.36');
INSERT INTO d_category VALUES (37,4,'Russian','俄语',NULL,7, null,'1.7.37');
INSERT INTO d_category VALUES (38,5,'German','德语',NULL,7, null,'1.7.38');
INSERT INTO d_category VALUES (39,1,'Computer Theory','计算机理论',NULL,8, null,'1.8.39');
INSERT INTO d_category VALUES (40,2,'Database','数据库',NULL,8, null,'1.8.40');
INSERT INTO d_category VALUES (41,3,'Programming','程序设计',NULL,8, null,'1.8.41');
INSERT INTO d_category VALUES (42,4,'Artificial Intelligence','人工智能',NULL,8, null,'1.8.42');
INSERT INTO d_category VALUES (43,5,'Computer Examination','计算机考试',NULL,8, null,'1.8.43');




#
# Dumping data for table d_d_product
#
#小说--当代小说
INSERT INTO d_product VALUES (1,'1988我想和这个世界谈谈','揭露社会的黑暗以及作者的所见所闻', 1237873000234,20.5,18.3,'当代小说',0,'1.jpg');
INSERT INTO d_product VALUES (2,'他的国','讲述他的国家的故事', 1237873000234,26.6,18.0,'当代小说',0,'2.jpg');
INSERT INTO d_product VALUES (3,'痕迹','讲述成长的岁月', 1237873000234,23.6,15.6,'当代小说',0,'3.jpg');
INSERT INTO d_product VALUES (4,'三重门','命运的门向我们敞开着', 1237873000234,30.6,25.3,'当代小说',0,'4.jpg');
INSERT INTO d_product VALUES (5,'世界上最干净的阴谋','讲述社会的现实和黑暗', 1237873000234,36.2,23.6,'当代小说',0,'5.jpg');
INSERT INTO d_product VALUES (6,'暗算','阴谋的层出不穷，一个接着一个', 1237873000234,25.6,23.6,'当代小说',0,'6.jpg');
INSERT INTO d_product VALUES (7,'风声','讲述地下工作者的秘密工作', 1237873000234, 26.3,25.6,'当代小说',0,'7.jpg');
INSERT INTO d_product VALUES (8,'解密','秘密的一步步被发现', 1237873000234,23.6,18.0,'key',0,'8.jpg');
INSERT INTO d_product VALUES (9,'谍恋倾城','讲述间谍之间的爱恨情仇', 1237873000234,15.6,13.6,'key',0,'9.jpg');
INSERT INTO d_product VALUES (10,'迷途','命运的不公，现实的迷茫', 1237873000234,15.6,13.6,'key',0,'10.jpg');

INSERT INTO d_book VALUES (1,'韩寒','文艺出版社','2010-9-11','1万',1,100,'2010-8-11',NULL,'12345678','年轻的实力派作家','这真是一本好书啊');
INSERT INTO d_book VALUES (2,'李斯','文艺出版社', '2010-7-11','1万',1,100, '2010-2-11',NULL,'12345678','具有自己的写作风格','这真是一本好书啊');
INSERT INTO d_book VALUES (3,'张莽','文艺出版社', '2004-8-11','1万',1,100, '2010-2-11',NULL,'12345678','别具一个的写作风格','这真是一本好书啊');
INSERT INTO d_book VALUES (4,'张笑笑','文艺出版社', '2005-8-11','1万',1,100, '2010-3-11',NULL,'12345678','文字犀利，为人放荡不羁','这真是一本好书啊');
INSERT INTO d_book VALUES (5,'章丘','文艺出版社', '2010-6-8','1万',1,100, '2010-2-11',NULL,'12345678','文字优美而犀利','这真是一本好书啊');

#小说--当代小说

INSERT INTO d_product VALUES (11,'文心雕龙','中国古典文学理论批评专著逻辑', 1237873000234,45.3,36.6,'key',0,'11.jpg');
INSERT INTO d_product VALUES (12,'礼拜诗文集','礼拜所有诗集的总汇', 1237873000234 ,56.3,23.5,'key',0,'12.jpg');
INSERT INTO d_product VALUES (13,'聊斋志异','中国古代悬疑小说', 1237873000234,38,36.3,'key',0,'13.jpg');
INSERT INTO d_product VALUES (14,'三国演义','讲述三国群雄争霸的故事', 1237873000234,56,52,'key',0,'14.jpg');
INSERT INTO d_product VALUES (15,'西游记','唐僧师傅西天取经的故事', 1237873000234,25.3,23.2,'key',0,'15.jpg');
INSERT INTO d_product VALUES (16,'水浒传','108条梁山好汉的故事', 1237873000234,25.4,15.3,'key',0,'16.jpg');
INSERT INTO d_product VALUES (17,'唐诗宋词','唐朝和宋朝文化的集锦', 1237873000234,56.3,25.6,'key',0,'17.jpg');
INSERT INTO d_product VALUES (18,'儒林外传','讲述儒林外的故事',1237873000234,26,25.3,'key',0,'18.jpg');
INSERT INTO d_product VALUES (19,'世说新语','讲述古代的名言警句', 1237873000234,59,58.6,'key',0,'19.jpg');
INSERT INTO d_product VALUES (20,'中华上下五千年','讲述中华名族上下五千年的故事', 1237873000234,45,36.5,'key',0,'20.jpg');

INSERT INTO d_book VALUES (11,'张骞','诗集出版社','2000-9-11','1万',1,100,'2000-8-11',NULL,'12345678','年轻的实力派作家','这真是一本好书啊');
INSERT INTO d_book VALUES (12,'航权','诗集出版社','2003-7-3','1万',1,100,'2003-2-3',NULL,'12345678','具有自己的写作风格','这真是一本好书啊');
INSERT INTO d_book VALUES (13,'马千山','诗集出版社','2005-4-3','1万',1,100,'2002-2-3',NULL,'12345678','别具一个的写作风格','这真是一本好书啊');
INSERT INTO d_book VALUES (14,'谭笑笑','诗集出版社', '2010-6-8','1万',1,100, '2010-9-8',NULL,'12345678','文字犀利，为人放荡不羁','这真是一本好书啊');
INSERT INTO d_book VALUES (15,'吴刚','诗集出版社', '2003-8-8','1万',1,100, '2003-6-8',NULL,'12345678','文字优美而犀利','这真是一本好书啊');
INSERT INTO d_book VALUES (16,'何家乐','诗集出版社', '2004-6-8','1万',1,100, '2003-6-8',NULL,'12345678','别具一个的写作风格','这真是一本好书啊');
INSERT INTO d_book VALUES (17,'张佳琪','诗集出版社', '2000-6-8','1万',1,100, '2010-6-8',NULL,'12345678','文字犀利，为人放荡不羁','这真是一本好书啊');
INSERT INTO d_book VALUES (18,'封山名','诗集出版社', '2001-6-8','1万',1,100, '2000-6-8',NULL,'12345678','年轻的实力派作家','这真是一本好书啊');
INSERT INTO d_book VALUES (19,'章远','诗集出版社', '2000-6-8','1万',1,100, '2010-6-8',NULL,'12345678','文字犀利，为人放荡不羁','这真是一本好书啊');
INSERT INTO d_book VALUES (20,'张晓','诗集出版社', '2000-6-8','1万',1,100, '2012-6-8',NULL,'12345678','具有自己的写作风格','这真是一本好书啊');



#小说--近代小说
INSERT INTO d_product VALUES (21,'呐喊彷偟','现代小说经典之作', 1437873000234,45.3,35.2,'key',0,'21.jpg');
INSERT INTO d_product VALUES (22,'阿Q正传','讲述阿Q的故事', 1257873000234,25.6,23.2,'key',0,'22.jpg');
INSERT INTO d_product VALUES (23,'边城','沈从文的讲述边城的故事', 1238873000234,15.3,14.3,'key',0,'23.jpg');
INSERT INTO d_product VALUES (24,'人生','讲述人生的起起落落', 1037873000234,16.3,15.6,'key',0,'24.jpg');
INSERT INTO d_product VALUES (25,'城南旧事','城南的古老的故事', 7237873000234,63.2,23.2,'key',0,'25.jpg');
INSERT INTO d_product VALUES (26,'四士同堂','讲述家族一起成长的故事', 1337873000234,23.1,20.3,'key',0,'26.jpg');
INSERT INTO d_product VALUES (27,'海上花开','讲述在海上漂泊的岁月', 1257873000234,25.3,20.3,'key',0,'27.jpg');

INSERT INTO d_category_product VALUES (1,1,9);
INSERT INTO d_category_product VALUES (2,2,9);
INSERT INTO d_category_product VALUES (3,3,9);
INSERT INTO d_category_product VALUES (4,4,9);
INSERT INTO d_category_product VALUES (5,5,9);
INSERT INTO d_category_product VALUES (6,6,9);
INSERT INTO d_category_product VALUES (7,7,9);
INSERT INTO d_category_product VALUES (8,8,9);
INSERT INTO d_category_product VALUES (9,9,9);
INSERT INTO d_category_product VALUES (10,10,9);
INSERT INTO d_category_product VALUES (11,11,10);
INSERT INTO d_category_product VALUES (12,12,10);
INSERT INTO d_category_product VALUES (13,13,10);
INSERT INTO d_category_product VALUES (14,14,10);
INSERT INTO d_category_product VALUES (15,15,10);
INSERT INTO d_category_product VALUES (16,16,10);
INSERT INTO d_category_product VALUES (17,17,10);
INSERT INTO d_category_product VALUES (18,18,10);
INSERT INTO d_category_product VALUES (19,19,10);
INSERT INTO d_category_product VALUES (20,20,10);
INSERT INTO d_category_product VALUES (21,21,10);
INSERT INTO d_category_product VALUES (22,22,10);
INSERT INTO d_category_product VALUES (23,23,10);
INSERT INTO d_category_product VALUES (24,24,10);

INSERT INTO d_category_product VALUES (25,1,2);
INSERT INTO d_category_product VALUES (26,2,2);
INSERT INTO d_category_product VALUES (27,3,2);
INSERT INTO d_category_product VALUES (28,4,2);
INSERT INTO d_category_product VALUES (29,5,2);
INSERT INTO d_category_product VALUES (30,6,2);
INSERT INTO d_category_product VALUES (31,7,2);
INSERT INTO d_category_product VALUES (32,8,2);
INSERT INTO d_category_product VALUES (33,9,2);
INSERT INTO d_category_product VALUES (34,10,2);
INSERT INTO d_category_product VALUES (35,11,2);
INSERT INTO d_category_product VALUES (36,12,2);
INSERT INTO d_category_product VALUES (37,13,2);
INSERT INTO d_category_product VALUES (38,14,2);
INSERT INTO d_category_product VALUES (39,15,2);
INSERT INTO d_category_product VALUES (40,16,2);
INSERT INTO d_category_product VALUES (41,17,2);
INSERT INTO d_category_product VALUES (42,18,2);
INSERT INTO d_category_product VALUES (43,19,2);
INSERT INTO d_category_product VALUES (44,20,2);
INSERT INTO d_category_product VALUES (45,21,2);
INSERT INTO d_category_product VALUES (46,22,2);
INSERT INTO d_category_product VALUES (47,23,2);
INSERT INTO d_category_product VALUES (48,24,2);

INSERT INTO d_category_product VALUES (49,1,1);
INSERT INTO d_category_product VALUES (50,2,1);
INSERT INTO d_category_product VALUES (51,3,1);
INSERT INTO d_category_product VALUES (52,4,1);
INSERT INTO d_category_product VALUES (53,5,1);
INSERT INTO d_category_product VALUES (54,6,1);
INSERT INTO d_category_product VALUES (55,7,1);
INSERT INTO d_category_product VALUES (56,8,1);
INSERT INTO d_category_product VALUES (57,9,1);
INSERT INTO d_category_product VALUES (58,10,1);
INSERT INTO d_category_product VALUES (59,11,1);
INSERT INTO d_category_product VALUES (60,12,1);
INSERT INTO d_category_product VALUES (61,13,1);
INSERT INTO d_category_product VALUES (62,14,1);
INSERT INTO d_category_product VALUES (63,15,1);
INSERT INTO d_category_product VALUES (64,16,1);
INSERT INTO d_category_product VALUES (65,17,1);
INSERT INTO d_category_product VALUES (66,18,1);
INSERT INTO d_category_product VALUES (67,19,1);
INSERT INTO d_category_product VALUES (68,20,1);
INSERT INTO d_category_product VALUES (69,21,1);
INSERT INTO d_category_product VALUES (70,22,1);
INSERT INTO d_category_product VALUES (71,23,1);
INSERT INTO d_category_product VALUES (72,24,1);





