pipeline {
    agent any  // Використовуємо будь-який агент для запуску pipeline

    tools {
        maven 'Maven-3.8.5' // Вказуємо версію Maven (зазначте, якщо Maven вже налаштований у Jenkins)
        jdk 'OpenJDK-11' // Вказуємо JDK для запуску проекту
    }

    environment {
        // Змінні середовища (якщо потрібно)
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
