package file

import objectorention.Person


/**
 * Groovy操作文本文件
 */
def file = new File('../../GroovySpecification.iml')
//file.eachLine {
//    line -> println line
//}

//def text = file.getText()
//println text

//def result = file.readLines()
//println result.toListString()

def reader = file.withReader {
    reader ->
        char[] buffer = new char[100]
        reader.read(buffer)
        return buffer
}
//println reader
def result = copy('../../GroovySpecification.iml', '../../GroovySpecification2.iml')
println result

def copy(String oldPath, String newPath) {
    try {
        //首先创建目标文件
        def desFile = new File(newPath)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        //开始拷贝
        new File(oldPath).withReader {
            reader ->
                def lines = reader.readLines()
                desFile.withWriter {
                    writer ->
                        lines.each {
                            line -> writer.append(line + "\r\n")
                        }
                }
        }
        return true
    } catch (Exception e) {

    }
}

/**
 * 对象的读写
 */
def person = new Person(name: "zhangbao",age: 22)
saveObject(person,'../../person.bin')
def p = (Person)readObj('../../person.bin')
println p
def saveObject(Object obj, String path) {
    try {
        //首先创建目标文件
        def desFile = new File(path)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        desFile.withObjectOutputStream {
            out ->
                out.writeObject(obj)
        }
        return true
    } catch (Exception e) {

    }
    return false
}

def readObj(String path) {
    def obj = null
    try {
        def file = new File(path)
        if (file == null || !file.exists()) return null
        file.withObjectInputStream {
            input ->
                obj = input.readObject()
        }
    } catch (Exception e) {

    }
    return obj
}
