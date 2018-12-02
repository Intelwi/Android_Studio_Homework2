package com.daftmobile.android4beginners4.robots.model


class ListRobotsDataSource: RobotsDataSource {//RobotsDtatSource to interfejs
    private val robots = mutableListOf<Robot>()

    override fun getRobots() = robots.toList()//lista robotow(niemutowalna)

    override fun addNew(robot: Robot) {//dodanie robota do listy
        robots.add(robot)
    }
}
