create table if not exists Users(
    id serial primary key,
    user_name varchar(100) not null,
    email varchar(40) not null unique,
--     first_name varchar(30) not null,
--     last_name varchar(30) not null,
    password char(40) not null,
    zip_code int not null;
);

create table if not exists Users_Preferences (
    id serial primary key,
    name varchar(10) not null unique
);

create table if not exists Trips (
  id serial primary key,
  restaurant_name varchar(100) not null unique,
  longitude real not null,
  lattitude real not null,
  trip_rating real not null;
);
