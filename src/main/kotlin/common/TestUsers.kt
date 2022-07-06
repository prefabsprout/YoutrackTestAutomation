package common

interface User {
    val MAIL: String
    val PASSWORD: String
}

object RootUser: User {
    override val MAIL = "stephenpetrosian@gmail.com"
    override val PASSWORD = "deathnote42"
}

object MysteriousGuy: User {
    override val MAIL = "stephenpetrosian@gmail.com"
    override val PASSWORD = "deathnote"
}
