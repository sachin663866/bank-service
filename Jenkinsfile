pipeline {
  agent any
  tools { 
        jdk 'JAVA_HOME'
        maven 'Maven'
  }
  stages {
    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace... */
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Docker Build') {
      steps {
        sh '/usr/bin/docker build -t bank-service .'
      }
    }
  stage('Docker Run') {
      steps {
         sh 'nohup /usr/bin/docker run -t --name bank-container -p 8458:8458 bank-service &'
      }
    } 
  }
}
