package com.daftmobile.android4beginners4.robots.model


class ListRobotsDataSource: RobotsDataSource {//RobotsDtatSource to interfejs
    private val robots = mutableListOf<Robot>()

    override fun getRobots() = robots.toList()//lista robotow(niemutowalna)

    override fun addNew(robot: Robot) {//dodanie robota do listy
        robots.add(robot)
    }
    override fun sortRobots(dir: Boolean){
        if(dir){//jesli 1 to rosnaca
            robots.sortWith(object: Comparator<Robot>{
                override fun compare(p1: Robot, p2: Robot): Int = when {
                    p1.name[0] > p2.name[0] -> 1
                    p1.name[0] == p2.name[0] -> 0
                    else -> -1
                }
            })
        }
        else{//jesli nie to malejaca
            robots.sortWith(object: Comparator<Robot>{
                override fun compare(p1: Robot, p2: Robot): Int = when {
                    p1.name[0] < p2.name[0] -> 1
                    p1.name[0] == p2.name[0] -> 0
                    else -> -1
                }
            })
        }
    }
}
