package com.natiqhaciyef.technical_skills_kotlin.hackerrank.easy


fun countingValleys(steps: Int, path: String): Int {
    var seaLevel = 0
    var valleys = 0

    for (i in path) {
        if (i == 'U') {
            seaLevel += 1
        } else if (i == 'D') {
            if (seaLevel == 0)
                valleys += 1


            seaLevel -= 1

        }
    }


    return valleys
}
