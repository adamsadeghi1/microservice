## Installation
To start this service you need to have docker installed then start the postgres container using this command:

```
docker run --name postgres-container -e POSTGRES_PASSWORD=1234  -p 5432:5432 -d postgres:14.1
```

To connect to postgres use following command in terminal then enter password which is ```1234```:
```
psql -h localhost -U postgres -d postgres -p 5432
```

Postgres is running, by using previous command you are connecting it using terminal, so we need to run this query to
initialize the data required

```
CREATE TABLE movie (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    publishedDate DATE
);
    
insert into movie (name,author, publishedDate) values ('babylon','J.Dk1','1977-10-23');
insert into movie (name,author, publishedDate) values ('caniyon','J.Dk2','2004-03-08');
insert into movie (name,author, publishedDate) values ('dock','J.Dk3','1989-01-15'); 
```

At this stage we are ready to run the application star the app using start-app command while you are in project 
directory:
```
./start-app.sh
```

*You might need to require execute permission to ```start-app.sh``` file.
if that is the case run following command:
```
chmod +x start-app.sh
```