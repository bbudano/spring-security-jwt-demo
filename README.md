# spring-security-jwt-demo

### Generate certs
```
cd src/main/resources
```

```
mkdir cert
```

```
cd cert
```


```
openssl genrsa -out keypair.pem 4096

openssl rsa -in keypair.pem -pubout -out public.pem

openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem
```

### Run app
```
./mvnw spring-boot:run
```

### Users
App has two in-memory users:
```
role: ROLE_ADMIN
username: admin
password: admin
------------------------
role: ROLE_USER
username: user
password: user
```

### Login
```
curl -d "{\"username\":\"admin\", \"password\":\"admin\"}" -H "Content-Type: application/json" -X POST http://localhost:8080/api/v1/auth/token
```

This will return a JWT. Add it to the Authorization header to access protected resources:

```
curl -H "Authorization: Bearer <YOUR_JWT>" http://localhost:8080/hello
```

You should see this response:

```
Hello, admin
```
