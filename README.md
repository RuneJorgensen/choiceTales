## Set up needed for running
- Docker and docker-compose
- Postgres
### Get db up and running
-
  #### Deleting data from the db
  - The data is persisted in the data folder (as of now). You need to delete this folder to delete your data. Close the application and the db. Do a 'sudo rm -r data'
  #### Connecting to the db by terminal
  - When you have the container up and running (to check write 'docker ps' in your terminal) you can get into the db by typing 'mongo'. 
    'show dbs' to show your databases. 
    'use nameofdb' to use a specific db. 
    'show collections' to show your "tables" in the db
    'db.section.find()' to show all data in the section collection
### Get the application up and running
- ./gradlesw run


### Troubleshooting
- The application can't connect to the db? The connection to the db happens at application startup. If you've started up the db after the application, the application won't have a connection. Solution: Restart the application.

## Connecting to the db by terminal
psql -h localhost -p 5432 -U <USER_NAME> <DB_NAME>

## Micronaut 2.4.2 Documentation

- [User Guide](https://docs.micronaut.io/2.4.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.4.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.4.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

