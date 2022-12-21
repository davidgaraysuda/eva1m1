create table if not exists event(
id serial primary key,
description varchar(50) not null,
start_date date not null,
end_date date not null,
city varchar(20),
total_attendees int
);

create table if not exists conference(
id serial primary key,
tittle varchar(50) not null,
speaker varchar(50) not null,
hours time not null,
total_attendees int,
event_id int not null,
foreign key (event_id) references event(id)
);

create table if not exists member_event(
id serial primary key,
code int unique,
registred_at date not null,
assisted boolean not null,
assistant_id int not null,
conference_id int not null,
foreign key (assistant_id) references assistant(id),
foreign key (conference_id) references conference(id)
);