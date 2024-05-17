package service;

import java.util.ArrayList;
import java.util.List;

import entities.Curso;

public class CursoService {

private List<Curso> cursos;

	public CursoService() {
		this.cursos = new ArrayList<Curso>();
		
		this.cursos.add(new Curso(1, "Bacharelado em Ciencia da Computacao", "Integral", 8));
		this. cursos.add(new Curso(2, "Tecnologia em Analise e Desenvolvimento de Sistemas", "Noturno", 6));
		this.cursos.add(new Curso(3, "Engenharia Mecanica", "Integral", 10));
		this.cursos.add(new Curso(4, "Licenciatura em Ciências Biologicas", "Integral", 8));
	}
	
	public List<Curso> buscarTodos() {
		return this.cursos;
	}
}