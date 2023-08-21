CREATE DATABASE "ridechaser-control";

CREATE TABLE TB_RIDECHASER_SPOT(
    "id" uuid not null primary key,
    ridechaserSpotNumber int not null,
    identifier varchar(10) not null,
    ridechaserModel varchar(70) not null,
	color varchar(70) not null,
	registrationDate timestamp not null,
	responsibleName varchar(130) not null,
	sector varchar(30) not null,
	"authorization" varchar(200) not null
);