package cn.danao.springboot.springbootkotlin.bean


//创建对象
class Person(var firstName: String, val lastName: String, var age: Int) {

    /**
     * 类内部方法
     */
    fun print() {
        println("Person { firstName = ${firstName}, lastName = ${lastName}, age = ${age} }")
    }

    //重写toString
    override fun toString(): String {
        return "Person{firstName = ${firstName},lastName = ${lastName},age = ${age}}\n"
    }
}

//当主构造函数的参数都有默认值时，自动生成一个无参构造函数。否则调用无参构造函数时报No value passed for parameter xxx
class PersonDefault(var firstName: String = "first", val lastName: String = "last", var age: Int = 0);


fun main() {
    var p1 = Person("李", "四", 23)
    p1.print();
    //属性没有默认值时 不能使用无参构造
    //var p:Person = Person()
    println(p1)
    //属性都设置了默认值时，可以使用无参构造
    var pd = PersonDefault()
    println("${pd?.lastName}${pd.firstName}")
    print("test")
}