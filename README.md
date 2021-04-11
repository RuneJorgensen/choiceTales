## Set up needed for running
- Docker and docker-compose
- Postgres
# Get db up and running
- create a database.env in the root folder, with POSTGRES_USER, POSTGRES_PASSWORD and POSTGRES_DB
- get the db up and running by docker-compose run

# Get the application up and running
- ./gradlesw run


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

