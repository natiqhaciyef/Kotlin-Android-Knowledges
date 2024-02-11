package com.natiqhaciyef.kotlinandroidknowledges

fun main(){
// day works
    val dayOfWeek = workProgress(WeekDays.SATURDAY)
    println(dayOfWeek)

//cosmic object

    val Jupiter = Planets("Jupiter",343534.43,32322254.6,6)
    val Sun  = Stars("Sun",23123452345.43,32332566654.332,11)
    println(Jupiter.Response())
    println(Sun.Response())

//bank app
    while(true){

        print("please enter your name (if you want stop write to 'stop'):")
        val name = readLine()?.trim() ?: ""
        if (name.equals("stop", ignoreCase = true)) {
            break
        }
        print("please enter your surname (if you want stop write to 'stop'):")
        val surname = readLine()?.trim() ?: ""
        if (surname.equals("stop", ignoreCase = true)) {
            break
        }
        print("please enter your balance (if you want stop write to 'stop'):")
        val balance = readLine()?.toDoubleOrNull() ?: 0.0

        val createCustomer = Customer(name,surname,balance)
        customers.add(createCustomer)

        println("\nCustomer list:")
        customers.forEachIndexed{index,  customer ->
            println(" Welcome to bank. ID: ${index} Name: ${customer.name}, Surname: ${customer.surname}, Balance: ${customer.balance}")
        }

    }
}

//Calendar app
// @author Muhammed from abbTech
enum class WeekDays{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY,
}

sealed class DayWorks(){
    data class WorkGym(val result: String) : DayWorks()
    data class GoMasjid(val result: String) : DayWorks()
    data class RestDay(val result: String) : DayWorks()
}

fun workProgress(today:WeekDays):String{

    if(WeekDays.FRIDAY == today){

        val data = DayWorks.GoMasjid("${today.toString().lowercase()} we go to the Masjid")
        return data.result

    }else if (WeekDays.SATURDAY == today || WeekDays.SUNDAY == today){

        val data = DayWorks.RestDay( "${today.toString().lowercase()} is rest day")
        return data.result
    }else{
        val data =  DayWorks.WorkGym("${today.toString().lowercase()} is gym and work day")
        return data.result
    }

}

// COSMOS APP
// @author Muhammed from abbTech
interface CosmicObject{

    var size: Double
    var weight: Double
    var name: String
    fun SatelliteOrPlanetCount():Int {
        return 0
    }
    fun Response(){
        println("this object name: $name , size: $size, weight: $weight and satallite/planet count: ${SatelliteOrPlanetCount()}")
    }
}

data class Planets(val PlanetName:String,val planetWegiht:Double,val PlanetSize:Double,val satalliteCount:Int):CosmicObject{
    override var size = PlanetSize
    override var weight = planetWegiht
    override var name = PlanetName
    override fun SatelliteOrPlanetCount(): Int {
        return satalliteCount
    }

    override fun Response() {
        super.Response()
    }
}
data class Stars(val StarName:String,val StarWegiht:Double,val StarSize:Double,val PlanetCount:Int):CosmicObject{
    override var size = StarSize
    override var weight = StarWegiht
    override var name = StarName
    override fun SatelliteOrPlanetCount(): Int {
        return PlanetCount
    }

    override fun Response() {
        super.Response()
    }
}

// Bank app

var customers = ArrayList<Customer>()

data class Customer(val name:String,val surname:String,var balance:Double)