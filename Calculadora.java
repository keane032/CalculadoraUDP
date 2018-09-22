package com.br.sd.funcao;

public class Calculadora {

	private double total;

	public Calculadora() {
		this.total = 0.0;
		// TODO Auto-generated constructor stub
	}


	public void somar(double a) {
		this.total += a;
	}

	public void subtrair(double a) {
		this.total = this.total - a;
	}

	public void dividir(double a) {
		this.total = this.total / a;
	}

	public void multiplicar(double a) {
		this.total = a * this.total;
	}

	public void calcular(String array[]){
		this.total = Double.parseDouble(array[0]);

		for(int i=1; i<array.length;i+=1) {
			System.out.println(array[i]);

			if (array[i].equals("*")) {

				multiplicar(Double.parseDouble(array[i+1]));

			}else if (array[i].equals("/")) {

				dividir(Double.parseDouble(array[i+1]));

			}else if (array[i].equals("+")) {

				somar(Double.parseDouble(array[i+1]));

			}else if (array[i].equals("-")) {

				subtrair(Double.parseDouble(array[i+1]));			
			}

		}

	}
	
	public void calcIdade(String array[]) {
		String ano = array[1]+array[2]+array[3]+array[4];
		this.total = 2018 - (Double.parseDouble(ano));
	}
	
	
	public double getTotal() {
		return this.total;
	}

	public void servico(String array[]) {
		if (array[0].equals("$")) {
			calcIdade(array);
		}else {
			calcular(array);
		}
	}

}
