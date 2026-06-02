// ─── DATA CLASS ───────────────────────────────────────────────────────────────
data class FirewallRule(
    val protocol: String,
    val port: Int,
    val sourceRange: String
)

// ─── FUNCTION BEING TESTED ────────────────────────────────────────────────────
fun shouldApplyRule(
    sourceIp: String,
    destinationPort: Int,
    protocol: String,
    rules: List<FirewallRule>
): Boolean {
    return rules.any { rule ->
        rule.protocol == protocol &&
                rule.port == destinationPort &&
                (rule.sourceRange == "ANY" || sourceIp.startsWith(rule.sourceRange))
    }
}

fun main() {

    // ══════════════════════════════════════════════════
    // TEST CASE 2 — HAPPY PATH
    // sourceRange = ANY should allow ANY ip through
    // ── EDIT THESE INPUTS ──────────────────────────
    val tc2_sourceIp = "10.0.0.1"
    val tc2_port = 80
    val tc2_protocol = "TCP"
    val tc2_rules = listOf(FirewallRule("TCP", 80, "ANY"))
    val tc2_result = shouldApplyRule(tc2_sourceIp, tc2_port, tc2_protocol, tc2_rules)
    println("TEST CASE 2 — sourceRange ANY")
    println("Input  → IP: $tc2_sourceIp | Port: $tc2_port | Protocol: $tc2_protocol")
    println("Result → $tc2_result  (expected: true)")
    println()

}