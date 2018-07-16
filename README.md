# email-service
Apply_For_A_Job

spring-Email-Example

OBJECTIVE: When User aplly for a job, App will send email to user.

FOR RUN: You must do config in application.proferties file.(for Database, I used mongoDb)

1. Run App.
2. Run Postman.
3. You select type POST.
4. You enter address http://localhost:8080/applytojob.
5. You must enter post body.
  for example;
    {
        "userFirstName" : "Name",
        "userLastName" : "Surname",
        "userVatNum" : "1234567890",
        "userAge" : 20,
        "userEmail" : "email@hotmail.com",
        "userUniversity" : "İstanbul Üniversitesi",
        "userAddress" : "İstanbul"
    }
6. you click send button in Postman.
7. you check inbox for userEmail.
