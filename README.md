# QuixOrder
Senior Project CECS491AB Restaurant Menu App

## Steps to start project
### PostgreSQL Database
1. Download PostgreSQL. Comes with pgAdmin 4. You will need to enter and save your admin password and port (default: 5432) to access it. <br/> 
    https://www.postgresql.org/download/
2. Start pgAdmin 4. This will start in your browser.
3. Navigate to Servers>PostgreSQL>Databases. Right click on Databases, and create new database **quixorder**.

### Open the project
1. Use your preferred IDE to open the maven file QuixOrder/demo/pom.xml
2. Navigate to demo/src/main/resources. Right click on resources, and create a new file **application.yml** <br/>
    **Note: {password} is a placeholder. Enter your own without the { }** <br/>
    **`application.yml`**
    ```yaml
    app:
      datasource:
        jdbc-url: jdbc:postgresql://localhost:5432/quixorder
        username: postgres
        password: {password}
        pool-size: 30
    ```
3. Start the application `DemoApplication.java`
4. The quixorder database in pgAdmin 4 should now be updated with tables defined in the sql files in resources/db/migration
