insert into injury (date_of_injury, injury_type, injury_category) values ('2020-01-01', 2, 2);

insert into "runner_data" ( years, height, weight, gender, distance, planner_taken, physical_fitness)
values ( 10, 170, 64, 1, 0, false, 1);

insert into "users" ( name, surname, email, verified,username, password,user_role,training_plan,runner_data)
 values ( 'Petar','Petrovic', 'admin@gmail.com',true,'admin', '$2a$10$RVzuprKddsjdq6P8QWmqF.sCj2uYPIUlbFVB.b7tJ9RdFNOOBNoXO' ,'ROLE_ADMIN',null,null);

insert into "users" (name, surname, email, verified,username, password,user_role,training_plan,runner_data)
 values ('Snjezana','Simic', 's.snjezana@gmail.com',true,'user1', '$2a$10$RVzuprKddsjdq6P8QWmqF.sCj2uYPIUlbFVB.b7tJ9RdFNOOBNoXO' ,'ROLE_RUNNER',null, null);

insert into cooper_table (gender, age_min, age_max, very_bad, bad, average, good)
                values(1, 20, 29, 1500, 1800, 2200, 2700)


