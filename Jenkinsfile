node {
    def WORKSPACE = "/var/lib/jenkins/workspace/repository-test"
    def dockerImageTag = "repository-test${env.BUILD_NUMBER}"

    try {
         //notifyBuild('STARTED')
         stage('Clone Repo') {
            // for display purposes
            // Get some code from a GitHub repository
            git url: 'https://github.com/DavidJS6/repository-test.git',
                //credentialsId: 'springdeploy-user',
                branch: 'master'
         }
          stage('Build docker') {
                 dockerImage = docker.build("repository-test:${env.BUILD_NUMBER}")
          }

          stage('Deploy docker') {
                  echo "Docker Image Tag Name: ${dockerImageTag}"
                  sh "docker stop repository-test || true && docker rm repository-test || true"
                  //sh "docker run --name repository-test -d -p 8282:8282 repository-test:${env.BUILD_NUMBER}"
                  //sh "docker run --name repository-test --restart=on-failure --detach --network jenkins --env DOCKER_HOST=tcp://docker:2376 --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1 -d -p 8282:8282 --volume jenkins-data:/var/jenkins_home --volume jenkins-docker-certs:/certs/client:ro repository-test:${env.BUILD_NUMBER}"
                  sh "docker run --name repository-test --restart=on-failure --detach -d -p 8282:8282 repository-test:${env.BUILD_NUMBER}"
                  //bat "docker stop repository-test || true && docker rm repository-test || true"
                  //bat "docker run --name repository-test --restart=on-failure --detach -d -p 8282:8282 repository-test:${env.BUILD_NUMBER}"
          }
    } catch(e) {
        //currentBuild.result = "FAILED"
        throw e
    } finally {
        //notifyBuild(currentBuild.result)
    }
}
/*
def notifyBuild(String buildStatus = 'STARTED'){

  // build status of null means successful
  buildStatus =  buildStatus ?: 'SUCCESSFUL'
  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def now = new Date()
  // message
  def subject = "${buildStatus}, Job: ${env.JOB_NAME} FRONTEND - Deployment Sequence: [${env.BUILD_NUMBER}] "
  def summary = "${subject} - Check On: (${env.BUILD_URL}) - Time: ${now}"
  def subject_email = "Spring boot Deployment"
  def details = """<p>${buildStatus} JOB </p>
    <p>Job: ${env.JOB_NAME} - Deployment Sequence: [${env.BUILD_NUMBER}] - Time: ${now}</p>
    <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME}</a>"</p>"""


  // Email notification
    emailext (
         to: "admin@gmail.com",
         subject: subject_email,
         body: details,
         recipientProviders: [[$class: 'DevelopersRecipientProvider']]
       )
}
*/
