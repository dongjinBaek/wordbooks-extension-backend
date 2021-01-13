# wordbooks-extension-backend

## Before Running
- copy application.properties.example and rename to application.properties
    - input db configuration

- copy credentials.json.example and rename to credentials.json
    - put credentials.json from google translate api (from https://cloud.google.com/translate/docs/setup)

## Run
```sh
(at wordbooks-extension-backend/ )
$ ./mvnw package
$ docker build -t id/name .
$ docker run -p 8080:8080 id/name
```