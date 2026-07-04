pipeline {
    agent any

     environment {
            DOCKER_IMAGE = "ekdvsampath/cicd-spring-boot-app:latest"
            DOCKER_CREDENTIALS_ID = "dockerhub-credentials"
            SSH_CREDENTIALS_ID = "learnfi-prod-server"
            SSH_TARGET = "ubuntu@35.171.221.218"
            DOCKER_CONTAINER = "spring-boot-app"
     }

    tools {
        maven 'Maven 3.9.7'
    }



    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                        url: 'https://github.com/Ekdvs/my-ci-cd-project-learnfi-project.git'
            }
        }


        // Build theapplicatin using Maven and pass the database credentials as environment

        stage('Build') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'learnfi-prod-database-credentials', usernameVariable: 'DB_USERNAME', passwordVariable: 'DB_PASSWORD')]) {
                        sh '''#!/bin/bash
                        echo "Building application with MySQL database"
                        export DB_USERNAME=$DB_USERNAME
                        export DB_PASSWORD=$DB_PASSWORD
                        mvn clean package
                        '''
                    }
                }
            }
        }

//update

        stage('Test') {
            steps {
                script {
                     withCredentials([usernamePassword(credentialsId: 'learnfi-prod-database-credentials', usernameVariable: 'DB_USERNAME', passwordVariable: 'DB_PASSWORD')]) {
                        sh '''#!/bin/bash
                        echo "Testing application with MySQL database"
                        export DB_USERNAME=$DB_USERNAME
                        export DB_PASSWORD=$DB_PASSWORD
                        mvn test -Dspring.profiles.active=test
                        '''
                    }
                }
            }
        }


        stage('Docker Build & Push') {
            steps {
                script {
                    withCredentials([usernamePassword(
                            credentialsId: 'dockerhub-credentials',
                            usernameVariable: 'DOCKER_USER',
                            passwordVariable: 'DOCKER_PASS'
                    )]) {
                        sh '''
                    echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin

                    docker build -t $DOCKER_IMAGE .

                    docker push $DOCKER_IMAGE

                    docker logout
                '''
                    }
                }
            }
        }


        stage('Deploy') {
            steps {
                script {

                    withCredentials([
                            usernamePassword(
                                    credentialsId: 'learnfi-prod-database-credentials',
                                    usernameVariable: 'DB_USERNAME',
                                    passwordVariable: 'DB_PASSWORD'
                            ),
                            usernamePassword(
                                    credentialsId: 'dockerhub-credentials',
                                    usernameVariable: 'DOCKER_USER',
                                    passwordVariable: 'DOCKER_PASS'
                            )
                    ]) {

                        sshagent(['learnfi-prod-server']) {

                            sh """
                        ssh -o StrictHostKeyChecking=no ubuntu@35.171.221.218 '
                            
                            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin

                            docker pull ekdvsampath/cicd-spring-boot-app:latest

                            docker stop spring-boot-app || true
                            docker rm spring-boot-app || true

                            docker run -d --name spring-boot-app -p 8080:8080 \
                                -e DB_USERNAME="$DB_USERNAME" \
                                -e DB_PASSWORD="$DB_PASSWORD" \
                                ekdvsampath/cicd-spring-boot-app:latest

                            docker logout
                        '
                    """
                        }
                    }
                }
            }
        }

    }


    post {
        always {
            cleanWs()
        }

        success {
            emailext (
                            to: 'ekdvsampath02@gmail.com',
                            subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                            body: """<p>Good news! The job <b>${env.JOB_NAME}</b> build <b>${env.BUILD_NUMBER}</b> succeeded.</p>""",
                            replyTo: 'noreply@learnfi.lk',
                            from: 'ekdvsampath02@gmail.com'
                      )
        }


        failure {
            emailext (
                            to: 'ekdvsampath02@gmail.com',
                            subject: "FAILURE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                            body: """<p>Unfortunately, the job <b>${env.JOB_NAME}</b> build <b>${env.BUILD_NUMBER}</b> failed.</p>""",
                            replyTo: 'noreply@learnfi.lk',
                            from: 'ekdvsampath02@gmail.com'
                      )
        }

    }


}