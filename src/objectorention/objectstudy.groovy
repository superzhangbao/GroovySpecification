package objectorention

/**
 * 无论你是直接.还是get/set最终都是调用get/set
 */
//def person = new Person(name: 'zhangbao',age: 26)
//person.c()
ExpandoMetaClass.enableGlobally()
//为类动态添加一个属性
Person.metaClass.sex = 'male'
//def person = new Person(name: 'zhangbao',age: 26)
//println person.sex
//
//person.sex = 'female'
//println person.sex
//为类动态添加方法
Person.metaClass.nameUpperCase = { -> sex.toUpperCase() }
//def person2 = new Person(name: 'zhangbao', age: 26)
//println person2.nameUpperCase()

//为 类动态的添加静态方法
Person.metaClass.static.createPerson = {
    String name,int age -> new Person(name: name,age: age
    )
}
def person3 = Person.createPerson("zhangbao",26)
println person3.name+"_and_"+person3.age