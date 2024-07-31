pipeline {
	agent any
	stages {
		stage("build") {
			steps {
				bat "mvn clean test"
				
			}
			}
		stage("package") {
			steps {
				bat "mvn package"
				
			}
			}
		stage("Consolidate Results") {
			steps {
				input ("Do you want to capture results?")
				junit '**/target/surefire-reports/TEST-*.xml'
				archive 'target/*.jar'
			}
		
	}
		stage("mail") {
			steps {
				mail body: "${env.JOB_NAME}  - Build # ${env.BUILD_NUMBER}  - ${currentBuild.currentResult} \n\nCheck console output at ${env.BUILD_URL} to view the results.", subject: "${env.JOB_NAME}  - Build # ${env.BUILD_NUMBER}  - ${currentBuild.currentResult}!!", to: 'deepika9785@gmail.com'
			}
		
	}
		}
		
}
