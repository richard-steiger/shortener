## URL Shortener Technical Notes
This repo contains the implementation of a URL Shortener website, whose specification is known to the intended audience so isn't repeated here.

This repo contains 2 projects:

    - **play-shortener** is an Intellij-hosted project comprising the website's implementation, written in Java
    
    - **chrome-shortener-test** is an eclipse-hosted project comprising a Selenium-based integration test harness 
        - access to the website is implemented via a local Chrome process controlled by the harness
        - the harness was used to bootstrap the application solution, but time didn't permit completing a full integration testing suite

The site is built on the Java variant of the very popular and well-known Playframework. Some the implementation's key features worth mentioning include:
- the key model abstraction is implemented by the **Alias** class, which simply pairs a full URL (the alias's *name*) with an integer index of the alias (it's *id*)
    - the 
- all user-facing methods are fully asynchronous, non-blocking, and thread-safe, thereby maximizing per JVM throughput;
- persistence is implemented via the JPA/Hibernate API accessing a database;
    - in this branch, the H2 in-memory database is configured, but can be trivially configured for any Hibernate-compatible engine;
    - as a result, all 
- very basic unit smoke tests are provided 
- 
