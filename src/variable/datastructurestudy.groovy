package variable

/**
 * Groovy中的列表，映射，范围
 * 列表的排序
 */
def list = [6, -3, 9, 2, -7, 1, 5]
Collections.sort(list)
println list

Comparator c = new Comparator() {
    @Override
    int compare(Object o1, Object o2) {
        if (Math.abs(o1) < Math.abs(o2))
            return -1
        else
            return 1
    }
}
Collections.sort(list, c)
println list

list.sort()
println list

/***********************************map****************************/

def map = []
map.b = 2
map.c = 3
println map.toMapString()
