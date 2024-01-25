package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Aluno;
import com.projetojpa.service.AlunoService;



@RestController
@RequestMapping("/aluno")

public class AlunoController {
	private final AlunoService alunoService;
	
	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@PostMapping
	public Aluno createAluno (@RequestBody Aluno aluno) {
		return alunoService.saveAluno(aluno);
	}
	
	@GetMapping("/{id}")
	public Aluno getAluno(@PathVariable Long id) {
		return alunoService.getAlunoById(id);
	}
	
	@GetMapping
	public List<Aluno> getAllAlunos() {
		return alunoService.getAllAlunos();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> alteraAlunoControl(@PathVariable Long id, @RequestBody Aluno aluno ){
		Aluno alteraAluno = alunoService.alterarAluno(id, aluno);
		if(alteraAluno !=null) {
			return ResponseEntity.ok(aluno);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		alunoService.deleteAluno(id);
	}
	
	
}
