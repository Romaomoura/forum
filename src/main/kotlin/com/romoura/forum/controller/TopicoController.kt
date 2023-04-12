package com.romoura.forum.controller

import com.romoura.forum.dto.TopicoInput
import com.romoura.forum.dto.TopicoOutput
import com.romoura.forum.dto.TopicoUpdateInput
import com.romoura.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(): List<TopicoOutput> {
        return service.listar()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun buscarPorId(@PathVariable id: Long): TopicoOutput {
        return service.buscarPorId(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody @Valid input: TopicoInput): TopicoOutput {
        return service.cadastrar(input)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid input: TopicoUpdateInput): TopicoOutput {
        return service.atualizar(id, input)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        return service.deletar(id)
    }


}