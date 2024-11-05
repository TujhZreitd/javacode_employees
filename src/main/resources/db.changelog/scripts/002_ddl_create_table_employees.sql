create table employees(
    id serial primary key,
    first_name varchar not null,
    last_name varchar not null,
    position varchar not null,
    salary double precision not null,
    department_id int references departments(id) not null
)