The Confidential Platform
=
Platform Description
-
The Confidential Platform consists of several micro services.  Each service serves a specific purpose and should conform to 12 factors.  The platform is based on spring-cloud and netflix-oss.  Core services are required to be bootstrapped first at which point any additional service should be disposable, resilient, etc. 

The services
-
> ## config-server
> The config server provides all application configuration information for the platform.  As such it is required to be the very first service started.
> ## eureka
> Eureka is the discovery service for the platform.  It will pull its own config from the configuration service, and from there it will provide registation and discovery services to all components of the platform.
> ## zuul
> Zuul is the gatekeeper.  Zuul is provides a gateway to the services contained in the platform.  It will leverage the auth-service to validate auth tokens oauth2 style
> ## hystrix 
> Hystrix is the reverse proxy that will handle load balancing and circuit-breakers for all services.
> ## auth-server
> auth-server handles validation of all users and auth-tokens.  This is the single point for integration with oauth providers such as google+ and facebook
> ## location-service
> location-service is the microservice that handles all location based requests.  For api documentation see the location-service module
> ## user-service
> user-service is the microservice that handles all location based requests.  For api documentation see the user-service module

The configuration
-
> The configuration itself is managed in git.  The repo for this is currently at https://github.com/BitRacer/confidential-config.git.