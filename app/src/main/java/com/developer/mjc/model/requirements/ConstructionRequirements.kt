package com.developer.mjc.model.requirements

import java.io.Serializable

data class ConstructionRequirements(val userId: String,
                                    val plan: String,
                                    val totalArea: Float,
                                    val buildingArea: Float,
                                    val selectedEngineerId: String): Serializable