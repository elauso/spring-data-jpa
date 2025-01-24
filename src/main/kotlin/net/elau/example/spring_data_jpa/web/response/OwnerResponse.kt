package net.elau.example.spring_data_jpa.web.response

import java.time.Instant

data class OwnerResponse(val id: Int, val name: String, val email: String, val createdAt: Instant)
