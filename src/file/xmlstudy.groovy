package file

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
println response.body.@id