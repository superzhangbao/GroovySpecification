package objectorention
/**
 * 展示如何在全局使用为第三方类注入的方法
 */
class Entry {
    static void main(def args) {
        println "应用程序正在启动"
        //初始化
        ApplicationManager.init()
        println "应用程序初始化完成"
        def person = PersonManager.createPerson("zhangbao",26)
        println "person name is ${person.name},and age is ${person.age}"
    }
}
