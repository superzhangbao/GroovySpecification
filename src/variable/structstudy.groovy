package variable

/**
 * Groovy逻辑控制学习
 */
def x = 1.23
def result
switch (x) {
    case 'foo':
        result = 'found foo'
        break
    case 'bar':
        result = 'bar'
        break
    case [1.23,4,5,6,'inlist']:
        result = 'list'//列表
        break
    case 12..30:
        result = 'range'//范围
        break
    case Integer:
        result = 'integer'
        break
    case BigDecimal:
        result = 'big decimal'
        break
}
println result

//对范围的for循环
def sum = 0
for (i in 0..9) {
    sum+=i
}
println sum

//对list的循环
for (i in [1,2,3,4,5,6]) {
    sum +=i
}

//对map进行循环
for(i in ['lili':1,'lucy':2,'zhangbao':3]) {
    sum +=i.value
}
println sum
