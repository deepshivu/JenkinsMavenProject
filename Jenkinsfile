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
		}
		
}
