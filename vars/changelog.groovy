// vars/changelog.groovy
def call() {
    MAX_MSG_LEN = 100
    def changelog = ""

    echo "Gathering SCM changes"
    currentBuild.changeSets.each {
        changeSet ->
            ${changeSet}.items.each {
                item ->
                    changelog += " - ${item.msg.take[MAX_MSG_LEN]} [${item.author}]\n"
            }
    }

    if (!changelog) {
        changelog = " - No new changes"
    }

    return changelog
}
