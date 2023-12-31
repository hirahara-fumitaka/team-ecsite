SET foreign_key_checks=1;

USE sunflowerdb;

INSERT INTO mst_user
(user_name, password, family_name, first_name, family_name_kana, first_name_kana, gender)
VALUES ('yamada@gmail.com', '111111', '山田', '太郎', 'やまだ', 'たろう', 0);

INSERT INTO mst_category (category_name,category_description)VALUES
('パスタ', 'パスタのカテゴリーです'),
('ピザ', 'ピザのカテゴリーです'),
('サラダ', 'サラダのカテゴリーです'),
('デザート', 'デザートのカテゴリーです');

INSERT INTO mst_product(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company)VALUES
('トマトソースパスタ','とまとそーすぱすた','ツナの旨味とトマトの酸味が相性抜群で、ニンニクの香ばしさがアクセントになった一品！',1,1230,'/img/01_tomato_pasta.jpg','2023/04/01','ジラソーレ'),
('カルボナーラ','かるぼなーら','生クリームを使わず、卵黄とチーズとベーコンだけで作った本格派カルボナーラ！',1,999,'/img/02_carbonara.jpg','2023/04/01','ジラソーレ'),
('ペペロンチーノ','ぺぺろんちーの','青森県産直送ニンニクと栃木県産直送唐辛子を使用した新鮮パスタ！採れたてニンニクと唐辛子の香ばしさが楽しめる！',1,950,'/img/03_peperoncino.jpg','2023/05/15','ジラソーレ'),
('ボロネーゼ','ぼろねーぜ','本場イタリアの赤ワインでじっくり煮込んだ手作りソース！完熟トマトのほどよい酸味が癖になる！',1,1180,'/img/04_bolognese.jpg','2023/05/15','ジラソーレ'),
('マルゲリータ','まるげりーた','職人手のばし生地の窯焼きナポリピザ。ジューシーなトマト、香り豊かなバジルソースの組み合わせが最高！',2,2030,'/img/05_margherita.jpg','2023/04/01','ジラソーレ'),
('サラミピザ','さらみぴざ','凝縮した熟成サラミのうまみが味わえる！モッツァレラチーズのふわふわ感とサラミの歯ごたえが上手く溶け合い、食感も楽しい！',2,2680,'/img/06_salami_pizza.jpg','2023/04/01','ジラソーレ'),
('シーフードピザ','しーふーどぴざ','エビ、イカ、アサリなどをふんだんに使い、たっぷりのチーズと仕上げにマヨネーズをかけたボリューム満点の一品。',2,2880,'/img/07_seafood _pizza.jpg','2023/05/15','ジラソーレ'),
('クアトロフォルマッジ','くあとろふぉるまっじ','カマンベール、モッツァレラ、パルメザン、ブルー、個性の異なるチーズの絶妙なハーモニーを堪能できます。メープルソースをかけるとスイーツのような味わいに！',2,2780,'/img/08_quattro_formaggi.jpg','2023/05/15','ジラソーレ'),
('ポテトサラダ','ぽてとさらだ','北海道のジャガイモを使用したみんなが大好きな定番サラダ。ピザやパスタと一緒にどうぞ！',3,380,'/img/09_potatosalad.jpg','2023/04/01','ジラソーレ'),
('シーザーサラダ','しーざーさらだ','レタスのシャキシャキした食感がたまらない！野菜不足なあなたにお勧めの一品です！',3,420,'/img/10_caesarsalad.jpg','2023/04/01','ジラソーレ'),
('アボガドサラダ','あぼがどさらだ','新鮮なトマトとクリーミーなアボカドが絶妙に調和した、爽やかなサラダ！',3,550,'/img/11_avocado_salad.jpg','2023/05/15','ジラソーレ'),
('生ハムサラダ','なまはむさらだ','風味豊かな生ハムと新鮮な野菜を使用した、美味しさ満点のサラダ！当店特製のドレッシングと一緒にどうぞ！',3,650,'/img/12_hamsalad.jpg','2023/05/15','ジラソーレ'),
('ジェラート','じぇらーと','シャーベットのシャリっと感と、なめらかなアイスクリームのいいとこ取り！',4,410,'/img/13_gelato.jpg','2020/07/01','ジラソーレ'),
('ティラミス','てぃらみす','コーヒーシロップ・フィンガービスケット・カスタード風味のマスカルポーネクリームを層状に重ね、ほろ苦いコーヒーの香りとほどよい甘さのクリーム入った大人のデザートです！',4,550,'/img/14_tiramisu.jpg','2020/04/01','ジラソーレ'),
('パンナコッタ','ぱんなこった','濃厚でやさしいミルクの味わいが口いっぱいに広がる！さっぱりとしたフルーツソースとの相性も抜群！',4,480,'/img/15_pannacotta.jpg','2020/05/15','ジラソーレ'),
('パフェ','ぱふぇ','自分好みに飾り付けてあとはぱくりと食べるだけ！口の中に広がるあまーい味がたまりません！',4,680,'/img/16_parfait.jpg','2023/07/01','ジラソーレ');
