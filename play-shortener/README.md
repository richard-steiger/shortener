# URL Shortener Technical Notes
This repo contains the implementation of a URL Shortener website, whose specification is known to the intended audience so isn't repeated here.

## Projects
This repo contains 2 projects:

**play-shortener** is an Intellij-hosted project comprising the website's implementation, written in Java
    
**chrome-shortener-test** is an eclipse-hosted project comprising a Selenium-based integration test harness 
        - access to the website is implemented via a local Chrome process controlled by the harness

The site is built on the Java variant of the very popular and well-known Playframework 2.5.x release.

## Design Overview
Some the implementation's key features worth mentioning include:
- the key model abstraction is implemented by the **Alias** class, which simply pairs a full URL (the alias's *name*) with an integer index of the alias (it's *id*)
    - the 
- all user-facing methods are fully asynchronous, non-blocking, and thread-safe, thereby maximizing per JVM throughput;
- persistence is implemented via the JPA/Hibernate API accessing a database;
    - in this branch, the H2 in-memory database is configured, but can be trivially configured for any Hibernate-compatible engine;
    - as a result, all aliases are forgotten when the site is restarted (replacing H2 with, e.g. postgresql will obviously preserve aliases across restarts).
- very basic unit smoke tests are provided
- the test harness was used to bootstrap the application solution; while time didn't permit building it out into a full integration testing suite, doing so would be straightforward.

## Installation and Operation
This current version may only be run in *dev* mode, as follows:
1. clone this repo
2. in a 'nix shell, cd to the clone's root directory
3. incant **sbt run**
The site should be up after the startup dust settles.

To stop the site, in the same shell, simply enter ^C.

## Bugs and Status
The *dev* release works flawlessly.

I spent several hours attempting to package the site as a *stage* release, but ran into some nasty Playframework bugs:
1. When *stage* was run under Windows, the application complained that the **Alias** class wasn't mapped to the database. Since there are no code differences between dev and staging, this points to a bug in the deployment builder.
2. When *stage* was run under Cygwin, the site console and log remained empty, and all Chrome processes froze. Killing Chrome's process tree didn't clear the freeze, but required a Windows reboot.
3. When *stage* was run on OS/X, the site yielded the same complaint about **Alias** not being mapped.

## Additional Files
The entire code tree is available as a gist file, at <TBD>.
