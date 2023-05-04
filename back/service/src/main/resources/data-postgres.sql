insert into roles (name) values ('ROLE_DOCTOR');
insert into roles (name) values ('ROLE_PATIENT');

-- password is 123 for all users

insert into doctors
    (email, first_name, last_name, password, phone_number, address, age, role_id)
values
    ('lekar0@gmail.com', 'Leka', 'Lekic', '$2a$10$GWugnfZGCvK0X3W4NYXE5OYyfNvSaEvhlpK8zrdF0WVd3nvtLZfuG', '+381634567811', 'Banijsa 32, Novi Sad, Vojvodina', 40, 1);

insert into patients
    (email, first_name, last_name, password, phone_number, address, age, role_id)
values
    ('rajkozgrc4@gmail.com', 'Rajko', 'Zagorac', '$2a$10$GWugnfZGCvK0X3W4NYXE5OYyfNvSaEvhlpK8zrdF0WVd3nvtLZfuG', '+381634567811', 'Josicki put BB, Sombor', 22, 2),
    ('nevenaaa@gmail.com', 'Nevena', 'Prokic', '$2a$10$GWugnfZGCvK0X3W4NYXE5OYyfNvSaEvhlpK8zrdF0WVd3nvtLZfuG', '+381634567811', 'Kosovska 30, Pozarevac', 22, 2),
    ('mika@gmail.com', 'Mika', 'Mikic', '$2a$10$GWugnfZGCvK0X3W4NYXE5OYyfNvSaEvhlpK8zrdF0WVd3nvtLZfuG', '+381634567811', 'Bulevar Evrope 14, Novi Sad', 6, 2),
    ('john@gmail.com', 'John', 'Johanson', '$2a$10$GWugnfZGCvK0X3W4NYXE5OYyfNvSaEvhlpK8zrdF0WVd3nvtLZfuG', '+381634567811', 'Trg Nikole Pasica 3, Beograd', 15, 2);

insert into medicine_descriptions(disease_type, middle_illness, mild_illness, name, severe_illness)
values
    ('ADHD',true,false,'Methylphenidate-Ritalin',true),
    ('ADHD',true,false,'Amphetamine-Adderall',true),
    ('ADHD',true,true,'Atomoxetine-Strattera',true),
    ('ADHD',true,false,'Guanfacine-Intuniv',true),
    ('ADHD',true,true,'Clonidine-Kapvay',true),
    ('ALZHEIMER',true,true,'Donepezil-Aricept',false),
    ('ALZHEIMER',true,false,'Memantine-Namenda',true),
    ('ALZHEIMER',true,true,'Rivastigmine-Exelon',false),
    ('ALZHEIMER',true,true,'Galantamine-Razadyne',false),
    ('ALZHEIMER',true,false,'Combination therapy-Namzaric',true),
    ('INSOMNIA',true,true,'Zolpidem-Ambien',false),
    ('INSOMNIA',true,true,'Eszopiclone-Lunesta',false),
    ('INSOMNIA',true,true,'Zaleplon-Sonata',false),
    ('INSOMNIA',false,false,'Ramelteon-Rozerem',true),
    ('INSOMNIA',true,true,'Trazodone-Desyrel',false),
    ('EPILEPSY',true,true,'Levetiracetam-Keppra',true),
    ('EPILEPSY',true,true,'Lamotrigine-Lamictal',true),
    ('EPILEPSY',true,true,'Carbamazepine-Tegretol',true),
    ('EPILEPSY',true,true,'Valproic acid-Depakote',true),
    ('EPILEPSY',true,true,'Topiramate-Topamax',true);

insert into medicine_ingredients(name, medicine_description_id)
values
('Methylphenidate hydrochloride', 1),
('Dextroamphetamine saccharate', 2),
('Amphetamine aspartate', 2),
('Dextroamphetamine sulfate', 2),
('Amphetamine sulfate', 2),
('Atomoxetine hydrochloride', 3),
('Guanfacine hydrochloride', 4),
('Clonidine hydrochloride', 5),
('Zolpidem tartrate', 6),
('Eszopiclone', 7),
('Zaleplon', 8),
('Ramelteon', 9),
('Trazodone hydrochloride', 10),
('Donepezil hydrochloride', 11),
('Memantine hydrochloride', 12),
('Rivastigmine tartrate', 13),
('Galantamine hydrobromide', 14),
('Donepezil hydrochloride', 15),
('Memantine hydrochloride', 15),
('Levetiracetam', 16),
('Lamotrigine', 17),
('Carbamazepine', 18),
('Divalproex sodium', 19),
('Topiramate', 20);


insert into medicine_description_allowed_ages(medicine_description_id, allowed_ages)
values
    (1,'CHILD'),
    (1,'ADOLESCENT'),
    (1,'ADULT'),

    (2,'CHILD'),
    (2,'ADOLESCENT'),
    (2,'ADULT'),

    (3,'CHILD'),
    (3,'ADOLESCENT'),
    (3,'ADULT'),

    (4,'CHILD'),
    (4,'ADOLESCENT'),

    (5,'CHILD'),
    (5,'ADOLESCENT'),

    (6,'CHILD'),
    (6,'ADOLESCENT'),
    (6,'ADULT'),

    (7,'CHILD'),
    (7,'ADOLESCENT'),
    (7,'ADULT'),

    (8,'CHILD'),
    (8,'ADOLESCENT'),
    (8,'ADULT'),

    (9,'CHILD'),
    (9,'ADOLESCENT'),
    (9,'ADULT'),

    (10,'CHILD'),
    (10,'ADOLESCENT'),
    (10,'ADULT'),

    (11,'ADOLESCENT'),
    (11,'ADULT'),

    (12,'ADOLESCENT'),
    (12,'ADULT'),

    (13,'ADOLESCENT'),
    (13,'ADULT'),

    (14,'ADOLESCENT'),
    (14,'ADULT'),

    (15,'ADOLESCENT'),
    (15,'ADULT'),

    (16,'CHILD'),
    (16,'ADOLESCENT'),
    (16,'ADULT'),

    (17,'CHILD'),
    (17,'ADOLESCENT'),
    (17,'ADULT'),

    (18,'CHILD'),
    (18,'ADOLESCENT'),
    (18,'ADULT'),

    (19,'CHILD'),
    (19,'ADOLESCENT'),
    (19,'ADULT'),

    (20,'CHILD'),
    (20,'ADOLESCENT'),
    (20,'ADULT');
