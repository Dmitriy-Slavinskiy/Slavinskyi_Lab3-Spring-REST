package ua.kpi.its.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.MagazineResponse
import ua.kpi.its.lab.rest.dto.MagazineRequest
import ua.kpi.its.lab.rest.exception.ResourceNotFoundException
import javax.validation.Valid


@RestController
@RequestMapping("/api/magazines")
public class MagazineController {

    private final MagazineService magazineService;

    @Autowired
    public MagazineController(MagazineService magazineService)
    {
        this.magazineService = magazineService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MagazineResponse> getmagazineById(@PathVariable Long id) throws ResourceNotFoundException
    {
        MagazineResponse magazineResponseDto = magazineService . getMagazineById (id);
        if (magazineResponse == null) {
            throw new ResourceNotFoundException ("Magazine with id " + id + " not found");
        }
        return ResponseEntity.ok(magazineResponse);
    }

    @GetMapping("/")
    open fun getAllHospitals(): ResponseEntity<MutableList<MagazineResponse?>?>? {
        val magazineResponseDtos: kotlin.collections.List<MagazineResponse> = magazineService.getAllHospitals()
        return ResponseEntity.ok<kotlin.collections.List<MagazineResponse>>(magazineResponseDtos)
    }

    @PostMapping("/")
    fun createMagazine(@Valid @RequestBody magazineRequestDto: MagazineRequest?): ResponseEntity<MagazineResponse>? {
        val magazineResponse: MagazineResponse = magazimeService.createMagazine(magazineRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED).body<MagazineResponse>(magazineResponse)
    }

    @PutMapping("/{id}")
    @Throws(ResourceNotFoundException::class)
    fun updateMagazine(
        @PathVariable id: Long,
        @Valid @RequestBody magazineRequestDto: MagazineRequest?
    ): ResponseEntity<MagazineResponse>? {
        val magazineResponseDto: MagazineResponse = magazineService.updateMagazine(id, magazineRequestDto)
            ?: throw ResourceNotFoundException("Magazine with id $id not found")
        return ResponseEntity.ok<MagazineResponse>(magazineResponseDto)
    }

    @DeleteMapping("/{id}")
    @Throws(ResourceNotFoundException::class)
    fun deleteMagazine(@PathVariable id: Long): ResponseEntity<Void?>? {
        val isDeleted: Boolean = magazineService.deleteMagazine(id)
        if (!isDeleted) {
            throw ResourceNotFoundException("Magazine with id $id not found")
        }
        return ResponseEntity.noContent().build()
    }
}