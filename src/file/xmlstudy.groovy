package file

import groovy.xml.MarkupBuilder

import javax.management.StringValueExp

/**
 * xml解析
 */
final String xml = '''
<note>
<to>George</to>
<from>John</from>
<heading>Reminder</heading>
<body id = "1">Don't forget the meeting!</body>
</note>'''
def xmlSlurper = new XmlSlurper()
def response = xmlSlurper.parseText(xml)
//println response.body

/**
 * 生成xml格式数据
 */

def sw = new StringWriter()
def xmlBuilder = new MarkupBuilder(sw)//用来生成xml数据的核心类
//根节点langs创建成功
//xmlBuilder.langs(type: 'current', count: '3', mainstream: 'true') {
//    //第一个language节点
//    language(flavor: 'static', version: '1.5', 'java') {
//        age('16')
//    }
//    language(flavor: 'dynamic', version: '1.6', 'groovy')
//    language(flavor: 'dynamic', version: '1.9', 'js')
//}
def langs = new Langs()
xmlBuilder.langs(type: langs.type, count: langs.count, mainstream: langs.mainstream) {
    //遍历所有子节点
    langs.languages.each {
        lang -> language(flavor: lang.flavor,
                    version: lang.version,
                    lang.value)
    }
}

println sw
//对应xml中的langs节点
class Langs {
    String type = 'current'
    int count = 3
    boolean mainstream = true
    def languages = [new Language(flavor: 'static', version: '1.5', value: 'Java'),
                     new Language(flavor: 'dynamic', version: '1.6', value: 'Groovy'),
                     new Language(flavor: 'dynamic', version: '1.9', value: 'JS')]
}
//对应xml中的languages节点
class Language {
    String flavor
    String version
    String value
}
