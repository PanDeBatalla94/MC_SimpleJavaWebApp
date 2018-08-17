pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
	            sh './gradlew clean assemble'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'build/libs/*.war', fingerprint: true
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
	            sh './gradlew test jacocoTestReport check'                
            }
            post {
                success {
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
                
            }
        }

        stage('Code quality analysis...') {
            steps {
                echo 'Running sonnar...'
	            sh './gradlew sonarqube'                
            }
        }

        stage('Deploy') {  

            steps {               
                echo 'Deploying ...'
                sh './gradlew -b deploy.gradle deploy -Pdev_server=10.28.135.235 -Puser_home=/home -Pwar_path=build/libs'
        
            }
                   
        }

        stage('Acceptance') {  

            steps {               
                echo 'Reports ...'
                sh './acceptance/gradlew clean test -p acceptance'
            }
            post {
                success {
                    publishHTML(target: [allowMissing: true, 
                                alwaysLinkToLastBuild: false,  
                                keepAll: true, 
                                reportDir: 'acceptance/build/reports/cucumber-html-reports', 
                                reportFiles: 'report-feature_gradle-cucumber-features-gradle-feature.html', 
                                reportTitles: "Cucumber complete Report",
                                reportName: 'Cucumber complete Report'])

                                        
                }
                
            }
                   
        }
    }
    
}
