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
       stage('SonarQube analysis') {
		        steps {
		        withSonarQubeEnv('SonarQube') {
		        sh 'mvn clean clean -DskipTests package sonar:sonar'
	                  }
	                }
	            }


             stage("NEXUS") {
        	    steps {
		        sh 'mvn clean deploy -DskipTests'
                      }
                }
    }}
