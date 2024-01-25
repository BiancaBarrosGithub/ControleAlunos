package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Aluno;
import com.projetojpa.repository.AlunoRepository;

@Service
public class AlunoService {
	private final AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno getAlunoById(Long id) {
		return alunoRepository.findById(id).orElse(null);
	}
	
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}
	
	public Aluno alterarAluno(Long id, Aluno alterarA) {
		Optional <Aluno> existeAluno = alunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			alterarA.setId(id);
			return alunoRepository.save(alterarA);
		}
		return null;
	}
	
	public void deleteAluno(Long id) {
		alunoRepository.deleteById(id);
	}
}
