package ua.kpi.its.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.MagazineResponseDto
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
    public ResponseEntity<MagazineResponseDto> getmagazineById(@PathVariable Long id) throws ResourceNotFoundException
    {
        MagazineResponseDto magazineResponseDto = magazineService . getMagazineById (id);
        if (magazineResponseDto == null) {
            throw new ResourceNotFoundException ("Magazine with id " + id + " not found");
        }
        return ResponseEntity.ok(magazineResponseDto);
    }

    @GetMapping("/")
    open fun getAllHospitals(): ResponseEntity<MutableList<MagazineResponseDto?>?>? {
        val magazineResponseDtos: kotlin.collections.List<MagazineResponseDto> = magazineService.getAllHospitals()
        return ResponseEntity.ok<kotlin.collections.List<MagazineResponseDto>>(magazineResponseDtos)
    }

    @PostMapping("/")
    fun createMagazine(@Valid @RequestBody magazineRequestDto: MagazineRequestDto?): ResponseEntity<MagazineResponseDto>? {
        val hospitalResponseDto: MagazineResponseDto = magazimeService.createHospital(magazineRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED).body<MagazineResponseDto>(magazineResponseDto)
    }

    @PutMapping("/{id}")
    @Throws(ResourceNotFoundException::class)
    fun updateMagazine(
        @PathVariable id: Long,
        @Valid @RequestBody magazineRequestDto: MagazineRequestDto?
    ): ResponseEntity<MagazineResponseDto>? {
        val magazineResponseDto: MagazineResponseDto = magazineService.updateMagazine(id, magazineRequestDto)
            ?: throw ResourceNotFoundException("Magazine with id $id not found")
        return ResponseEntity.ok<MagazineResponseDto>(magazineResponseDto)
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