# JMS Receiver

Make sure below file structure is set. 
Docker-compose file needs to be moved one folder below and "Projektarbete" should be renamed.


File structure: 

```
projektarbete_komplex_java
 --\ projektarbete-sender # This is the base app, clone and rename it
 --\ projektarbete-receiver
 docker-compose.yml
```

- Create a new folder named 'projektarbete_komplex_java' (root)
- Copy `docker-compose.yml` to root
- Type `docker-compose up` when standing in root
  - This will build and launch both docker images for 'Projektarbete' (sender) and 'projektarbete-receiver'
  - REST API and server will be available at port **8081**
  - Note: 
    - Check out branch `jms-x64-receiver` if you don't have an arm-processor