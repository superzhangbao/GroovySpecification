package file

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import objectorention.Person

/**
 * json操作
 */
//def list = [new  Person(name:'zb',age:26),
//            new Person(name: 'zj',age: 28)]
//def json = JsonOutput.toJson(list)
////println JsonOutput.prettyPrint(json)
//
//def jsonSlpuer = new JsonSlurper()

def response = getNetworkData("http://wanandroid.com/wxarticle/chapters/json ")
println response.data[0].name

def getNetworkData(String url) {
    //发送http请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text
    //将json转化为实体对象
    def jsluper = new JsonSlurper()
    return  jsluper.parseText(response)
}

