# JMS Receiver

Make sure below file structure is set


File structure: 

```
projektarbete_komplex_java
    - \ Projektarbete # This is the sender / base app
    - \ Projektarbete-receiver
    docker-compose.yml
```

- Stand in root (projektarbete)
- Type `docker-compose up`
  - This will build and launch both docker images for 'Projektarbete' (sender) and 'Projektarbete-receiver'
  - REST API and server will be available at port **8081**
  - Note: 
    - Artemis in docker-compose is for arm64 / Mac M1 processor, see comment for intel version in docker-compose file