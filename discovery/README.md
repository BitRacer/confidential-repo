Eureka
=
Deployment
-
> ## Cloud Foundry
> cf push
cf cups eureka
cf bs eureka eureka1
cf restage eureka1
cf bs eureka eureka2
cf restage eureka2
> ## docker
> docker deployment info