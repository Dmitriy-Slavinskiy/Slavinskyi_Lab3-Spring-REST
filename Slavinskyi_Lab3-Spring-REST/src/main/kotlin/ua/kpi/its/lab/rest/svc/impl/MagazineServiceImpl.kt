package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.MagazineRequest
import ua.kpi.its.lab.rest.dto.MagazineResponse
import ua.kpi.its.lab.rest.entity.Magazine
import ua.kpi.its.lab.rest.repository.MagazineRepository
import ua.kpi.its.lab.rest.svc.MagazineService

@Service
class MagazineServiceImpl(private val magazineRepository: MagazineRepository) : MagazineService {
    override fun createMagazine(magazineRequest: MagazineRequest): MagazineResponse {
        val magazine = Magazine(subject = magazineRequest.name, language = magazineRequest.address)
        val savedMagazine = magazineRepository.save(magazine)
        return MagazineResponse.fromEntity(savedMagazine)
    }

    override fun getMagazineById(id: Long): MagazineResponse {
        val magazine = magazineRepository.findById(id).orElseThrow()
        return MagazineResponse.fromEntity(magazine)
    }

    override fun updateMagazine(id: Long, magazineRequest: MagazineRequest): MagazineResponse {
        val magazine = magazineRepository.findById(id).orElseThrow()
        magazine.subject = magazineRequest.name
        magazine.language = magazineRequest.address
        val updatedMagazine = magazineRepository.save(magazine)
        return MagazineResponse.fromEntity(updatedMagazine)
    }

    override fun deleteMagazine(id: Long) {
        magazineRepository.deleteById(id)
    }
}