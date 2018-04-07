// vars/changelog.groovy
def call() {
    def changelog = ""

    echo "Gathering SCM changes"
    currentBuild.changeSets.each {
        changeSet ->
            changeSet.items.each {
                item ->
                    changelog += " - ${item.msg.split('\n')[0]} [${item.author}]\n"
            }
    }

    if (!changelog) {
        changelog = " - No new changes"
    }

    return changelog
}
