pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Pull code from your Git repository
                git url: 'https://github.com/gitober/TimeCalculator.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // Run Maven build
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run unit tests
                sh 'mvn test'
            }
            post {
                always {
                    // Publish JUnit test results
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Code Coverage') {
            steps {
                // Generate JaCoCo coverage report
                sh 'mvn jacoco:report'
            }
            post {
                always {
                    // Publish JaCoCo coverage report
                    jacoco execPattern: 'target/jacoco.exec', classPattern: 'target/classes', sourcePattern: 'src/main/java', inclusionPattern: '**/*.class'
                }
            }
        }
    }

    post {
        always {
            // Cleanup workspace
            cleanWs()
        }
    }
}
