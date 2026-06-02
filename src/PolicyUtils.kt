fun isHighPriority(priority: Int): Boolean {
    return priority == 1 || priority == 2
}

fun formatPolicyName(policy: String): String {
    return "POLICY: ${policy.uppercase()}"
}

fun printPolicyStatus(status: String) {
    when (status) {
        "active"   -> println("Policy is ACTIVE and enforced!")
        "inactive" -> println("Policy is INACTIVE and not enforced.")
        "pending"  -> println("Policy is PENDING review.")
        else       -> println("Unknown policy status: $status")
    }
}

fun main() {

    println("--isHighPriority --")
    println("Priority 1: ${isHighPriority(1)}")   // true
    println("Priority 2: ${isHighPriority(2)}")   // true
    println("Priority 5: ${isHighPriority(5)}")   // false

    println()

    println("-- formatPolicyName --")
    println(formatPolicyName(policy ="firewall-rule-01"))
    println(formatPolicyName(policy ="network-access"))

    println()


    println("-- Policy Status --")
    printPolicyStatus("active")
    printPolicyStatus("inactive")
    printPolicyStatus("pending")
    printPolicyStatus("archived")   // default case

    println()

    println("-- Firewall Rules --")
    val firewallRules = listOf(
        "Allow-HTTP-Inbound",
        "Block-Telnet-Outbound",
        "Allow-HTTPS-Inbound",
        "Block-FTP-All",
        "Allow-SSH-Internal"
    )
    firewallRules.forEach { rule ->
        println("Rule: $rule")
    }

    println()

    println("-- Policy Map --")
    val policyMap = mapOf(
        "Corporate-Access-Policy" to "active",
        "Guest-Network-Policy"    to "inactive",
        "VPN-Access-Policy"       to "pending"
    )
    policyMap.forEach { (policyName, policyStatus) ->
        println("Policy: $policyName  |  Status: $policyStatus")
    }
}