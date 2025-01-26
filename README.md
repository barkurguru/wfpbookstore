# wfpbookstore
Bookstore Springboot backend API with JWT authentication

1)Checkout main branch of wfpbookstore from here and configure to any IDE workspace.

2)from the project folder execute command
  a)mvn clean install   --> to build project
  b)mvn spring-boot:run  -->to run the project on 8080 port no.
  
3)Once successfully run, you can able to open  swagger, link: http://localhost:8080/swagger-ui/index.html

![image](https://github.com/user-attachments/assets/58d258c6-8f5f-4555-997b-f60cca4c1b1c)


OR
also  you can make postman to create resources

4)There are 3 Roles :user, moderator, admin. To create bookstore need to pass ADMIN role while admin user creation using this end point:http://localhost:8080/api/auth/signup.

  ![user_registration](https://github.com/user-attachments/assets/d0dcdd2a-22ee-4776-8659-4f9ae321dae6)
  ![Swagger_integration](https://github.com/user-attachments/assets/3c9f25bc-2120-43e5-9a7b-94fe104a8280)


5)Once user created, generate JWT token using this end point http://localhost:8080/api/auth/signin

![user_login_token_genration](https://github.com/user-attachments/assets/e884e4a5-b631-41f1-85eb-6161483b991b)

6)Now ready to create new books using end point : http://localhost:8080/api/books/create  JWT token to be passed to headers, while creating

![Create Books](https://github.com/user-attachments/assets/05cbe2d6-e56c-4b96-946a-7cce02bbea18)

7)We can checking books, by using get end point ( JWT token to be passed to headers)

a)To get all books http://localhost:8080/api/books
b)to get only 1 book using http://localhost:8080/api/books/1

![List All Books](https://github.com/user-attachments/assets/265765d3-e62b-4772-aee3-86b23134375b)

8)Update or Delete books similary ( JWT token to be passed to headers)

a)http://localhost:8080/api/books/update/1
b)http://localhost:8080/api/books/delete/1
![Books_updation](https://github.com/user-attachments/assets/da5780df-f4fd-4302-b458-33fa4167b262)
![Delete book by id](https://github.com/user-attachments/assets/c3a43901-6e4b-478d-bbb1-d2a36c21dfee)


Some of the use cases validation

a)User already exists, 
![User_registration_User_already_exists_wont_consider](https://github.com/user-attachments/assets/59a23e1b-4fef-4b4f-bab0-a2289048998a)

b)Emailid already exists
![User_registration_Email_already_exists_wont_consider](https://github.com/user-attachments/assets/aff0e41f-5495-46dc-9726-bfaa39f51de9)

c)Books creation without user id or proper access priviledges present 
![Books_creation_without_registration_401](https://github.com/user-attachments/assets/46a37242-612c-4324-b311-98f570529b12)

H2 DB

a)h2 console 
![h2_console](https://github.com/user-attachments/assets/1500cb31-67b4-4401-82a8-273792a4c8bb)

b)Only predefined roles must be present in the input role column, unless which won't be able to create data
![Only_Predefined_roles_entertained_in_schema](https://github.com/user-attachments/assets/c56521c8-c9f7-4b2f-9c77-81d2e54409a1)

Monitoring

a)Prometheus
![Promethues_integration](https://github.com/user-attachments/assets/2e38cd08-2d85-45ce-a813-9cebcd197530)

b)Actuator


![image](https://github.com/user-attachments/assets/683dd0f5-731a-427c-898f-6122ce47eb3c)









