pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build Application'
            }
        }
        stage('Test') {
            steps {
                echo 'Test Application'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy Application'
            }
        }
    }
    post{
        always {
            emailext body: 'this is sample body', subject: 'Pipeline Status', to: 'nirav.30890@gmail.com'
        }
    }
}
