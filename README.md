Dining Review API
=================

Portfolio Project of the Codecademy course "Create REST APIs with Spring and Java Skill Path".
The goal was to create a RESTful web API with Spring.

### Description:
The scenario revolves around the following basic concepts:
+ Users
+ Restaurants
+ Reviews
+ Admin

A restaurant has a set of review scores based on those submitted by users. Each restaurant has individual scores (scale from 1 to 5) for the following food allergies:
Peanut, egg and dairy. A restaurant also has an overall score, based on the scores of the three categories.
A user can create reviews on existing restaurants, an admin can then reject or accept a pending review.

#### Project Link:
[Dining Review API Project on Codecademy.com](https://www.codecademy.com/paths/create-rest-apis-with-spring-and-java/tracks/spring-apis-portfolio-project/modules/spring-dining-review-api/kanban_projects/dining-review-api)

### Technologys used:
+ Spring Initializr
+ H2 Database
+ Project Lombok

### Potential Improvements:
+ Implement server-side input validation.
+ Add a basic .html-file to test actions concerning the administrator (can only be tested via curl at the moment).
+ Implement authorization for users and authentification for users and admins.
