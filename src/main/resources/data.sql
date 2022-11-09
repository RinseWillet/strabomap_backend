delete from ancref;
delete from modref;
delete from settlement;

insert into settlement (pleiades_id, ancient_name, modern_name, geom) values (999, 'test', 'test', 'SRID=4326; POINT(52.06 4.288)');
insert into ancref (type_work, author, title, reference) values ('EPIGRAPHY', 'test_auth', 'test_titl', 'test_XI.I');
