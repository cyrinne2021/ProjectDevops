pipeline {
    agent any
    tools {
    	maven 'M2_HOME'
    }
    stages {
       
        stage('Checkout GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'nizar', url: 'https://github.com/cyrinne2021/ProjectDevops.git'            }

        }
	    
	    stage('compiler') {
      		steps {
        		sh 'mvn compile'
      		}
    	}
	    stage('Build') {
      		steps {
        		sh 'mvn -B -DskipTests clean package'
      		}
    	}
	    
        stage('Testing maven') {
		    steps {
		    sh """mvn -version"""
	        }
	    }
	      /* stage("SonarQube Analysis") {
            steps {
              withSonarQubeEnv('SonarQube') {
                sh 'mvn clean -DskipTests package sonar:sonar'
              }
            }
          }*/
  /*stage("NEXUS") {
        	steps {
		 sh 'mvn clean -DskipTests deploy'
              }
        }*/
	    stage("TEST JUNIT"){
		steps{
		 sh'mvn test -DskipTests '
		}
		
	}
	    stage('Docker Image Build ') {
		    steps {
		      script{
			    sh 'docker build -t nizar1/backapp .'
		    }
		}
		}
		/*stage('Docker Image Push ') {
            steps {
            script {
		    sh 'docker login -u nizar1 -p azertyazerty' 
		    sh 'docker push nizar1/backapp'
		    }
	  
	   }  }*/
	       stage("Docker-Compose") {
                 steps {
                 sh 'docker-compose up'
                }
                }
	    
    }}
