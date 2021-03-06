dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "remembrall"
include(":app")
include(":common-ui")
include(":task-list")
include(":common")
include(":common-auth")
include(":task-detail")
include(":common-gettask")
include(":profile")
include(":common_calendar")
include(":common-schedule")
include(":splash")
include(":task-edit")
include(":common-addedit")
include(":task-add")
include(":login")
include(":common-task")
include(":checklist-list")
include(":home")

enableFeaturePreview("VERSION_CATALOGS")
include(":checklist-add")
include(":common-checklist")
include(":checklist-detail")
