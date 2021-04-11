## Set up needed for running
- Docker and docker-compose
- Postgres
### Get db up and running
- create a database.env in the root folder, with POSTGRES_USER, POSTGRES_PASSWORD and POSTGRES_DB
- get the db up and running by 'docker-compose run' (you can close it gracefully by 'docker-compose down' or by ctrl+c)
  #### Deleting data from the db
  - The data is persisted in the data folder (as of now). You need to delete this folder to delete your data. Close the application and the db. Do a 'sudo rm -r data'

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

