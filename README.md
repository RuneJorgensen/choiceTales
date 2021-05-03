## Set up needed for running
- Docker and docker-compose

### Get db up and running
- 'docker-compose up'
  #### Deleting data from the db
  - stopping the docker 'docker stop <container id>'
  - removing the container 'docker rm <container id>'
  - removing locally stored data (make sure you're in the applications root directory) 'sudo rm -r mongodb_data'
  #### Connecting to the db by terminal
  - When you have the container up and running (to check write 'docker ps' in your terminal) you can get into the db by typing 'mongo'. 
    'show dbs' to show your databases. 
    'use <nameofdb>' to use a specific db. 
    'show collections' to show your collections "tables" in the db
    'db.section.find()' to show all data in the section collection
### Get the application up and running
- ./gradlew run


### Troubleshooting
-

## Micronaut 2.4.2 Documentation

- [User Guide](https://docs.micronaut.io/2.4.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.4.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.4.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

