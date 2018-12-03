package objectorention

/**
 * 1.Groovy中默认都是public
 * 2.
 */
class Person implements DefaultAction{
    String name
    Integer age

    def increaseAge(Integer years) {
        this.name += years
    }

    @Override
    void eat() {

    }

    def methodMissing(String name,Object a) {
        return "the methed ${name} is missing"
    }


}


