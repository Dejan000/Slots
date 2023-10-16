INSERT INTO `user` (id,balance,password, role,  username)
              VALUES (1,1000,'$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','ADMIN','miroslav');

              
INSERT INTO polje (id,red,kolona)
			 		VALUES(1,1,1);
INSERT INTO polje (id,red,kolona)
			 		VALUES(2,1,2);
INSERT INTO polje (id,red,kolona)
			 		VALUES(3,1,3);
INSERT INTO polje (id,red,kolona)
			 		VALUES(4,2,1);
INSERT INTO polje (id,red,kolona)
			 		VALUES(5,2,2);
INSERT INTO polje (id,red,kolona)
			 		VALUES(6,2,3);
INSERT INTO polje (id,red,kolona)
			 		VALUES(7,3,1);
INSERT INTO polje (id,red,kolona)
			 		VALUES(8,3,2);
INSERT INTO polje (id,red,kolona)
			 		VALUES(9,3,3);
			 		
--novi

INSERT INTO polje (id,red,kolona)
			 		VALUES(10,1,4);
INSERT INTO polje (id,red,kolona)
			 		VALUES(11,2,4);
INSERT INTO polje (id,red,kolona)
			 		VALUES(12,3,4);
			 		
INSERT INTO slot(id,kolone,redovi,isplata,ulog)
			VALUES(1,3,3,0,1);
INSERT INTO slot(id,kolone,redovi,isplata,ulog)
			VALUES(2,3,4,0,1);
			
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(1,1);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(1,2);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(1,3);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(1,4);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(1,5);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(1,6);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(1,7);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(1,8);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(1,9);
--novi
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(2,1);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(2,2);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(2,3);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(2,4);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(2,5);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(2,6);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(2,7);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(2,8);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(2,9);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(2,10);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(2,11);
INSERT INTO slot_polja(slot_id,polja_id)
									VALUES(2,12);
									
									
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(1,'A',100,1,2);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(2,'K',50,1,4);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(3,'Q',20,1,7);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(4,'J',10,1,8);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(5,'10',5,1,9);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(6,'9',5,1,10);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(7,'8',5,1,11);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(8,'7',5,1,12);
--novi
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(9,'100',100,2,2);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(10,'90',50,2,4);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(11,'80',20,2,7);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(12,'70',10,2,8);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(13,'60',5,2,9);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(14,'50',5,2,10);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(15,'40',5,2,11);
INSERT INTO znak(id,oznaka,vrednost,slot_id,verovatnoca)
				VALUES(16,'30',5,2,120);

INSERT INTO linija(id,broj_polja)
			VALUES(1,3);
INSERT INTO linija(id,broj_polja)
			VALUES(2,3);
INSERT INTO linija(id,broj_polja)
			VALUES(3,3);
INSERT INTO linija(id,broj_polja)
			VALUES(4,3);
INSERT INTO linija(id,broj_polja)
			VALUES(5,3);
			
INSERT INTO linija(id,broj_polja)
			VALUES(6,4);
INSERT INTO linija(id,broj_polja)
			VALUES(7,4);
INSERT INTO linija(id,broj_polja)
			VALUES(8,4);
INSERT INTO linija(id,broj_polja)
			VALUES(9,4);
INSERT INTO linija(id,broj_polja)
			VALUES(10,4);
			
			
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(1,1);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(1,2);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(1,3);
						
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(2,4);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(2,5);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(2,6);
						
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(3,7);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(3,8);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(3,9);
						
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(4,1);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(4,5);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(4,9);
						
--slot2						
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(6,1);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(6,2);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(6,3);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(6,10);
						
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(7,4);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(7,5);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(7,6);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(7,11);
						
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(8,7);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(8,8);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(8,9);
INSERT INTO linija_polja(linija_id,polja_id)
						VALUES(7,12);
						
						
						
						
INSERT INTO linija_slotovi_linije(linije_id,slotovi_linije_id)
						VALUES(1,1);
						
INSERT INTO linija_slotovi_linije(linije_id,slotovi_linije_id)
						VALUES(2,1);
						
INSERT INTO linija_slotovi_linije(linije_id,slotovi_linije_id)
						VALUES(3,1);
INSERT INTO linija_slotovi_linije(linije_id,slotovi_linije_id)
						VALUES(4,1);
						
						
--slot2
INSERT INTO linija_slotovi_linije(linije_id,slotovi_linije_id)
						VALUES(6,2);
INSERT INTO linija_slotovi_linije(linije_id,slotovi_linije_id)
						VALUES(7,2);
INSERT INTO linija_slotovi_linije(linije_id,slotovi_linije_id)
						VALUES(8,2);
									
									