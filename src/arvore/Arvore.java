package arvore;

public class Arvore {
	private NoArvore raiz;

	public Arvore() {
		raiz = null;
	}

	public NoArvore criaNo(int info) {
		NoArvore novo = new NoArvore(info);
		raiz = novo;
		return novo;
	}

	public void insereFilho(NoArvore pai, NoArvore filho) {
		filho.setProx(pai.getPrim());
		pai.setPrim(filho);
		raiz = pai;
	}

	@Override
	public String toString() {
		return imprime(raiz);
	}

	private String imprime(NoArvore noRaiz) {
		String s = new String("");
		s += "<";
		if (noRaiz != null) {
			s += noRaiz.getInfo();
			NoArvore noAtual = noRaiz.getPrim();
			while (noAtual != null) {
				s += imprime(noAtual);
				noAtual = noAtual.getProx();
			}
		}
		s += ">";
		return s;
	}

	public boolean pertence(int info) {
		return pertence(raiz, info);
	}

	private boolean pertence(NoArvore no, int info) {
		if (no == null)
			return false;

		return no.getInfo() == info || pertence(no.getPrim(), info) || pertence(no.getProx(), info);
	}

	public int altura() {
		return altura(raiz);
	}

	private int altura(NoArvore no) {
		int alturaMax = -1;
		if (no == null)
			return alturaMax;

		NoArvore noAtual = no.getPrim();
		while (noAtual != null) {
			int altura = altura(noAtual);
			if (altura > alturaMax) {
				alturaMax = altura;
			}
			noAtual = noAtual.getProx();
		}

		return alturaMax + 1;
	}

	public int pares() {
		return pares(raiz);
	}

	private int pares(NoArvore no) {
		if (no == null)
			return 0;
		int soma = no.getInfo() % 2 == 0 ? 1 : 0;
		NoArvore noAtual = no.getPrim();
		while (noAtual != null) {
			soma += pares(noAtual);
			noAtual = noAtual.getProx();
		}
		return soma;
	}

	public int folhas() {
		return folhas(raiz);
	}

	private int folhas(NoArvore no) {
		if (no == null)
			return 0;

		if (no.getPrim() == null)
			return 1;

		int folhas = 0;
		NoArvore noAtual = no.getPrim();
		while (noAtual != null) {
			folhas += folhas(noAtual);
			noAtual = noAtual.getProx();
		}
		return folhas;
	}

	public boolean igual(Arvore arv2) {
		return igual(raiz, arv2.raiz);
	}

	private boolean igual(NoArvore no1, NoArvore no2) {
		if (no1 == null && no2 == null)
			return true;

		if (no1 == null || no2 == null)
			return false;

		boolean igual = true;
		NoArvore noAtual1 = no1.getPrim();
		NoArvore noAtual2 = no2.getPrim();

		while (noAtual1 != null && noAtual2 != null && igual) {
			// verifica os nós raizes atuais e todos seus irmãos
			igual = noAtual1.getInfo() == noAtual2.getInfo() && igual(noAtual1, noAtual2);
			noAtual1 = noAtual1.getProx();
			noAtual2 = noAtual2.getProx();
		}

		// valida se os 2 estão nulos caso estejam são iguais, caso um não
		// esteja retornará falso
		return igual && noAtual1 == noAtual2;
	}

	public Arvore copia() {
		Arvore a = new Arvore();
		copia(a, raiz);
		return a;
	}

	private NoArvore copia(Arvore a, NoArvore no) {
		if (no == null)
			return null;
		
		NoArvore primCopia = null;
		NoArvore noCopia = null;
		
		NoArvore noAtual = no.getPrim();
		while (noAtual != null) {
			if (primCopia == null) {
				primCopia = copia(a,noAtual);
				noCopia = primCopia;
			} else {
				noCopia.setProx(copia(a,noAtual));
				noCopia = noCopia.getProx();
			}
			noAtual = noAtual.getProx();
		}
		NoArvore novo = a.criaNo(no.getInfo());
		if (primCopia != null) {
			novo.setPrim(primCopia);
		}

		return novo;
	}
}
