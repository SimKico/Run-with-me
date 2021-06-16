insert into "runner_data" ( years, height, weight, gender, distance, planner_taken, physical_fitness, injury_category)
values ( 10, 170, 64, 1, 0, false, 1, 0);

insert into "users" ( name, surname, email, verified,username, password,user_role,training_plan,runner_data)
 values ( 'Petar','Petrovic', 'admin@gmail.com',true,'admin', '$2a$04$SwzgBrIJZhfnzOw7KFcdzOTiY6EFVwIpG7fkF/D1w26G1.fWsi.aK' ,'ROLE_ADMIN',null,null);

insert into "users" (name, surname, email, verified,username, password,user_role,training_plan,runner_data)
 values ('Snjezana','Simic', 's.snjezana@gmail.com',true,'user1', '$2a$04$SwzgBrIJZhfnzOw7KFcdzOTiY6EFVwIpG7fkF/D1w26G1.fWsi.aK' ,'ROLE_RUNNER',null, null);


insert into cooper_table (gender, age_min, age_max, very_bad, bad, average, good)
                values(0, 20, 30, 1600, 2200, 2400, 2800);
insert into cooper_table (gender, age_min, age_max, very_bad, bad, average, good)
                values(0, 30, 40, 1500, 1900, 2300, 2700);
insert into cooper_table (gender, age_min, age_max, very_bad, bad, average, good)
                values(0, 40, 50, 1400, 1700, 2100, 2500);
insert into cooper_table (gender, age_min, age_max, very_bad, bad, average, good)
                values(0, 50, 110, 1300, 1600, 2000, 2400);


insert into cooper_table (gender, age_min, age_max, very_bad, bad, average, good)
                values(1, 20, 30, 1500, 1800, 2200, 2700);
insert into cooper_table (gender, age_min, age_max, very_bad, bad, average, good)
                values(1, 30, 40, 1400, 1700, 2000, 2500);
insert into cooper_table (gender, age_min, age_max, very_bad, bad, average, good)
                values(1, 40, 50, 1200, 1500, 1900, 2300);
insert into cooper_table (gender, age_min, age_max, very_bad, bad, average, good)
                values(1, 50, 110, 1100, 1400, 1700, 2200);




