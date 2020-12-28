pipeline {
   agent any
	
   tools {
      jdk "jdk9"
      maven 'mvn'
   }

   stages {
		stage('Checkout') {
            steps {
                checkout scm
            }
        }
      stage('Build') {
         steps {
            sh("mvn -Dmaven.test.failure.ignore=true clean package")
         }

         post {
            success {
		jacoco()
		junit '**/target/surefire-reports/TEST-*.xml'
	       archiveArtifacts 'target/*.jar'
            }
         }
      }
   }
}
