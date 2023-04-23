insert into participant values(100,'Viktor');
insert into participant values(101,'Gareth');
insert into participant values(102,'Mike');
----insert into participant values(200,'part2');
--
insert into retrospective(retro_id,name,create_date,summary) values(100,'Retrospective 1', '2022-07-27','Post release retrospective');
----insert into retrospective(retro_id,name,create_date,summary) values(200,'Retro200', '2022-12-31','retro2summ');
--
----insert into retrospective_part(id, retro_id, part_id) values(100, 100, 100);
----insert into retrospective_part(id, retro_id, part_id) values(101, 100, 101);
----insert into retrospective_part(id, retro_id, part_id) values(102, 100, 102);
----insert into retrospective_part(id, retro_id, part_id) values(103, 100, 200);
insert into retrospective_part(retro_id, part_id) values(100, 100);
insert into retrospective_part(retro_id, part_id) values(100, 101);
insert into retrospective_part(retro_id, part_id) values(100, 102);
--
insert into feedback(feed_id, body, type, retro_id, part_id) values(100,'Sprint objective met','POSITIVE', 100, 101);
insert into feedback(feed_id, body, type, retro_id, part_id) values(101,'Too many items piled up in the awaiting QA','NEGATIVE',100, 100);
insert into feedback(feed_id, body, type, retro_id, part_id) values(102,'We should be looking to start using VS2015','IDEA',100, 102);
----insert into feedback(feed_id, body, type, retro_id, part_id) values(200,'feed1body','Positive',200, 200);