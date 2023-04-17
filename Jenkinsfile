pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        
        stage("SCM Checkout"){
            steps{
            git url: 'https://github.com/SaileshRouth9405/food.git',branch:'main' 
            }
        }
         stage("Sonar")
        {
            steps {
                 checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '598e5ddb-e26e-43cc-8450-c4f82bc8a5e0', url: 'https://github.com/SaileshRouth9405/food.git']])
           bat 'mvn sonar:sonar'
            }
        }
        stage("Maven Build"){
            steps{
                 checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '598e5ddb-e26e-43cc-8450-c4f82bc8a5e0', url: 'https://github.com/SaileshRouth9405/food.git']])
                bat 'mvn clean package'
            }
        }
        stage("Docker Image"){
            steps{
                 
                // bat 'cd C:/Users/ROYAL/.jenkins/workspace/springboot-food-pipeline'
                bat 'docker build -f Dockerfile -t sailesh.jar .'
            }
        }
        stage("Docker Run")
        {
        steps{
              bat 'docker run -p 9092:8085 --network=springboot-mysql-net -d sailesh.jar'
            }
        }
    }
}