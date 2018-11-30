package variable
/**
 * Groovy字符串学习
 */

def name = 'a single \'a\' string'

println name

def name1 = '''three single string'''
println name1

//可以按照格式打印
def name2 = '''\
a
b            x
c'''
println name2

def name3 = "this a common String"

def name4 = "${name3}臭傻逼"
println name4

def sum = "sum of 2 and 3 ==${2+3}"
println sum

def rest = echo(sum)
println rest

String echo(String msg) {
    return msg
}

/***********************************字符串的方法*************************/
def str = "groHelloovy"
//println str.center(8,'a')

//println str.padLeft(8,'a')

def str2 = 'Hello'
//println str == str2
println str[0]
println str[0..3]
println str - str2
println str.reverse()//反转
println str.capitalize()//首字母大写
println str.isNumber()//判断是不是数字型字符串
