# wordbooks-extension-backend

## Before Running
- copy application.properties.example and rename to application.properties
    - input db configuration

- copy credentials.json.example and rename to credentials.json
    - put credentials.json from google translate api (from https://cloud.google.com/translate/docs/setup)

## Run
```sh
(at wordbooks-extension-backend/ )
$ export GOOGLE_APPLICATION_CREDENTIALS="./credentials.json" && ./mvnw spring-boot:run
```