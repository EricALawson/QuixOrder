# QuixOrder
Senior Project CECS491AB Restaurant Menu App

## Steps to start project
### PostgreSQL Database
1. The postgresql database is now hosted on Azure as quixorder-postgres-server. It should not require any additional set-up or configuration at this time.

### Azure CLI
1. Install azure CLI as described here: https://docs.microsoft.com/en-us/cli/azure/install-azure-cli?view=azure-cli-latest

### Maven
1. Ensure Maven is installed and accesible from your terminal with mvn --version
2. If it is not available install it from here: http://maven.apache.org/download.cgi

### Open the project
1. Use your preferred IDE to open the maven file QuixOrder/demo/pom.xml
2. Navigate to demo/src/main/resources. Right click on resources, and create a new file **application.yml** <br/>
    **Note: {password} is a placeholder. Enter your own without the { }** <br/>
    **`application.yml`**
    ```yaml
    app:
      datasource:
        jdbc-url: jdbc:postgresql://quixorder-postgres-server.postgres.database.azure.com:5432/quixorder?ssl=true&sslmode=require
        username: quixorder_admin@quixorder-postgres-server
        password: {password}
        pool-size: 30
    ```
3. This step is the same as before though the connection url and username are changed. Use the password for quixorder_admin provided in Discord.

###Deploy the project
1. Open a terminal in the /demo directory.
2. enter: mvn package to build the webapp.
4. enter: az login to login to azure cli.
5. enter: mvn azure-webapp:deploy to deploy the build.