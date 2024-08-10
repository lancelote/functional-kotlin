package ch09

import kotlin.random.Random
import kotlin.system.measureTimeMillis

class PrimeAccessRepository(primeAccessList: PrimeAccessList) {
    private val allowUsers = primeAccessList.entries.associate { it.userId to it.allowList }
    private val denyUsers = primeAccessList.entries.associate { it.userId to it.denyList }

    fun isOnAllowList(userId: String): Boolean = userId in allowUsers
    fun isOnDenyList(userId: String): Boolean = userId in denyUsers
}

class PrimeAccessList(val entries: List<PrimeAccessEntry>)

class PrimeAccessEntry(
    val userId: String,
    val allowList: Boolean,
    val denyList: Boolean,
)

fun main() {
    val entries = List(200_000) {
        PrimeAccessEntry(
            userId = it.toString(),
            allowList = Random.nextBoolean(),
            denyList = Random.nextBoolean()
        )
    }.shuffled()
    val accessList = PrimeAccessList(entries)

    val repo: PrimeAccessRepository
    measureTimeMillis {
        repo = PrimeAccessRepository(accessList)
    }.also { println("Class creation took $it ms") }

    measureTimeMillis {
        for (userId in 1L..10_000L) {
            repo.isOnAllowList(userId.toString())
        }
    }.also { println("Operation took $it ms") }

    measureTimeMillis {
        for (userId in 1L..10_000L) {
            repo.isOnDenyList(userId.toString())
        }
    }.also { println("Operation took $it ms") }
}
