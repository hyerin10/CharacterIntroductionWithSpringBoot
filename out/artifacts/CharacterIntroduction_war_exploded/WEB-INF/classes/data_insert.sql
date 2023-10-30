DELETE FROM memo;
ALTER TABLE memo AUTO_INCREMENT = 1;

DELETE FROM character_information;
ALTER TABLE character_information AUTO_INCREMENT = 1;

insert into memo(character_num, memo_title, memo_content) values(1, 'Background', 'kim의 성장 환경 메모 내용');
insert into memo(character_num, memo_title, memo_content) values(1, 'Characteristic', 'kim의 성격 메모 내용');
insert into memo(character_num, memo_title, memo_content) values(2, 'Background', 'lee의 성장 환경 메모 내용');

insert into character_information(name, gender, theme_color, character_image_url, eyes, skin, hair, clothing, etc) values('kim', 'male', 'blue', 'character_images/test.jpg', 'bk', 'bk', 'bk', 'hoodie', 'etc');
insert into character_information(name, gender, theme_color, character_image_url, eyes, skin, hair, clothing, etc) values('lee', 'male', 'green', 'character_images/test.jpg', 'bk', 'yellow', 'bk', 'hoodie', 'etc');
insert into character_information(name, gender, theme_color, character_image_url, eyes, skin, hair, clothing, etc) values('choi', 'female', 'red', 'character_images/test.jpg', 'brown', 'bk', 'bk', 'hoodie', 'etc');



