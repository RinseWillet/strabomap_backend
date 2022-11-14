delete from ancref;
delete from modref;
delete from settlement;
drop TYPE if exists type_work ;

create TYPE type_work as enum ('EPIGRAPHY', 'NUMISMATIC', 'TEXT', 'DEPICTION');
insert into settlement (pleiades_id, ancient_name, modern_name, geom) values (999, 'test', 'test', 'SRID=4326; POINT(52.06 4.288)');
insert into ancref (type_work, author, title, reference, settlement_id) values (1, 'test_auth', 'test_titl', 'test_XI.I', (SELECT id from settlement WHERE ancient_name='test'));