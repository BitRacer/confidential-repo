The User Service
=
API Description
-
The user service is a microservice that provides information about users

The APIs
-
> ## /me GET
> /user/me provides information on the currently logged in user
> example usage: curl -X GET http://userservice.classified.cfapps.io/me | jq .
> ## /user GET
> /user will retreive a user by their id
> curl -X GET http://userservice.classified.cfapps.io/user?id=1 | jq .
> ## /user POST
> /user will create a user
> example usage:  curl -i -X POST -H "Content-Type: application/json" -d '{"id":"1","displayName":null,"firstName":"firstName","lastName":"lastName","email":null,"picture":null,"authToken":null,"authService":"GOOGLE_PLUS"}'  http://userservice.classified.cfapps.io/user
> ## /users GET
> /users GET returns a list of users
> example usage: curl -i -X GET  http://userservice.classified.cfapps.io/users
> ## /user/stats GET
> /user/stats GET returns a uses stats
> example usage: curl -i -X GET  http://userservice.classified.cfapps.io/user/stats?id=1



