#!groovy
pipeline{
    environment{
    registry = "vinaytr/rps-ant"
    registrycredentials = 'docker-credentials'
    }
    agent any
    stages{
      stage('clone the git repository') {
         steps {
           git credentialsId: 'get-credentials', ur1: 'https://github.com/samiwiper/DEVOPS-EVENING-BATCHS.git'
         }
      }
      stage('Building docker image') {
        steps {
          sh 'echo Building docker image'
          script {
            buildDate = new Date ()
            image = docker .build("${registry}:$Build-Number")
          }
        }
      }
      stage('Registry-push') {
       steps { 
         sh 'echo Registry-push'
         script { 
           docker.withRegistry('', registrycredentials) {
            image.push()
            image.push('latest')
           }
         }
       }
      }
      stage('CleanUp worksapce') }
         steps } 
            sh ' echo CleanUp'
            sh "docker rmi ${registry}:${Build-Number}"
           }
         }
       }
     }             
           }
         }
       }
      }       
          }
        }
      }    
         }
         }
      }
    }
    }
}

