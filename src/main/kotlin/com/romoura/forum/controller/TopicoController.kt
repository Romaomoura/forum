package com.romoura.forum.controller

import com.romoura.forum.dto.TopicoInput
import com.romoura.forum.dto.TopicoOutput
import com.romoura.forum.dto.TopicoPorCategoriaOutput
import com.romoura.forum.dto.TopicoUpdateInput
import com.romoura.forum.service.TopicoService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    @Cacheable("topicos")// Apenas para fins didáticos, em produção essa forma é inviável
    @ResponseStatus(HttpStatus.OK)
    fun listar(
        @RequestParam(required = false) nomeCurso: String?,
        @PageableDefault(size = 5, sort = ["criadoEm", "titulo"], direction = Sort.Direction.DESC) p: Pageable
    ): Page<TopicoOutput> {
        return service.listar(nomeCurso, p)
    }

    @GetMapping("/{id}")
    @Cacheable("topico")
    @ResponseStatus(HttpStatus.OK)
    fun buscarPorId(@PathVariable id: Long): TopicoOutput {
        return service.buscarPorId(id)
    }

    @PostMapping
    @CacheEvict(value = ["topicos", "topico"], allEntries = true) // Limpando cache
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    fun cadastrar(@RequestBody @Valid input: TopicoInput): TopicoOutput {
        return service.cadastrar(input)
    }

    @PutMapping("/{id}")
    @CacheEvict(value = ["topicos", "topico"], allEntries = true)
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid input: TopicoUpdateInput): TopicoOutput {
        return service.atualizar(id, input)
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = ["topicos", "topico"], allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        return service.deletar(id)
    }

    @GetMapping("/relatorio")
    fun relatorio(): List<TopicoPorCategoriaOutput> {
        return service.relatorio()
    }

}