pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/gitober/TimeCalculator', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // Use 'bat' for Windows, 'sh' for Unix-based systems
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
    }

    post {
        always {
            // Publish JUnit test results
            junit '**/target/surefire-reports/*.xml'

            // Publish JaCoCo code coverage report
            jacoco execPattern: '**/target/jacoco.exec',
                   classPattern: '**/target/classes',
                   sourcePattern: '**/src/main/java',
                   inclusionPattern: '**/*.class'
        }
    }
}