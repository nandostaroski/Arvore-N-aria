package arvore;

public class ArvoreMain {
	public static void main(String[] args) {
		Arvore a = new Arvore();
		//imprime as estatisticas da arvore vazia
		System.out.println(a);
		System.out.println("Altura " + a.altura());
		System.out.println("Pares " + a.pares());
		System.out.println("Folhas " + a.folhas());
		
		// cria os nós
		NoArvore n1 = a.criaNo(1);
		NoArvore n2 = a.criaNo(2);
		NoArvore n3 = a.criaNo(3);
		NoArvore n4 = a.criaNo(4);
		NoArvore n5 = a.criaNo(5);
		NoArvore n6 = a.criaNo(6);
		NoArvore n7 = a.criaNo(7);
		NoArvore n8 = a.criaNo(8);
		NoArvore n9 = a.criaNo(9);
		NoArvore n10 = a.criaNo(10);
		
		// insere os filhos
		a.insereFilho(n4, a.criaNo(6));
		a.insereFilho(n4, a.criaNo(9));
		a.insereFilho(n5, a.criaNo(6));
		a.insereFilho(n4, a.criaNo(9));
		a.insereFilho(n3, n4);
		a.insereFilho(n2, n5);
		a.insereFilho(n2, n3);
		a.insereFilho(n9, n10);
		a.insereFilho(n7, n9);
		a.insereFilho(n7, n8);
		a.insereFilho(n1, n7);
		a.insereFilho(n1, n6);
		a.insereFilho(n1, n2);
		a.insereFilho(a.criaNo(50), n1);
		
		// imprime as estatisticas da arvore populada
		System.out.println(a);
		System.out.println("Altura " + a.altura());
		System.out.println("Pares " + a.pares());
		System.out.println("Folhas " + a.folhas());
		
		// cria a arvore
		Arvore a2 = new Arvore();
		
		// cria os nós
		NoArvore n11 = a2.criaNo(1);
		NoArvore n12 = a2.criaNo(2);
		NoArvore n13 = a2.criaNo(3);
		NoArvore n14 = a2.criaNo(4);
		NoArvore n15 = a2.criaNo(5);
		NoArvore n16 = a2.criaNo(6);
		NoArvore n17 = a2.criaNo(7);
		NoArvore n18 = a2.criaNo(8);
		NoArvore n19 = a2.criaNo(9);
		NoArvore n110 = a2.criaNo(10);
		
		// insere os filhos
//		a2.insereFilho(n14, a2.criaNo(6));
//		a2.insereFilho(n14, a2.criaNo(9));
//		a2.insereFilho(n15, a2.criaNo(6));
//		a2.insereFilho(n14, a2.criaNo(9));

		a2.insereFilho(n13, n14);
		a2.insereFilho(n12, n15);
		a2.insereFilho(n12, n13);
		a2.insereFilho(n19, n110);
		a2.insereFilho(n17, n19);
		a2.insereFilho(n17, n18);
		a2.insereFilho(n11, n17);
		a2.insereFilho(n11, n16);
		a2.insereFilho(n11, n12);
//		a2.insereFilho(a2.criaNo(50), n11);
		
		System.out.println("a1.igual(a2) " +a.igual(a2));
		
		Arvore a3 = a2.copia();
		
		System.out.println(a2);
		System.out.println(a3);
	
	}
	
	
}
