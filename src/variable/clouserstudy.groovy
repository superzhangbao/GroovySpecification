package variable
/**
 * Groovy闭包学习
 */
//def clouser = {println  "Hello ${it}！"}
//def result = clouser("caonima")
//println result

/******************************基本类型与闭包的结合使用****************/
//用来求指定numer的阶乘
int fab(int number) {
    int result = 1
    1.upto(number, { num -> result *= num })
    return result
}
//println fab(5)
/**
 * 阶乘
 */
int fab2(int number) {
    int result = 1
    number.downto(1) {
        num -> result *= num
    }
    return result
}
//println fab2(5)
/**
 * 累加
 */
int cal(int number) {
    int result = 0
    number.times {
        num -> result += num
    }
    return result
}
//println cal(100)

/*************************************String与闭包的结合使用**************************/
/*String str = 'the 2 and 3 is 5'
//each的遍历
println str.each {
//    String temp -> print temp
}

//find来 查找符合条件的第一个
println str.find {
    String s -> s.isNumber()
}

println str.findAll{String s->s.isNumber()}.toListString()

println str.any {
    String s -> s.isNumber()
}

println str.every {
    String s->s.isNumber()
}

println str.collect {
    it.toUpperCase()
}.toString()*/

/***********************************闭包的三个重要变量：this，owner，delegate************/

/*def clouser = {
    println "clouser this:" + this//代表闭包定义处的类
    println "clouser owner:" + owner//代表闭包定义处的类或者对象
    println "clouser delegate:" + delegate//任意一个第三方对象，默认与owner一致
}
clouser.call()*/
/**
 * clouser this:variable.clouserstudy@3d5c822d
 * clouser owner:variable.clouserstudy@3d5c822d
 * clouser delegate:variable.clouserstudy@3d5c822d
 */

//定义了一个 内部类
class Person {
    def classClouser = {
        println "classClouser this:" + this//代表闭包定义处的类
        println "classClouser owner:" + owner//代表闭包定义处的类或者对象
        println "classClouser delegate:" + delegate//任意一个第三方对象，默认与owner一致
    }

    def say() {
        def classClouser = {
            println "methodClassClouser this:" + this//代表闭包定义处的类
            println "methodClassClouser owner:" + owner//代表闭包定义处的类或者对象
            println "methodClassClouser delegate:" + delegate//任意一个第三方对象，默认与owner一致
        }
        classClouser.call()
    }
}

Person p = new Person()
//p.classClouser.call()
//p.say()
/**
 * classClouser this:variable.Person@6d4e5011
 * classClouser owner:variable.Person@6d4e5011
 * classClouser delegate:variable.Person@6d4e5011
 * methodClassClouser this:variable.Person@6d4e5011
 * methodClassClouser owner:variable.Person@6d4e5011
 * methodClassClouser delegate:variable.Person@6d4e5011
 */

//闭包中定义一个闭包
def nestClouser = {
    def innerClouser = {
        println "innerClouser this:" + this//代表闭包定义处的类
        println "innerClouser owner:" + owner//代表闭包定义处的类或者对象
        println "innerClouser delegate:" + delegate//任意一个第三方对象，默认与owner一致
    }
    innerClouser.delegate = p
    innerClouser.call()
}
//nestClouser.call()


/**
 * 闭包的委托策略
 */
class Student {
    String name
    def pretty = {"My 职业 is ${doSomeThing()}"}

    String toString() {
        pretty.call()
    }

    String doSomeThing() {
        return "student"
    }
}

class Teacher {
    String  name1

    String doSomeThing() {
        return "teacher"
    }
}

def stu = new Student(name: "张宝")
def tea = new Teacher(name1: "老师")

stu.pretty.delegate = tea
stu.pretty.resolveStrategy = Closure.OWNER_FIRST
println stu.toString()
