package com.util

abstract class Timer {

    val timerDelayInMillis:Long
    def lastInvocationTime:Long
    def setLastInvocationTime(t:Long):Unit

    def isTime(now:Long):Boolean  = {
        if( now - lastInvocationTime >= timerDelayInMillis) {
            setLastInvocationTime(now)
            true
        }
        else false
    }

    def reset:Unit = setLastInvocationTime(0)
}
