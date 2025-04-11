package com.natiqhaciyef.technical_skills_kotlin.interview

fun simplifyPath(path: String): String {
    // read ..
    // read /
    // read ...
    // read .
    // read // or ///

    val stack = ArrayDeque<String>()
    var result = ""
    var index = 0
    var word= ""

    while(index < path.length){
        if(path[index] != '/'){
            word += path[index]
            stack.addLast("/")
        }else{
            stack.addLast(word)
            word = ""
        }

        index ++
    }

    if (word.isNotEmpty()){
        stack.addLast(word)
    }


    //       /home/user/Documents/../Pictures
    while(stack.isNotEmpty()){
        word = stack.removeFirst()

        if(result.isEmpty()){
            result += word
        }else {
            result = checkOperation(word, result)
            println(result)
        }
    }

    if (result.isNotEmpty() && result[result.length-1] == '/')
        result = result.removeRange(result.length -1, result.length)

    return result.ifEmpty { "/$result" }
}

fun checkOperation(stackResult: String, result: String): String {
    var current = result
    current = when(stackResult){
        ".." -> {
            while(current[current.length-1] != '/'){
                current = current.removeRange(current.length -1, current.length)
            }

            if (current[current.length -1] == '/')
                current = current.removeRange(current.length -1, current.length)

            if(current.isNotEmpty())
            while(current[current.length-1] != '/'){
                current = current.removeRange(current.length -1, current.length)
            }

            current
        }
        "/" -> {
            if (current[current.length -1]  != '/')
                current+= "/"

            current
        }
        "." -> result
        else -> "$result$stackResult"
    }

    return current
}

fun main() {
    println(simplifyPath("/home/user/Documents/../Pictures"))
    println("----")
    println(simplifyPath("/home/"))
    println("----")
    println(simplifyPath("/../"))
    println("----")
    println(simplifyPath("/../"))
    println("----")
    println(simplifyPath("/home//foo"))
}