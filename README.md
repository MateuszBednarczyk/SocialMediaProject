# BitSpace Project
Bitspace project is the project of simply social networking platform.

You can use it only as a backend, or use our frontend which is actually not finished, and probably won't be, that's why we highly recommend, use custom frontend.

## Backend: Mateusz Bednarczyk
### Made with
* Spring Boot: 2.6.6
* Java: 17
* Java jwt: 3.19.1
* Spring Boot mail: 2.6.7
* Lombok
* PostgreSQL / MySQL

# Whats important?
Project was basically working at MySQL, but after some time, 
we've decided to move to postgreSQL.
So, if you want to use MySQL, just edit
<i><b>application.properties</i></b> correctly.

Profile photos, are stored as Google Drive links, so you can easily manage it.

# Run locally
```
/mvn clean package
java -jar SocialMediaProject-0.0.1.jar
```
# Run on docker
```
docker build -t socialmediaapp .
docker run -p 8080:8080 socialmediaapp
```

# Endpoints
```
  /api/basefunctionalities/finduserbyid/{id}:
    get:
      summary: "GET api/basefunctionalities/finduserbyid/{id}"
      operationId: "findUserByUsername"
      parameters:
      - name: "id"
        in: "path"
        required: true
        schema:
          type: "number"
          format: "int64"
      responses:
        "200":
          description: "OK"
```
```
  /api/basefunctionalities/finduserbyusername/{username}:
    get:
      summary: "GET api/basefunctionalities/finduserbyusername/{username}"
      operationId: "findUserByUsername"
      parameters:
      - name: "username"
        in: "path"
        required: true
        schema:
          type: "string"
      responses:
        "200":
          description: "OK"
```
```
  /api/basefunctionalities/followuser:
    post:
      summary: "POST api/basefunctionalities/followuser"
      operationId: "followUser"
      responses:
        "200":
          description: "OK"
```
```
  /api/basefunctionalities/getfollowedappusersposts:
    post:
      summary: "POST api/basefunctionalities/getfollowedappusersposts"
      operationId: "getFollowedAppUsersPosts"
      parameters:
      - name: "requestingAppUserUsername"
        in: "query"
        required: true
        schema:
          type: "string"
      responses:
        "200":
          description: "OK"
```
```
  /api/basefunctionalities/unfollowuser:
    delete:
      summary: "DELETE api/basefunctionalities/unfollowuser"
      operationId: "unfollowUser"
      responses:
        "200":
          description: "OK"
```
```
  /api/user/delete-user:
    delete:
      summary: "DELETE api/user/delete-user"
      operationId: "deleteAppUser"
      responses:
        "200":
          description: "OK"
```
```
  /api/user/login:
    post:
      summary: "POST api/user/login"
      operationId: "login"
      responses:
        "200":
          description: "OK"
```
```
  /api/user/register:
    post:
      summary: "POST api/user/register"
      operationId: "register"
      responses:
        "200":
          description: "OK"
```
```
  /api/user/send-verification-mail:
    post:
      summary: "POST api/user/send-verification-mail"
      operationId: "sendVerificationMail"
      responses:
        "200":
          description: "OK"
```
```
  /api/user/update-description:
    patch:
      summary: "PATCH api/user/update-description"
      operationId: "updateDescription"
      responses:
        "200":
          description: "OK"
```
```
  /api/user/update-image:
    patch:
      summary: "PATCH api/user/update-image"
      operationId: "updateImage"
      responses:
        "200":
          description: "OK"
```
```
  /api/user/update-password:
    patch:
      summary: "PATCH api/user/update-password"
      operationId: "updatePassword"
      responses:
        "200":
          description: "OK"
```
```
  /api/user/update-role:
    patch:
      summary: "PATCH api/user/update-role"
      operationId: "updateRole"
      responses:
        "200":
          description: "OK"
```
```
  /api/user/update-username:
    patch:
      summary: "PATCH api/user/update-username"
      operationId: "updateUsername"
      responses:
        "200":
          description: "OK"
```
```
  /api/user/verify:
    get:
      summary: "GET api/user/verify"
      operationId: "verifyAppUser"
      parameters:
      - name: "token"
        in: "query"
        required: true
        schema:
          type: "string"
      - name: "username"
        in: "query"
        required: true
        schema:
          type: "string"
      responses:
        "200":
          description: "OK"
```
```
  /api/contentfinding/post/{username}:
    get:
      summary: "GET api/contentfinding/post/{username}"
      operationId: "findAllPostsOfRequestedAppUser"
      parameters:
      - name: "username"
        in: "path"
        required: true
        schema:
          type: "string"
      responses:
        "200":
          description: "OK"
```
```
  /api/content/addnewpost:
    post:
      summary: "POST api/content/addnewpost"
      operationId: "addNewPost"
      responses:
        "200":
          description: "OK"
```
```
  /api/content/deletepost:
    delete:
      summary: "DELETE api/content/deletepost"
      operationId: "deletePostById"
      parameters:
      - name: "postId"
        in: "query"
        required: true
        schema:
          type: "number"
          format: "int64"
      responses:
        "200":
          description: "OK"
```
```
  /api/content/updatepostcontent:
    patch:
      summary: "PATCH api/content/updatepostcontent"
      operationId: "updatePostContent"
      responses:
        "200":
          description: "OK"
```
```
  /api/content/updateposttitle:
    patch:
      summary: "PATCH api/content/updateposttitle"
      operationId: "updatePostTitle"
      responses:
        "200":
          description: "OK"
```
```
  /api/content/comment/create-comment:
    post:
      summary: "POST api/content/comment/create-comment"
      operationId: "createComment"
      responses:
        "200":
          description: "OK"
```
#### Front-end: Jakub Cendrowski