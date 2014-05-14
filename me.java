  public void back(Solucio s, int x){
     if ( s.esCompleta()){
    
	float p = s.puntuacio();
	if ( p < mejor_cota ){
	
	    mejor = s;
	    mejor_cota = p;
	}
    }	
    else // No es completa
    {
	float cotalevel = 0;
	for (int i=0; i<s.size();i++ ) { /* assigna a todos los libros sin assignar la proxima posicion(proxima posicion=numassig).*/
                if (s.posicio(i)== -1) {
                    Solucio s2 = new Solucio(s);// Seguro que el constructor no es necesario?
                    //s2.copia(s);
                    s2.afegir(i,x);
                    s2.setCota(boundcota.CalculBound(matriuDistancia, matriuFluxe, s2, LowerBound.OTHERS));
                    if(x == 0) System.out.print(s2.getCota()+ " ");
                    if ( s2.getCota() < mejor_cota ){
                        cotalevel = s2.getCota();
                        back(s2, x+1);
                    }//C.push(s2);
                }
        }
	
    }
  }
