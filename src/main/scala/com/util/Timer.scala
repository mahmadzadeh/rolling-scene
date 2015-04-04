package com.util

abstract class Timer {

    val timerDelay:Long
    def lastInvocationTime:Long
    def setLastInvocationTime(t:Long):Unit

    def isTime(now:Long):Boolean  = {
        if( now - lastInvocationTime >= timerDelay) {
            setLastInvocationTime(now)
            true
        }
        else false
    }

    def reset:Unit = setLastInvocationTime(0)
}
