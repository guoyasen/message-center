node {


       env.work_dir="."
       stage('load'){
          sh "cp -f /${JENKINS_HOME}/script/build/Jenkinsfile-maven-global  ./Jenkinsfile-maven-global"
          load "./Jenkinsfile-maven-global"
       }
}
