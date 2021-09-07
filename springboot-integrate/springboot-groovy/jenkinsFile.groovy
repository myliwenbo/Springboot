/**
 * 还是执行源头
 * @return
 */
def start(branch) {
    sh 'pwd'
    gitCheckout(branch)
}

def gitCheckout(branch) {
    def apps = ""
    if (branch == "ALL" || branch == "") {
        apps = "dev,login".split(",")
    } else {
        apps = branch.split(",")
    }
    for (str in apps) {
        try {
            checkout([$class           : 'GitSCM',
                      branches         : [[name: "${str}"]],
                      extensions       : [[$class: 'RelativeTargetDirectory', relativeTargetDir: "/root/.jenkins/workspace/宁波-会议中心-前端/${str}"]],
                      userRemoteConfigs: [[credentialsId: 'liwenbo', url: 'http://39.98.35.128:8090/zhuking/center-vue.git']]])
        } catch (Exception exception) {
            println exception.message
        }
    }
}

def buid() {
    echo 'STEP 2：打包'
    sh label: '', script: '''npm install
		npm run build'''
}
return this
