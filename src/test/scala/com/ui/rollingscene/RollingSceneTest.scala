package com.ui.rollingscene

import java.awt.Point

import org.scalatest.FunSuite

import scala.collection.immutable.Queue

class RollingSceneTest extends FunSuite {

    val displayWindow = DisplayWindow(200, 100)
    val display  = ScreenCoverage(displayWindow)

    val chopper  = new Chopper(new Point, Velocity(2, 0), ChopperImages.imageList, displayWindow)
    val velocity = Velocity(-1, 0, 1)

    test("given a series of vertical bars then a rolling scene can be created") {
        new RollingScene(Hills(Queue.empty, display), chopper)
    }

    test("given a rolling scene when no bars then call to refresh adds the first bar") {
        val bars = Hills(Queue.empty, display)

        val rollingScene = new RollingScene(bars, chopper)

        assert(1 === rollingScene.refresh.hills.count)
    }

    test("given a rolling scene when not enough vertical bars on screen then call to refresh adds more bars") {
        assert(
            new RollingScene(Hills(Queue.empty, display, velocity), chopper)
            .refresh
            .refresh
            .refresh
            .refresh
            .refresh.hills.count > 0
        )
    }

    test("given a rolling scene then increaseChopperSpeed will increase the chopper's speed in X direction") {
        val rs = new RollingScene(Hills(Queue.empty, display, velocity), chopper)

        val fasterRollingScene = rs.increaseChopperSpeed

        assert(rs.chopper.velocity.velX + 1 === fasterRollingScene.chopper.velocity.velX)
        assert(rs.chopper.velocity.velY === fasterRollingScene.chopper.velocity.velY)
    }

    test("given a rolling scene then moveChopperDown will increment the chopper's speed in Y direction") {

        val rs = new RollingScene(Hills(Queue.empty, display, velocity), chopper)

        val fasterRollingScene = rs.moveChopperDown

        assert(rs.chopper.velocity.velY + 1 === fasterRollingScene.chopper.velocity.velY)
        assert(rs.chopper.velocity.velX === fasterRollingScene.chopper.velocity.velX)
    }

    test("given a rolling scene then moveChopperUp will decrement the chopper's speed in Y direction") {
        val rs = new RollingScene(Hills(Queue.empty, display, velocity), chopper)

        val sceneWithChopperMovingUp = rs.moveChopperUp

        assert(rs.chopper.velocity.velY - 1 === sceneWithChopperMovingUp.chopper.velocity.velY)
    }

    test("given a rolling scene then moveChopperDown will decrement the chopper's speed in X direction") {
        val rs = new RollingScene(Hills(Queue.empty, display, velocity), chopper)

        val sceneWithChopperMovingUp = rs.decreaseChopperSpeed

        assert(rs.chopper.velocity.velX - 1 === sceneWithChopperMovingUp.chopper.velocity.velX)
    }

}
