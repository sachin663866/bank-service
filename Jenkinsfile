  pipeline{
  agent any
  tools {
        maven 'MAVEN_HOME'
        jdk 'JAVA_HOME'
  }
  stages {
    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace... */
      steps {
        checkout scm
      }
    }
    stage('Build and Generate Docker Images') {
      steps {
        sh 'mvn -B -DskipTests clean package'
        sh 'echo $USER'
        sh 'echo whoami'
      }
    }
    stage('Push images to aws ecr'){
          steps {
            withDockerRegistry(credentialsId: 'ecr:us-east-1:aws-cred', url: 'http://656953382254.dkr.ecr.us-east-1.amazonaws.com/bank-service') {
             sh 'docker tag bank-service:latest 656953382254.dkr.ecr.us-east-1.amazonaws.com/bank-service'
             sh 'docker push 656953382254.dkr.ecr.us-east-1.amazonaws.com/bank-service'
            }
          }
    }
        stage('Run docker images on kubernetes cluster') {
          steps {
            node('eks-master-node'){    
              checkout scm
             sh 'git checkout master'
             sh 'export KUBECONFIG=~/.kube/config'
             sh 'aws eks --region us-east-1 update-kubeconfig --name terraform-eks-demo'
             sh 'kubectl apply -f deployment.yaml'
             sh 'kubectl apply -f service.yaml'
            }
          }
        }
    
  }
}
