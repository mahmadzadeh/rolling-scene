package com.ui.rollingscene

import com.util.Timer

object StarClusterTimer extends Timer{

    private var lastClusterChangeTime:Long = 0

    override def setLastInvocationTime(t: Long): Unit = lastClusterChangeTime = t

    override def lastInvocationTime: Long = lastClusterChangeTime

    override val timerDelayInMillis: Long = 5000
}
