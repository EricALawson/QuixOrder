# QuixOrder
Senior Project CECS491AB Restaurant Menu App

## Steps to start server

### Database
This only needs to be done once.
1. Open cmd
2. Create docker container <br/>
    **Note: {username} and {password} are placeholders. Enter your own without the { }**
    ```
    docker run --name {username} -e POSTGRES_PASSWORD={password} -d -p 5432:5432 postgres:alpine
    ```
3. Create file application.yml under src/main/resources
    ```yaml
    app:
      datasource:
        jdbc-url: jdbc:postgresql://localhost:5432/quixorder
        username: <username>
        password: <password>
        pool-size: 30
    ```
4. Format container to be readable
    ```
    docker ps
    ```
    Result:
    ```
    CONTAINER ID        IMAGE               COMMAND                 ....
    149472d2157c        postgres:alpine     "docker-entrypoint.s…"  ....
    ```
5. Create database using `CONTAINER ID`
    ```
    docker exec -it 149472d2157c bin/bash
    psql -U postgres
    CREATE DATABASE quixorder;
    ```
6. Connect to quixorder database
    ```
    \c quixorder
    ```
7. Start Application
8. In cmd quixorder database
    ```
    \d tablename
    \dt
    ```
    Confirm that schema is correctly reflected.
9. Useful commands <br/>
   ```
   From postgres=#
    - View all database
        \l or \list
    - View a database
        \c databasename
    - Return to bash
        \q
    - Terminate all connections to a database
        SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE pid <> pg_backend_pid() AND datname = 'databasename';
   From database=#
    - View schema 
        \dt
    - View info about a table
        \d tablename
   ```