package com.natiqhaciyef.kotlinandroidknowledges.kotlin.basics

/** Data types (English)
 * Kotlin dili Java dili kimi bir çox data tiplərə sahib proqramlaşdırma dilidir. İlkin olaraq data
 * tiplərin nə olduğunu anlamaq lazımdır. Data tiplər proqram çalışdığı zaman RAM üzərində müəyyən
 * informasiyanı saxlamaq üçün istifadə olunan strukturlardır. Bir çox proqramlaşdırma dillərində
 * mövcuddur.
 * Kotlində 2 əsas data tiplər mövcuddur: 1. Primitive 2. Non-Primitive
 *
 *      Tam ədəd tipi (numeric) -> Byte, Short, Int, Long    (Primitive)
 *      Həqiqi ədəd tipi (numeric) -> Float, Double    (Primitive)
 *      Simvol tipi -> Char      (Primitive)
 *      Məntiqi tip -> Boolean   (Primitive)
 *      Mətn tipi -> String    (Reference)
 *
 * */


/** Dəyişənlərin təyin olunması
 * Kotlin proqramlaşdırma dilində dəyişənlərin təyin olunması üçün 2 açar sözdən istifadə olunur:
 * var və val
 * Val - (value sözündən irəli gəlir) istifadəçi tərəfindən dəyişdirilə bilməyən və yalnız 1 dəfə
 * qiymət mənimsədilə bilən dəyişən tipidir. Bu dəyişənlərin bəzi hallarda const (sabit) dəyişənlərlə
 * səhv salırlar. Lakin eyni deyil. Sabit dəyərlərdən fərqli olaraq val dəyərləri funksiyadan gələn
 * return qiymətləri ilə dəyişmək mümkündür. Bu səbəbdən onlar open to modify prinsipi ilə çalışırlar.
 * Həmçinin val dəyərlər əsasən read-only prinsipində çalışır. (Run-Time scope)
 * Var - (variable sözündən irəli gəlie) istifadəçi tərəfindən dəyişdirilə bilən və istənilən qədər
 * dəyişdirilməyə açıq olan dəyişən tipidir. Var dəyərlər əsasən read & write prinsipi ilə çalışır.
 * (Run-Time scope)
 * Const val - sabit və heç bir şəkildə dəyişdirilə bilməyən dəyişən tipidir. Bu dəyişənlər
 * yalnız dəyər alır və həmin dəyərlər bütünlüklə sabit qalır. (Compile Time scope)
 * */

// main function for writing code, running and get result
fun main(){

    val i: Int = 12     // Non-smart cast
    val w = 12          // Smart cast

    var a = 44
    a = 22

}