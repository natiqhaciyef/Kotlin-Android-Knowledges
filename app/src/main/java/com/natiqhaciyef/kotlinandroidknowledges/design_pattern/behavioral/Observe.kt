package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.behavioral


interface Observer {
    fun update(temperature: Float, humidity: Float)
}


interface WeatherStation {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}


class WeatherData : WeatherStation {
    private val observers = mutableListOf<Observer>()

    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { it.update(temperature, humidity) }
    }

    fun setMeasurements(temperature: Float, humidity: Float) {
        this.temperature = temperature
        this.humidity = humidity
        notifyObservers()
    }
}

class CurrentConditionsDisplay : Observer {
    override fun update(temperature: Float, humidity: Float) {
        println("Current conditions: $temperature F degrees and $humidity% humidity")
    }
}

class StatisticsDisplay : Observer {
    override fun update(temperature: Float, humidity: Float) {
        println("Average conditions: $temperature F degrees and $humidity% humidity")
    }
}

fun main() {
    val weatherData = WeatherData()
    val currentDisplay = CurrentConditionsDisplay()
    val statisticsDisplay = StatisticsDisplay()

    weatherData.addObserver(currentDisplay)
//    weatherData.addObserver(statisticsDisplay)

    weatherData.setMeasurements(78.0f, 65.0f)  // Output: Current conditions: 78.0 F degrees and 65.0% humidity
    weatherData.setMeasurements(74.0f, 51.0f)  // Output: Current conditions: 78.0 F degrees and 65.0% humidity
    weatherData.setMeasurements(63.3f, 44.5f)  // Output: Current conditions: 78.0 F degrees and 65.0% humidity
}


