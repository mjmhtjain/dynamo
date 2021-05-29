# Getting Started

### Helpful commands

- run the local dynamodb instance
```dockerfile
docker run -dp 8000:8000 amazon/dynamodb-local
```

- access the shell `http://localhost:8000/shell/` 

### Deploy to EC2

- Run this command, if necessary, to ensure your key is not publicly viewable
```shell
chmod 400 ./secrets/local.pem
```

- Copy files 
```shell 
scp -i "./secrets/local.pem" ./start-server.sh ec2-user@ec2-18-206-246-52.compute-1.amazonaws.com:/home/ec2-user
scp -i "./secrets/local.pem" ./target/dynamo-0.0.1-SNAPSHOT.jar ec2-user@ec2-18-206-246-52.compute-1.amazonaws.com:/home/ec2-user
```

- Connect to ec2
```shell
ssh -i ./secrets/local.pem ec2-user@ec2-18-206-246-52.compute-1.amazonaws.com
```

- running spring boot application with arguments
```shell
java -jar ./target/dynamo-0.0.1-SNAPSHOT.jar --server.port=8081 \
aws.dynamodb.endpoint=dynamodb.us-west-1.amazonaws.com \
aws.access-key=access \
aws.secret-key=secret
```

- docker command to run it locally
```shell
docker run -p 80:8080 --env-file ./.env dynamo
```