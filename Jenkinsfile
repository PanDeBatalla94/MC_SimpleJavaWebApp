pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
	        sh './gradlew clean assemble'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
	        sh './gradlew test jacocoTestReport check'                
            }
        }

        stage('Code quality analysis...') {
            steps {
                echo 'sonarqube...'
	        sh './gradlew sonarqube'                
            }
        }
       

	
    }
    post {
        always {
            junit 'build/test-results/test/*.xml'
            publishHTML(target: [allowMissing: true, 
                         alwaysLinkToLastBuild: false,  
                         keepAll: true, 
                         reportDir: 'build/reports/tests/test', 
                         reportFiles: 'index.html', 
                         reportTitles: "Simple Report",
                         reportName: 'JUnit Test Reports'])

            publishHTML(target: [allowMissing: true, 
                         alwaysLinkToLastBuild: false,  
                         keepAll: true, 
                         reportDir: 'build/reports/checkstyle', 
                         reportFiles: 'main.html', 
                         reportTitles: "Checkstyle report",
                         reportName: 'CheckstyleReport'])

            publishHTML(target: [allowMissing: true, 
                         alwaysLinkToLastBuild: false,  
                         keepAll: true, 
                         reportDir: 'build/reports/findbugs', 
                         reportFiles: 'main.html', 
                         reportTitles: "Bugs Report",
                         reportName: 'BugReport'])

            publishHTML(target: [allowMissing: true, 
                         alwaysLinkToLastBuild: false,  
                         keepAll: true, 
                         reportDir: 'build/reports/pmd', 
                         reportFiles: 'main.html', 
                         reportTitles: "source code analyzer",
                         reportName: 'PmdReport'])

            publishHTML(target: [allowMissing: true, 
                        alwaysLinkToLastBuild: false, 
                        keepAll: true, 
                        reportDir: 'build/jacocoHtml', 
                        reportFiles: 'index.html',
                        reportTitles: "SimpleCov Report", 
                        reportName: 'JaCoCo Coverage Reports'])
        }
        success {
            archiveArtifacts artifacts: 'build/libs/*.war', fingerprint: true
        }
    }
}
