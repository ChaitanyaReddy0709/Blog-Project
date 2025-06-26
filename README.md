# Blog Management System
  A basic backend REST API for managing a blog platform built using SpringBoot , MySQL and JPA. 
  It supports users, posts, and comments with proper entity relationships.
  
# Tech Stack
  - Java 17
  - SpringBoot 3.x
  - Spring Data JPA
  - Maven
  - MySQL
  - Postman

# Project Structure
  src
  |-main
  | |-java/com/api/blog
  | |-controller
  | |-model
  | |-repository
  | |-service
  | |_BlogApplication.java
  | |_resources
  | |-applictaion.properties

# Setup Instructions
  Configure MySQL database
    Update src/main/resources/application.properties:
      spring.datasource.url=jdbc:mysql://localhost:3306/blog_cms
      spring.datasource.username=root
      spring.datasource.password=yourpassword
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
  #Note :Create the data base using this command-> (create database blog_cms ) .

# Application runs at:
  - http://localhost:8080

# Sample Requests and Responses
**1.Register a user**
    POST /api/register
      @Request
        {
          "name": "Ramesh",
          "email": "ramesh@gmail.com",
          "password": "123456"
        }
      
      @Response
        {
            "name": "Ramesh",
            "email": "ramesh@gmail.com",
            "password": "123456"
        }

  **2.Login**
      POST /api/login
      Note: If you give Correct Credentials it give Login Successfully otherwise it give Invalid Credentials.
        @Request 
          {
            "email": "ramesh@gmail.com",
            "password": "123456"
          }
          
        @Response 
          Login Successfully !

  **3.Create Post**
      POST /api/posts?userId=1
        @Request
          {
            "title": "My First Project",
            "content": "Welcome to the my blog system!",
            "tags": "we use SpringBoot , Java"
          }
          
        @Response
          {
              "postId": 1,
              "userModel": {
                  "name": "Ramesh",
                  "email": "ramesh@gmail.com",
                  "password": "123456"
              },
              "title": "My First Project",
              "content": "Welcome to the my blog system!",
              "tags": "we use SpringBoot , Java",
              "status": "Draft",
              "createdAt": "2025-06-26T07:30:19.0951876",
              "updatedAt": null
          }

  **4.Update Post**
      PUT /api/posts/1
        @Request
          {
            "title": "Updated Blog Title",
            "content": "Updated Content",
            "status": "Published"
          }
      
          @Response
            {
                "postId": 1,
                "userModel": {
                    "name": "Ramesh",
                    "email": "ramesh@gmail.com",
                    "password": "123456"
                },
                "title": "Updated Blog Title",
                "content": "Updated Content",
                "tags": "we use SpringBoot , Java",
                "status": "Published",
                "createdAt": "2025-06-26T07:30:19.095188",
                "updatedAt": "2025-06-26T07:33:46.859947"
            }

  **5.Get All Published Posts**
      GET /api/posts
        @Response
           {
                "postId": 1,
                "userModel": {
                    "name": "Ramesh",
                    "email": "ramesh@gmail.com",
                    "password": "123456"
                },
                "title": "Updated Blog Title",
                "content": "Updated Content",
                "tags": "we use SpringBoot , Java",
                "status": "Published",
                "createdAt": "2025-06-26T07:30:19.095188",
                "updatedAt": "2025-06-26T07:33:46.859947"
            }

  **6.Add Comment**
      POST /api/posts/1/comments?userId=1
        @Request 
          {
              "text": "Great Post !"
          }
  
        @Response      
          {
            "commentId": 1,
            "postModel": {
                "postId": 1,
                "userModel": {
                    "name": "Ramesh",
                    "email": "ramesh@gmail.com",
                    "password": "123456"
                },
                "title": "Updated Blog Title",
                "content": "Updated Content",
                "tags": "we use SpringBoot , Java",
                "status": "Published",
                "createdAt": "2025-06-26T07:30:19.095188",
                "updatedAt": "2025-06-26T07:33:46.859947"
            },
            "userModel": {
                "name": "Ramesh",
                "email": "ramesh@gmail.com",
                "password": "123456"
            },
            "text": "Great Post !",
            "createdAt": "2025-06-26T11:13:28.6981552"
        }
        
**7.Get Post with Comments**
    GET /api/posts/1
      @Response
      {
          "comments": [
              {
                  "commentId": 1,
                  "postModel": {
                      "postId": 1,
                      "userModel": {
                          "name": "Ramesh",
                          "email": "ramesh@gmail.com",
                          "password": "123456"
                      },
                      "title": "Updated Blog Title",
                      "content": "Updated Content",
                      "tags": "we use SpringBoot , Java",
                      "status": "Published",
                      "createdAt": "2025-06-26T07:30:19.095188",
                      "updatedAt": "2025-06-26T07:33:46.859947"
                  },
                  "userModel": {
                      "name": "Ramesh",
                      "email": "ramesh@gmail.com",
                      "password": "123456"
                  },
                  "text": "Great Post!",
                  "createdAt": "2025-06-26T10:07:55.27941"
              }
