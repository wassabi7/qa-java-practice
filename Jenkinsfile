pipeline {
    agent any

    tools {
        maven 'Maven-3.8.5'
        jdk 'OpenJDK-11'
    }

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-11-openjdk-amd64'
        PATH = "$JAVA_HOME/bin:$PATH"
        MAVEN_OPTS = "-Xmx2g"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        success {
            echo 'Build and Tests completed successfully'
        }
        failure {
            echo 'Build or Tests failed!'
        }
    }
}
