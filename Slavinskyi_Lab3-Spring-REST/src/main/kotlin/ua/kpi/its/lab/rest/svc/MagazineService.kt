package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.MagazineRequest
import ua.kpi.its.lab.rest.dto.MagazineResponse

interface MagazineService {
    fun createMagazine(magazineRequest: MagazineRequest): MagazineResponse
    fun getMagazineById(id: Long): MagazineResponse
    fun updateMagazine(id: Long, magazineRequest: MagazineRequest): MagazineResponse
    fun deleteMagazine(id: Long)
}