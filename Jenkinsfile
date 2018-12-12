pipeline {
	agent any
	tools{        
		maven 'maven'  
	       } 
	stages{
		stage('inicio'){
			steps{
				echo 'Estamos lanzando test de cucumber dentro de l granja AWS'
				}
		}
		stage('Construccion'){
			steps{
				bat 'mvn clean package -DskipTests=true'
				}
		}
 
		stage('Subo y lanzo test en AWS'){
			steps{
				devicefarm appArtifact: '**/src/apk/app-debug_2.apk', appiumJavaJUnitTest: '', appiumJavaTestNGTest: '**/zip-with-dependencies.zip', appiumPythonTest: '', appiumVersionJunit: '1.4.16', appiumVersionPython: '1.4.16', appiumVersionTestng: '1.7.2', calabashFeatures: '', calabashProfile: '', calabashTags: '', deviceLatitude: 47.6204, deviceLocation: false, deviceLongitude: -122.3941, devicePoolName: 'Maxam_Cucumber', environmentToRun: 'StandardEnvironment', eventCount: '', eventThrottle: '', extraData: false, extraDataArtifact: '', ifAppPerformanceMonitoring: true, ifBluetooth: true, ifGPS: true, ifNfc: true, ifVideoRecording: true, ifVpce: false, ifWebApp: false, ifWifi: true, ignoreRunError: false, isRunUnmetered: false, jobTimeoutMinutes: 5, junitArtifact: '', junitFilter: '', password: '', projectName: 'Maxam_Cucumber', radioDetails: false, runName: '${BUILD_TAG}', seed: '', storeResults: false, testSpecName: 'Default TestSpec for Android Appium Java Junit', testToRun: 'APPIUM_JAVA_TESTNG', uiautomationArtifact: '', uiautomatorArtifact: '', uiautomatorFilter: '', username: '', vpceServiceName: '', xctestArtifact: '', xctestFilter: '', xctestUiArtifact: '', xctestUiFilter: ''
			}
		}
	}
	post{
	    always{
		       echo 'Ha terminado el pipeline de pruebas en granja AWS'
			   }
		success{
		       echo 'Resultado:Ejecucion OK'
			   emailext attachLog: true, body: 'Ejecucion OK', compressLog: true, subject: 'Resultado pipeline', to: 'c.carles@ibermatica.com'
			}
		failure{
		       echo 'Resultado:Ejecucion KO'
			   emailext attachLog: true, body: 'Ejecucion KO', compressLog: true, subject: 'Resultado pipeline', to: 'c.carles@ibermatica.com'
			}
    }
}