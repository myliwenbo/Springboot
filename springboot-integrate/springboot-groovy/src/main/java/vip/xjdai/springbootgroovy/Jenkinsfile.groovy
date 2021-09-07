/**
 * 还是执行源头
 * @return
 */
def start(branch) {
    sh 'pwd'
    println branch
//    gitCheckout(branch)
}

def gitCheckout(branch) {
    def apps = ""
    if (apps == "ALL") {
        apps = "dev,login".split(",")
    } else {
        apps = branch.split(",")
    }
    for (str in apps) {
        try {
            checkout([$class                             : 'GitSCM'
                      , branches                         : [[name: '$str']]
                      , doGenerateSubmoduleConfigurations: false
                      , extensions                       : []
                      , userRemoteConfigs                : [[credentialsId: 'liwenbo', url: 'http://39.98.35.128:8090/zhuking/center.git']]])
        } catch (Exception exception) {
            println exception.message
        }
    }
}

def buid() {

}

return this
